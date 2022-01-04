package application.ch11

import domain.ch11.Order

// 11.5 매개변수를 질의 함수로 바꾸기

fun main() {
    val order = Order(10L, 200L)
    val finalPrice = order.finalPrice()
    println(finalPrice)
}