import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.File

internal class MainKtTest {
    private lateinit var plays: Map<String, Play>

    private lateinit var invoices: List<Invoice>

    @BeforeEach
    fun setUp() {
        val playsJson = File("./src/main/resources/plays.json").readText(Charsets.UTF_8)
        plays = Json.decodeFromString(playsJson)

        val invoicesJson = File("./src/main/resources/invoices.json").readText(Charsets.UTF_8)
        invoices = Json.decodeFromString(invoicesJson)
    }

    @Test
    @DisplayName("statement 실행 결과 테스트")
    fun testStatement() {
        val result = statement(invoices[0], plays)
        println(result)
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