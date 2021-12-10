package application.ch10

import java.time.LocalDateTime

// 10.1 조건문 분해하기
// 복잡한 조건문은 간결하게 함수로 추출


fun main() {
    val date = LocalDateTime.now()
    val summerStart = LocalDateTime.now().plusMonths(6L)
    val summerEnd = LocalDateTime.now().plusMonths(9L)
    var charge = 0.0
    val quantity = 0.8
    val summerRate = 0.08
    val regularRate = 0.10
    charge = if (!date.isBefore(summerStart) && !date.isAfter(summerEnd)) {
        quantity * summerRate
    } else {
        quantity * regularRate
    }
    println(charge)
}