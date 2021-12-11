package application.ch10

import java.time.LocalDateTime

// 10.1 조건문 분해하기
// 복잡한 조건문은 간결하게 함수로 추출

val quantity = 0.8
val summerRate = 0.08
val regularRate = 0.10

fun summer(): Boolean {
    val date = LocalDateTime.now()
    val summerStart = LocalDateTime.now().plusMonths(6L)
    val summerEnd = LocalDateTime.now().plusMonths(9L)
    return !date.isBefore(summerStart) && !date.isAfter(summerEnd)
}

fun summerCharge(): Double {
    return quantity * summerRate
}

fun regularCharge(): Double {
    return quantity * regularRate
}

fun main() {
    var charge = 0.0
    charge = if (summer()) {
        summerCharge()
    } else {
        regularCharge()
    }
    println(charge)
}