package application.ch8

import domain.ch8.People

// 8.7 반복문 쪼개기

fun main() {
    val people = listOf(People(21, 300), People(23, 500), People(20, 100))
    val youngest = youngestAge(people)
    val totalSalary = totalSalary(people)
    println("최연소 $youngest, 총 급여 : $totalSalary")
}

private fun totalSalary(people: List<People>): Int {
    return people.map { p -> p.salary }.reduce { total, p -> total + p }
}

private fun youngestAge(people: List<People>): Int {
    return people.minOf { p -> p.age }
}