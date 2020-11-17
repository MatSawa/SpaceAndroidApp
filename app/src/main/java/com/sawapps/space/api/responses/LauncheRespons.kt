package com.sawapps.space.api.responses

import com.squareup.moshi.Json
import java.time.LocalDateTime

/**
 * Created by Mateusz Sawa on 13/11/2020.
 */
data class LaunchResponse (
    @Json(name = "links")
    val links: Links?,
    @Json(name = "rocket")
    val rocketId: String,
    @Json(name = "details")
    val details: String?,
    @Json(name = "launchpad")
    val launchpad: String?,
    @Json(name = "flightNumber")
    val flightNumber: Long?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "date_utc")
    val date: LocalDateTime?,
    @Json(name = "id")
    val id: String?
)

data class Links (
    @Json(name = "patch")
    val patch: Patch?
)

data class Patch (
    @Json(name = "small")
    val imageUrl: String?,
)
