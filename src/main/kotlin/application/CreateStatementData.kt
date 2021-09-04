package application

import domain.Invoice
import domain.Performance
import domain.PerformanceCalculator
import domain.Play
import domain.PlayType
import domain.StatementData
import kotlin.math.floor

fun createStatementData(invoice: Invoice, plays: Map<String, Play>): StatementData {
    
    fun playFor(performance: Performance): Play {
        return plays[performance.playId] ?: throw ClassNotFoundException("should be exist")
    }

    fun volumeCreditsFor(performance: Performance): Int {
        var result = 0
        result += (performance.audience - 30).coerceAtLeast(0)
        if (PlayType.COMEDY == performance.play?.type)
            result += floor((performance.audience / 5).toDouble()).toInt()
        return result
    }

    fun enrichPerformance(performance: Performance): Performance {
        val result = Performance(performance.playId, performance.audience)
        val calculator = PerformanceCalculator(performance, playFor(result))
        result.amount = calculator.amount(result)
        result.play = calculator.play
        result.volumeCredits = volumeCreditsFor(result)
        return result
    }

    fun totalVolumeCredits(data: StatementData): Int {
        return data.performances.fold(0) { total, performance ->
            total + performance.volumeCredits
        }
    }

    fun totalAmount(data: StatementData): Int {
        return data.performances.fold(0) { total, performance ->
            total + performance.amount
        }
    }

    return StatementData(invoice.customer, invoice.performances.map { enrichPerformance(it) }).apply {
        this.totalVolumeCredits = totalVolumeCredits(this)
        this.totalAmount = totalAmount(this)
    }
}