package application.ch6

import domain.ch6.Reading
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File

fun acquiredReading(): String {
    return File("./src/main/resources/reading.json").readText(Charsets.UTF_8)
}

// 코드엔 없는 함수라서 임의로 만들었다.
fun baseRate(month: Int, year: Int): Int {
    return month + year
}

// 이 함수 역시 코드에는 없는 함수라서 임의로 만들었다.
fun taxThreshold(year: Int): Int {
    return year
}

fun client1() {
    val rawReading = acquiredReading()
    val aReading = Json.decodeFromString<Reading>(rawReading)
    val baseCharge = aReading.baseCharge()
    println(baseCharge)
}

fun client2() {
    val rawReading = acquiredReading()
    val aReading = Json.decodeFromString<Reading>(rawReading)
    val taxableCharge = aReading.taxableCharge()
    println(taxableCharge)
}

fun client3() {
    val rawReading = acquiredReading()
    val aReading = Json.decodeFromString<Reading>(rawReading)
    val baseCharge = aReading.baseCharge()
    println(baseCharge)
}

fun main() {
    client1()
    client2()
    client3()
}