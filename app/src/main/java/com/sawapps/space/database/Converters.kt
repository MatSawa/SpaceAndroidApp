package com.sawapps.space.database

import androidx.room.TypeConverter
import com.sawapps.space.utils.toLocalDateTime
import java.time.LocalDateTime
import java.time.ZoneOffset

/**
 * Created by Mateusz Sawa on 14/11/2020.
 */
class Converters {
    @TypeConverter
    fun toDate(dateLong: Long?): LocalDateTime? = dateLong?.toLocalDateTime()

    @TypeConverter
    fun fromDate(date: LocalDateTime?): Long? = date?.toInstant(ZoneOffset.UTC)?.toEpochMilli()
}