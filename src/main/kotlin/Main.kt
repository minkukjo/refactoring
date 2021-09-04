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
        var result = 0
        result += (performance.audience - 30).coerceAtLeast(0)
        if (PlayType.COMEDY == playFor(performance).type)
            result += floor((performance.audience / 5).toDouble()).toInt()
        return result
    }

    fun usd(number: Int): String {
        return NumberFormat.getCurrencyInstance(Locale.US).format(number / 100)
    }

    fun totalVolumeCredits(): Int {
        var result = 0
        for (performance in invoices.performances) {
            result += volumeCreditsFor(performance)
        }
        return result
    }

    fun totalAmount(): Int {
        var result = 0
        for (performance in invoices.performances) {
            result += amountFor(performance)
        }
        return result
    }

    var result = "청구 내역 (고객명: ${invoices.customer}\n"

    for (performance in invoices.performances) {
        // 청구 내역을 출력한다.
        result += "${playFor(performance).name}: ${usd(amountFor(performance))} ${performance.audience}석\n"
    }
    result += "총액: ${usd(totalAmount())}\n"
    result += "적립 포인트: ${totalVolumeCredits()}점"
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
