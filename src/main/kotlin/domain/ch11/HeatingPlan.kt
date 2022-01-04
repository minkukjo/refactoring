package domain.ch11

class HeatingPlan(
        private val tempRange: TempRange
) {
    fun withRange(aNumberRange: TempRange): Boolean {
        return aNumberRange.low >= this.tempRange.low &&
                aNumberRange.high <= this.tempRange.high
    }
}
