package application

import domain.ch1.Invoice
import domain.ch1.Performance
import domain.ch1.Play
import domain.ch1.PlayType
import domain.ch1.StatementData
import domain.ch1.calculator.ComedyCalculator
import domain.ch1.calculator.PerformanceCalculator
import domain.ch1.calculator.TragedyCalculator

fun createPerformanceCalculator(performance: Performance, play: Play): PerformanceCalculator {
    return when (play.type) {
        PlayType.TRAGEDY -> TragedyCalculator(performance)
        PlayType.COMEDY -> ComedyCalculator(performance)
    }
}

fun createStatementData(invoice: Invoice, plays: Map<String, Play>): StatementData {

    fun playFor(performance: Performance): Play {
        return plays[performance.playId] ?: throw ClassNotFoundException("should be exist")
    }

    fun enrichPerformance(performance: Performance): Performance {
        val result = Performance(performance.playId, performance.audience)
        val calculator = createPerformanceCalculator(result, playFor(result))
        result.amount = calculator.amount()
        result.play = playFor(result)
        result.volumeCredits = calculator.volumeCredits()
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