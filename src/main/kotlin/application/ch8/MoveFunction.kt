package application.ch8

fun calculateTime(): Int {
    return 1
}

fun distance(p1: Int, p2: Int): Int {
    return p1 + p2
}

fun trackSummary(points: List<Int>) {

    fun calculateDistance(): Int {
        var result = 0
        for (i in 1..points.size) {
            result += distance(points[i - 1], points[1]);
        }
        return result
    }

    val totalTime = calculateTime()
    val totalDistance = calculateDistance()
    val pace = totalTime / 60 / totalDistance


}