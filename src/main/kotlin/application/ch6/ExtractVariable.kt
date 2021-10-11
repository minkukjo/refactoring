package application.ch6

import domain.ch6.Order

fun price(order: Order): Double {
    val basePrice = order.quantity * order.itemPrice
    val quantityDiscount = 0.coerceAtLeast(order.quantity - 500) * order.itemPrice * 0.05
    val shipping = (basePrice * 0.1).coerceAtMost(100.0)
    return basePrice - quantityDiscount + shipping
}

