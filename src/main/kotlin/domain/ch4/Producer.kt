package domain.ch4

import kotlinx.serialization.Serializable

@Serializable
class Producer(
        var province: Province? = null,
        var name: String,
        var cost: Int,
        var production: Int
) {
    constructor(province: Province?, data: Data) : this(province, data.name, data.cost, data.production)

    fun setProduction(amount: Int?) {
        val newProduction = amount ?: 0
        this.province?.let { province ->
            province.totalProduction += newProduction - this.production
        }
        this.production = newProduction
    }

}
