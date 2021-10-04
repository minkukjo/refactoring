package domain.ch1.calculator

import domain.ch1.Performance

class TragedyCalculator(private val performance: Performance) : PerformanceCalculator {
    override fun amount(): Int {
        var result = 40000;
        if (performance.audience > 30) {
            result += 1000 * (performance.audience - 30)
        }
        return result
    }

    override fun volumeCredits(): Int {
        var result = 0
        result += (performance.audience - 30).coerceAtLeast(0)
        return result
    }

}