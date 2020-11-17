package com.sawapps.space.utils

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

/**
 * Created by Mateusz Sawa on 16/11/2020.
 */

private const val ISO_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
private const val DATE_FORMAT = "dd.MM.yyyy HH:mm"
private val UTC_0: ZoneId = ZoneId.of("UTC");

fun LocalDateTime.toDateTime(): String =
    format(DateTimeFormatter.ofPattern(DATE_FORMAT))

fun String.toLocalDateTime(): LocalDateTime =
    LocalDateTime.parse(this, DateTimeFormatter.ofPattern(ISO_DATE_FORMAT))
        .atOffset(ZoneOffset.UTC)
        .atZoneSameInstant(ZoneId.systemDefault())
        .toLocalDateTime()

fun LocalDateTime.utc0(): LocalDateTime = atZone(UTC_0).toLocalDateTime()

fun Long.toLocalDateTime(): LocalDateTime =
    Instant.ofEpochMilli(this).atZone(UTC_0).toLocalDateTime();
