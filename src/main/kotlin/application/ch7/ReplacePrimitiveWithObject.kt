package application.ch7

import domain.ch7.PrimitiveOrder
import domain.ch7.Priority

fun main() {
    val primitiveOrders = listOf(PrimitiveOrder(Priority("high")), PrimitiveOrder(Priority("normal")), PrimitiveOrder(Priority("low")), PrimitiveOrder(Priority("rush")))
    val highPriorityCount = primitiveOrders.filter { order -> order.priority.higherThan(Priority("normal")) }.size
}