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

fun inNewEngland(customer: Customer): Boolean {
    fun xxNEWinNewEngland(stateCode: String): Boolean {
        return mutableListOf("MA", "CT", "ME", "VT", "NH", "RI").contains(stateCode)
    }
    return xxNEWinNewEngland(customer.location)
}