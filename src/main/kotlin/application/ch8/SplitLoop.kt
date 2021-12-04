package application.ch8

import domain.ch8.People

// 8.7 반복문 쪼개기

fun main() {
    val people = listOf(People(21, 300), People(23, 500), People(20, 100))
    var youngest = people[0].age
    var totalSalary = 0
    for (p in people) {
        if (p.age < youngest) {
            youngest = p.age
        }
        totalSalary += p.salary
    }
    println("최연소 ${youngest}, 총 급여 : ${totalSalary}")
}