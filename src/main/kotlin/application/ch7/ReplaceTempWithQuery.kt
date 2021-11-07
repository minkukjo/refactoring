package application.ch7

import domain.ch7.Item
import domain.ch7.Order

fun main() {
    val order = Order(0.3, Item(3000))
    val price = order.getPrice()
    println(price)
}