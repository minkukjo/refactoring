package domain.ch1

import kotlinx.serialization.Serializable

@Serializable(with = PlayTypeSerializer::class)
enum class PlayType(val key: String) {
    TRAGEDY("tragedy"), COMEDY("comedy");

    companion object {
        fun findByKey(key: String): PlayType {
            return PlayType.values().find { it.key == key } ?: throw ClassNotFoundException("invalid enum value")
        }
    }
}