package domain.calculator

import domain.Performance
import domain.PlayType
import kotlin.math.floor

class ComedyCalculator(private val performance: Performance) : PerformanceCalculator {
    override fun amount(): Int {
        var result = 30000;
        if (performance.audience > 20) {
            result += 10000 + 500 * (performance.audience - 20)
        }
        result += 300 * performance.audience

        return result
    }

    override fun volumeCredits(): Int {
        var result = 0
        result += (performance.audience - 30).coerceAtLeast(0)
        if (PlayType.COMEDY == performance.play?.type)
            result += floor((performance.audience / 5).toDouble()).toInt()
        return result
    }
}