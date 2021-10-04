package domain.ch4

import kotlinx.serialization.Serializable

@Serializable
class Province(
        val name: String,
        val producers: MutableList<Producer>,
        var totalProduction: Int = producers.sumOf { it.production },
        var demand: Int,
        val price: Int,
) {
    override fun toString(): String {
        return "Province(name='$name', producers=$producers, totalProduction=$totalProduction, demand=$demand, price=$price)"
    }

    fun addProduction(producer: Producer) {
        producers.add(producer)
        totalProduction += producer.production
    }

    fun shortfall(): Int = this.demand - this.totalProduction

    private fun satisfiedDemand(): Int = this.demand.coerceAtMost(this.totalProduction)

    private fun demandValue(): Int = this.satisfiedDemand() * this.price

    private fun demandCost(): Int {
        var remainingDemand = this.demand
        var result = 0
        this.producers.sortBy { it.cost }
        this.producers.forEach { producer ->
            val contribution = remainingDemand.coerceAtMost(producer.production)
            remainingDemand -= contribution
            result += contribution * producer.cost
        }
        return result

    }

    fun profit(): Int = this.demandValue() - this.demandCost()
}