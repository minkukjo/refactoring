package domain.ch1

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializer(forClass = PlayType::class)
object PlayTypeSerializer : KSerializer<PlayType> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("domain.ch1.PlayType", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: PlayType) {
        encoder.encodeString(value.key)
    }

    override fun deserialize(decoder: Decoder): PlayType {
        val key = decoder.decodeString()
        return PlayType.findByKey(key)
    }
}