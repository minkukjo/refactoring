import domain.ch4.Province
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Chapter4Test {

    lateinit var asia: Province

    @BeforeEach
    fun setUp() {
        // given
        val json = Json {
            ignoreUnknownKeys = true
        }
        // when
        asia = getProvince(json)
    }

    @Test
    @DisplayName("생산 부족분 테스트")
    fun shortfall() {
        // then
        assertEquals(asia.shortfall(), 5)
    }

    @Test
    @DisplayName("총 수익 계산 테스트")
    fun profit() {
        //then
        assertEquals(asia.profit(), 230)
    }

    @Test
    @DisplayName("조금 복잡한 setter인 production setter 검증")
    fun production() {
        //then
        asia.producers[0].production = 20
        asia.totalProduction = asia.producers.sumOf { it.production }
        assertEquals(asia.shortfall(), -6)
        assertEquals(asia.profit(), 292)
    }

    @Test
    fun noProducer() {
        val noProducers = Province(name = "No Producers", producers = mutableListOf(), demand = 30, price = 20)
        assertEquals(noProducers.shortfall(), 30)
        assertEquals(noProducers.profit(), 0)
    }

    @Test
    fun zeroDemand() {
        this.asia.demand = 0
        assertEquals(asia.shortfall(), -25)
        assertEquals(asia.profit(), 0)
    }

    @Test
    fun negativeDemand() {
        this.asia.demand = -1
        assertEquals(asia.shortfall(), -26)
        assertEquals(asia.profit(), -10)
    }
}