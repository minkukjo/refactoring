import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class MainKtTest {

    @Test
    @DisplayName("statement 실행 결과 테스트")
    fun testStatement() {
        // given
        val plays = getPlays()
        val invoices = getInvoices()

        // when
        val result = statement(invoices[0], plays)
        println(result)

        // then
        Assertions.assertEquals("""
            청구 내역 (고객명: BigCo
            Hamlet: ${'$'}650.00 55석
            As You Like It: ${'$'}580.00 35석
            Othello: ${'$'}500.00 40석
            총액: ${'$'}1,730.00
            적립 포인트: 47점
            """.trimIndent(), result)
    }
}