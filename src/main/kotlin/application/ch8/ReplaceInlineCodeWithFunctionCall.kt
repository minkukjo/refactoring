package application.ch8

// 8.5 인라인 코드를 함수 호출로 대체하자. (중복코드의 재활용)

fun main() {
    val states = listOf("normal", "test", "MA")
    var appliesToMass = states.contains("MA")
}