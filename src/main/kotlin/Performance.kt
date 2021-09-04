import kotlinx.serialization.Serializable

@Serializable
open class Performance(val playId: String, val audience: Int, var play: Play? = null, var amount: Int = 0, var volumeCredits: Int = 0)