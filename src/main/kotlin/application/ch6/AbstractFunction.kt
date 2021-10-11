package application.ch6

import domain.ch6.Invoice
import domain.ch6.Order
import java.time.LocalDate
import java.time.LocalDateTime

// 함수 추출하기
// 함수는 대여섯 줄을 넘길 때 부터 슬슬 냄새를 풍기기 시작한다.
// 그러므로 함수는 최대한 짧게 짧게 쪼개도록 하자.
// 가급적 한 줄로 줄여도 좋다.
fun printOwing(invoice: Invoice) {
    printBanner()
    val outstanding = calculateOutstanding(invoice)
    recordDueDate(invoice)
    printDetails(invoice, outstanding)
}

fun calculateOutstanding(invoice: Invoice): Int {
    var result = 0
    result += invoice.orders.sumOf { order -> order.amount }
    return result
}

fun printBanner() {
    println("*************")
    println("**** 고객 채무 ****")
    println("*************")
}

fun recordDueDate(invoice: Invoice) {
    val today = LocalDateTime.now()
    invoice.dueDate = LocalDate.of(today.year, today.month, today.dayOfMonth).plusDays(30)
}

fun printDetails(invoice: Invoice, outstanding: Int) {
    println("고객명 : ${invoice.customer}")
    println("채무액 : $outstanding")
    println("마감일 : ${invoice.dueDate}")
}

fun main() {
    val invoice = Invoice(orders = listOf(Order(30), Order(50)), customer = "Harry")
    printOwing(invoice)
}