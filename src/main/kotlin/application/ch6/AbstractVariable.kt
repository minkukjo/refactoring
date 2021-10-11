package application.ch6

import domain.ch6.Order

fun price(order: Order): Double {
    return order.quantity * order.itemPrice - 0.coerceAtLeast(order.quantity - 500) * order.itemPrice * 0.05 +
            (order.quantity * order.itemPrice * 0.1).coerceAtMost(100.0)
}

