package com.sawapps.space.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sawapps.space.database.daos.LaunchDao
import com.sawapps.space.database.models.LaunchEntity

/**
 * Created by Mateusz Sawa on 14/11/2020.
 */
@Database(
    entities = [
        LaunchEntity::class
    ],
    version = 1
)
@TypeConverters(Converters::class)
internal abstract class DatabaseService : RoomDatabase() {
    abstract fun getLaunchDao(): LaunchDao
}