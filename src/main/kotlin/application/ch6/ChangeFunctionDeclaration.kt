package application.ch6

import domain.ch6.Customer

// circumference 원의 둘레라는 뜻
fun circumference(radius: Double): Double {
    return 2 * Math.PI * radius
}

val reservations: MutableList<Customer> = mutableListOf()

fun addReservation(customer: Customer) {
    fun zz_addReservation(customer: Customer, isPriority: Boolean) {
        reservations.add(customer)
    }

    zz_addReservation(customer, false)
}