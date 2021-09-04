package domain

class PerformanceCalculator(val performance: Performance, val play: Play) {
    fun amount(performance: Performance): Int {
        var result = 0
        when (this.play.type) {
            PlayType.TRAGEDY -> { // 비극
                result = 40000;
                if (performance.audience > 30) {
                    result += 1000 * (performance.audience - 30)
                }
            }
            PlayType.COMEDY -> { // 희극
                result = 30000;
                if (performance.audience > 20) {
                    result += 10000 + 500 * (performance.audience - 20)
                }
                result += 300 * performance.audience
            }
        }
        return result
    }
}