package application.ch10

// 10.2 조건식 통합하기
// 여러 개의 흩어진 조건들을 하나의 함수로 묶기 (or , and)

fun main() {
    val a = 5
    var b = 0
    if (a < 5) {
        if (a > 0) {
            b = 3
        }
    }
}