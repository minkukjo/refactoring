import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File
import java.text.NumberFormat
import java.util.Locale
import kotlin.math.floor

fun statement(invoice: Invoice, plays: Map<String, Play>): String {

    fun amountFor(performance: Performance): Int {
        var result = 0
        when (performance.play?.type) {
            PlayType.TRAGEDY -> {
                result = 40000;
                if (performance.audience > 30) {
                    result += 1000 * (performance.audience - 30)
                }
            }
            PlayType.COMEDY -> {
                result = 30000;
                if (performance.audience > 20) {
                    result += 10000 + 500 * (performance.audience - 20)
                }
                result += 300 * performance.audience
            }
        }
        return result
    }

    fun playFor(performance: Performance): Play {
        return plays[performance.playId] ?: throw ClassNotFoundException("should be exist")
    }

    fun volumeCreditsFor(performance: Performance): Int {
        var result = 0
        result += (performance.audience - 30).coerceAtLeast(0)
        if (PlayType.COMEDY == performance.play?.type)
            result += floor((performance.audience / 5).toDouble()).toInt()
        return result
    }

    fun enrichPerformance(performance: Performance): Performance {
        val result = Performance(performance.playId, performance.audience)
        result.play = playFor(result)
        result.amount = amountFor(result)
        result.volumeCredits = volumeCreditsFor(result)
        return result
    }

    fun totalVolumeCredits(data: StatementData): Int {
        return data.performances.fold(0) { total, performance ->
            total + performance.volumeCredits
        }
    }

    fun totalAmount(data: StatementData): Int {
        return data.performances.fold(0) { total, performance ->
            total + performance.amount
        }
    }

    val statementData = StatementData(invoice.customer, invoice.performances.map { enrichPerformance(it) }).apply {
        this.totalVolumeCredits = totalVolumeCredits(this)
        this.totalAmount = totalAmount(this)
    }
    return renderPlainText(statementData, plays)
}

fun renderPlainText(data: StatementData, plays: Map<String, Play>): String {

    fun usd(number: Int): String {
        return NumberFormat.getCurrencyInstance(Locale.US).format(number / 100)
    }

    var result = "청구 내역 (고객명: ${data.customer}\n"

    for (performance in data.performances) {
        // 청구 내역을 출력한다.
        result += "${performance.play?.name}: ${usd(performance.amount)} ${performance.audience}석\n"
    }
    result += "총액: ${usd(data.totalAmount)}\n"
    result += "적립 포인트: ${data.totalVolumeCredits}점"
    return result
}

fun getPlays(json: Json): Map<String, Play> {
    val playsJson = File("./src/main/resources/plays.json").readText(Charsets.UTF_8)
    return json.decodeFromString(playsJson)
}

fun getInvoices(json: Json): List<Invoice> {
    val invoicesJson = File("./src/main/resources/invoices.json").readText(Charsets.UTF_8)
    return json.decodeFromString(invoicesJson)
}


fun main() {
    val json = Json {
        ignoreUnknownKeys = true
    }
    val plays = getPlays(json)
    val invoices = getInvoices(json)
    println(statement(invoices[0], plays))
}
