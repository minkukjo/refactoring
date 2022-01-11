package application.ch11

// 11.7 세터 제거하기
// DDD에서도 이야기하는 세터 제거하기!
// 여러 명이 협업해서 객체를 사용할 때는 Setter를 없애서 객체의 불변성을 보장해주는 것이 좋다고 생각함.

class Person(
        val name: String, // val로 선언함으로써 setter를 제한함
        val id: String,
)

fun main() {
    val person = Person("harry", "adsfes")
}