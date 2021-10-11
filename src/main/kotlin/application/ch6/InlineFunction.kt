package application.ch6

import domain.ch6.Customer
import domain.ch6.Driver

fun rating(driver: Driver): Int {
    return if (driver.numberOfLateDeliveries > 5) {
        2
    } else {
        1
    }
}

fun reportLines(customer: Customer): MutableMap<String, String> {
    val lines = mutableMapOf<String, String>()
    lines["name"] = customer.name
    lines["location"] = customer.location
    return lines
}

fun main() {
    val reportLines = reportLines(Customer(name = "harry", location = "mars"))
    println(reportLines)
}