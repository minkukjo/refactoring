package application.ch8

// 8.5 인라인 코드를 함수 호출로 대체하자. (중복코드의 재활용)

fun main() {
    var appliesToMass = false
    val states = listOf("normal", "test", "MA")
    for (s in states) {
        if (s == "MA") {
            appliesToMass = true
        }
    }
}