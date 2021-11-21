package application.ch8

import domain.ch8.Point
import domain.ch8.Track
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

// 8장 함수 옮기기

fun calculateTime(): Int {
    return 1
}

fun distance(p1: Point, p2: Point): Double {
    val earthRadius = 3959
    val dLat = radians(p2.latitude) - radians(p1.latitude)
    val dLon = radians(p2.longitude) - radians(p2.longitude)
    val a = sin(dLat / 2).pow(2)
    +cos(radians(p2.latitude)) * cos(radians(p1.latitude)) * sin(dLon / 2).pow(2)
    val c = 2 * atan2(sqrt(a), sqrt(1 - a))
    return earthRadius * c
}

fun radians(degrees: Double): Double {
    return degrees * Math.PI / 180
}

fun totalDistance(points: List<Point>): Double {
    var result = 0.0
    for (i in 1..points.size) {
        result += distance(points[i - 1], points[1]);
    }
    return result
}

fun trackSummary(points: List<Point>): Track {
    val totalTime = calculateTime()
    val pace = totalTime / 60 / totalDistance(points)
    return Track(time = totalTime, distance = totalDistance(points), pace = pace)
}

fun main() {
    val points = listOf(Point(1.0, 1.0), Point(2.0, 2.0), Point(3.0, 3.0))
    println(trackSummary(points))
}

/////////////// 다른 예시 /////////////////////////

class Account {

}