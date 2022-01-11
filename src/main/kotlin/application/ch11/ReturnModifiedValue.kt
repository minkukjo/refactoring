package application.ch11

// 11.11 수정된 값 반환하기
// 함수형 프로그래밍에서 이야기하는 순수함수와도 관련이 있는 리팩토링이다.

var totalAscent = 0
var totalTime = 0
var totalDistance = 0

fun calculateAscent(): Int {
    var result = 0
    for (i in 1..10) {
        result += 1
    }
    return result
}

fun calculateTime(): Int {
    return totalTime
}

fun calculateDistance(): Int {
    return totalDistance
}

fun main() {
    totalAscent = calculateAscent()
    totalTime = calculateTime()
    totalDistance = calculateDistance()
    val pace = totalTime / 60 / totalDistance
}