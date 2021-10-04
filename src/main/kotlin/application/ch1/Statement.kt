package application

import domain.ch1.Invoice
import domain.ch1.Play
import domain.ch1.StatementData
import java.text.NumberFormat
import java.util.Locale

fun usd(number: Int): String {
    return NumberFormat.getCurrencyInstance(Locale.US).format(number / 100)
}

fun htmlStatement(invoice: Invoice, plays: Map<String, Play>): String {
    return renderHtml(createStatementData(invoice, plays))
}

fun renderHtml(data: StatementData): String {
    var result = "<h1>청구 내역 (고객명: ${data.customer})</h1>\n"
    result += "<table>\n"
    result += "<tr><th>연극</th><th>좌석 수</th><th>금액</th></tr>"
    for (performance in data.performances) {
        result += "<tr><td>${performance.play?.name}</td><td>${performance.audience}석</td>"
        result += "<td>${usd(performance.amount)}</td></tr>\n"
    }
    result += "</table>\n"
    result += "<p>총액: <em>${usd(data.totalAmount)}</em></p>\n"
    result += "<p>적립 포인트: <em>${data.totalVolumeCredits}</em>점</p>"
    return result
}

fun statement(invoice: Invoice, plays: Map<String, Play>): String {
    return renderPlainText(createStatementData(invoice, plays))
}

fun renderPlainText(data: StatementData): String {
    var result = "청구 내역 (고객명: ${data.customer})\n"

    for (performance in data.performances) {
        result += "${performance.play?.name}: ${usd(performance.amount)} ${performance.audience}석\n"
    }
    result += "총액: ${usd(data.totalAmount)}\n"
    result += "적립 포인트: ${data.totalVolumeCredits}점"
    return result
}
