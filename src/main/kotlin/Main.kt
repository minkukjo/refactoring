import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File
import java.text.NumberFormat
import java.util.Locale
import kotlin.math.floor

fun amountFor(performance: Performance, play: Play): Int {
    var thisAmount = 0
    when (play.type) {
        PlayType.TRAGEDY -> {
            thisAmount = 40000;
            if (performance.audience > 30) {
                thisAmount += 1000 * (performance.audience - 30)
            }
        }
        PlayType.COMEDY -> {
            thisAmount = 30000;
            if (performance.audience > 20) {
                thisAmount += 10000 + 500 * (performance.audience - 20)
            }
            thisAmount += 300 * performance.audience
        }
        else -> throw Error("알 수 없는 장르: ${play.type}")
    }
    return thisAmount
}

fun statement(invoices: Invoice, plays: Map<String, Play>): String {
    var totalAmount = 0
    var volumeCredits = 0
    var result = "청구 내역 (고객명: ${invoices.customer}\n"
    val format = NumberFormat.getCurrencyInstance(Locale.US)

    for (performance in invoices.performances) {
        val play = plays[performance.playId] ?: throw ClassNotFoundException("should be exist")

        val thisAmount = amountFor(performance, play)

        // 포인트를 적립한다.
        volumeCredits += (performance.audience - 30).coerceAtLeast(0)
        // 희극 관객 5명마다 추가 포인트를 제공한다.
        if (PlayType.COMEDY == play.type) volumeCredits += floor((performance.audience / 5).toDouble()).toInt()

        // 청구 내역을 출력한다.
        result += "${play.name}: ${format.format(thisAmount / 100)} ${performance.audience}석\n"
        totalAmount += thisAmount
    }
    result += "총액: ${format.format(totalAmount / 100)}\n"
    result += "적립 포인트: ${volumeCredits}점\n"
    return result
}


fun main() {
    val playsJson = File("./src/main/resources/plays.json").readText(Charsets.UTF_8)
    val plays = Json.decodeFromString<Map<String, Play>>(playsJson)

    val invoicesJson = File("./src/main/resources/invoices.json").readText(Charsets.UTF_8)
    val invoices = Json.decodeFromString<List<Invoice>>(invoicesJson)

    println(statement(invoices[0], plays))
}
