package application.ch11

import domain.ch11.People

// 11.1 질의 함수와 변경 함수 분리하기

fun setOffAlarms() {

}

fun findMiscreant(people: List<People>): String {
    for (p: People in people) {
        if (p.name == "조커") {
            return "조커"
        }

        if (p.name == "사루만") {
            return "사루만"
        }
    }
    return ""
}

fun alertForMiscreant(people: List<People>) {
    for (p: People in people) {
        if (p.name == "조커") {
            setOffAlarms()
            return
        }

        if (p.name == "사루만") {
            setOffAlarms()
            return
        }
    }
    return
}

fun main() {
    val people = listOf(People("조커"), People("테스트"), People("사루만"))
    alertForMiscreant(people)
}