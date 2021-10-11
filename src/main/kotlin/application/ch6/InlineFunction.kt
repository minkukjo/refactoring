package application.ch6

import domain.ch6.Driver

fun rating(driver: Driver): Int {
    fun moreThanFiveLateDeliveries(driver: Driver): Boolean {
        return driver.numberOfLateDeliveries > 5
    }
    return if (moreThanFiveLateDeliveries(driver)) {
        2
    } else {
        1
    }
}

fun main() {
    val rating = rating(Driver(numberOfLateDeliveries = 6))
    println(rating)
}