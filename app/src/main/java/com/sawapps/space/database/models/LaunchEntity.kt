package com.sawapps.space.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

/**
 * Created by Mateusz Sawa on 14/11/2020.
 */
@Entity(tableName = "launch")
data class LaunchEntity(
    @PrimaryKey val id: String,
    val name: String,
    val imageUrl: String,
    val description: String,
    val date: LocalDateTime
)
