package application.ch12

// 12.3 생성자 본문 올리기
// 자식의 생성자 중 부모의 생성자를 호출하는 방법.
// 코틀린은 조금 더 깔끔한 문법으로 이를 지원한다.

open class Parent(
        val name: String,
)

class Child(name: String, val id: Long, val monthlyCost: Long) : Parent(name) {

}