package com.sawapps.space.mappers

import com.sawapps.space.api.ApiException
import com.sawapps.space.api.responses.LaunchResponse
import com.sawapps.space.database.models.LaunchEntity
import com.sawapps.space.models.Launch
import com.sawapps.space.utils.utc0
import java.time.LocalDateTime

/**
 * Created by Mateusz Sawa on 14/11/2020.
 */
fun LaunchResponse.toEntity(): LaunchEntity = LaunchEntity(
    id = id ?: throw ApiException.ParseException("id = null"),
    name = name ?: "",
    imageUrl = links?.patch?.imageUrl ?: "",
    description = details ?: "",
    date = date ?: LocalDateTime.now().utc0()
)

fun LaunchEntity.toDomain(): Launch = Launch(
    id = id,
    name = name,
    imageUrl = imageUrl,
    description = description,
    date = date
)