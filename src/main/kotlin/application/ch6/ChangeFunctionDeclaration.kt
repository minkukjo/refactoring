package application.ch6

import domain.ch6.Customer
import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue

// circumference 원의 둘레라는 뜻
fun circumference(radius: Double): Double {
    return 2 * Math.PI * radius
}

val reservations: Queue<Customer> = LinkedList()
val priorityReservations: PriorityQueue<Customer> = PriorityQueue()

fun addReservation(customer: Customer, isPriority: Boolean) {
    if (isPriority) {
        priorityReservations.add(customer)
    } else {
        reservations.add(customer)
    }
}

// 이 함수는 Customer 클래스에 의존적인 함수이다.
// 특정 모듈에 의존적이지 않는 함수를 만들기 위해 주소를 매개변수로 받는 함수를 내부에 만들자
// 그리고 이 함수가 이상없이 동작한다면 원본 함수를 제거하고 새로 만든 함수를 원본 함수의 이름으로 바꿔주자
fun inNewEngland(customer: Customer): Boolean {
    fun xxNEWinNewEngland(stateCode: String): Boolean {
        return mutableListOf("MA", "CT", "ME", "VT", "NH", "RI").contains(stateCode)
    }
    return xxNEWinNewEngland(customer.location)
}