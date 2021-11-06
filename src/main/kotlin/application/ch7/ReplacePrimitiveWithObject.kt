package application.ch7

import domain.ch7.Order
import domain.ch7.Priority

fun main() {
    val orders = listOf(Order(Priority("high")), Order(Priority("normal")), Order(Priority("low")), Order(Priority("rush")))
    val highPriorityCount = orders.filter { order -> order.priority.higherThan(Priority("normal")) }.size
}