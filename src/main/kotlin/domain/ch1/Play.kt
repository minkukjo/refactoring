package domain.ch1

import kotlinx.serialization.Serializable

@Serializable
class Play(val name: String, val type: PlayType) {
}