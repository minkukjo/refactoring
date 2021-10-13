package application.ch6

import domain.ch6.Reading

fun acquiredReading(): Reading {
    return Reading(customer = "harry", quantity = 10, month = 5, year = 2017)
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
    val aReading = acquiredReading()
    val baseCharge = baseRate(aReading.month, aReading.year) * aReading.quantity
}

fun client2() {
    val aReading = acquiredReading()
    val base = baseRate(aReading.month, aReading.year) * aReading.quantity
    val taxableCharge = 0.coerceAtLeast(base - taxThreshold(aReading.year))
}

fun client3() {
    fun calculateBaseCharge(aReading: Reading): Int {
        return baseRate(aReading.month, aReading.year) * aReading.quantity
    }

    val aReading = acquiredReading()
    val baseCharge = calculateBaseCharge(aReading)
}