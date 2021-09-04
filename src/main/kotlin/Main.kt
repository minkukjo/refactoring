import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File
import java.text.NumberFormat
import java.util.Locale
import kotlin.math.floor

fun statement(invoices: Invoice, plays: Map<String, Play>): String {

    fun playFor(performance: Performance): Play {
        return plays[performance.playId] ?: throw ClassNotFoundException("should be exist")
    }

    fun amountFor(performance: Performance): Int {
        var result = 0
        when (playFor(performance).type) {
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

    fun volumeCreditsFor(performance: Performance): Int {
        var volumeCredits = 0
        volumeCredits += (performance.audience - 30).coerceAtLeast(0)
        if (PlayType.COMEDY == playFor(performance).type)
            volumeCredits += floor((performance.audience / 5).toDouble()).toInt()
        return volumeCredits
    }

    fun format(number: Int): String {
        return NumberFormat.getCurrencyInstance(Locale.US).format(number)
    }

    var totalAmount = 0
    var volumeCredits = 0
    var result = "청구 내역 (고객명: ${invoices.customer}\n"

    for (performance in invoices.performances) {
        volumeCredits += volumeCreditsFor(performance)

        // 청구 내역을 출력한다.
        result += "${playFor(performance).name}: ${format(amountFor(performance) / 100)} ${performance.audience}석\n"
        totalAmount += amountFor(performance)
    }
    result += "총액: ${format(totalAmount / 100)}\n"
    result += "적립 포인트: ${volumeCredits}점"
    return result
}

fun getPlays(): Map<String, Play> {
    val playsJson = File("./src/main/resources/plays.json").readText(Charsets.UTF_8)
    return Json.decodeFromString(playsJson)
}

fun getInvoices(): List<Invoice> {
    val invoicesJson = File("./src/main/resources/invoices.json").readText(Charsets.UTF_8)
    return Json.decodeFromString(invoicesJson)
}


fun main() {
    val plays = getPlays()
    val invoices = getInvoices()
    println(statement(invoices[0], plays))
}
