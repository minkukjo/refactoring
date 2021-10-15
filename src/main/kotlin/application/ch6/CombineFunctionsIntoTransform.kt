package application.ch6

import domain.ch6.Reading
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File

fun acquiredReading(): String {
    return File("./src/main/resources/reading.json").readText(Charsets.UTF_8)
}

// 코드엔 없는 함수라서 임의로 만들었다.
private fun baseRate(month: Int, year: Int): Int {
    return month + year
}

// 이 함수 역시 코드에는 없는 함수라서 임의로 만들었다.
private fun taxThreshold(year: Int): Int {
    return year
}

fun baseCharge(aReading: Reading): Int {
    return baseRate(aReading.month, aReading.year) * aReading.quantity
}

fun taxableCharge(aReading: Reading): Int {
    return 0.coerceAtLeast(aReading.baseCharge - taxThreshold(aReading.year))
}

fun enrichReading(rawData: String): Reading {
    val result = Json.decodeFromString<Reading>(rawData)
    result.baseCharge = baseCharge(result)
    result.taxableCharge = taxableCharge(result)
    return result
}

fun client1() {
    val rawReading = acquiredReading()
    val aReading = enrichReading(rawReading)
    println(aReading.baseCharge)
}

fun client2() {
    val rawReading = acquiredReading()
    val aReading = enrichReading(rawReading)
    println(aReading.taxableCharge)
}

fun client3() {
    val rawReading = acquiredReading()
    val aReading = enrichReading(rawReading)
    println(aReading.taxableCharge)
}

fun main() {
    client1()
    client2()
    client3()
}