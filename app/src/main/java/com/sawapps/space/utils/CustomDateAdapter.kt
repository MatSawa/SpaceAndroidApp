package com.sawapps.space.utils

import com.squareup.moshi.*
import java.time.LocalDateTime

/**
 * Created by Mateusz Sawa on 14/11/2020.
 */

class CustomDateAdapter : JsonAdapter<LocalDateTime>() {

    @FromJson
    override fun fromJson(reader: JsonReader): LocalDateTime? {
        return try {
            return reader.nextString()?.toLocalDateTime()
        } catch (e: Exception) {
            null
        }
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: LocalDateTime?) {
        if (value != null) {
            writer.value(value.toString())
        }
    }
}
