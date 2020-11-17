package com.sawapps.space.database.daos

import androidx.room.Dao
import androidx.room.Query
import com.sawapps.space.database.models.LaunchEntity

/**
 * Created by Mateusz Sawa on 14/11/2020.
 */
@Dao
abstract class LaunchDao : BaseDao<LaunchEntity> {
    @Query("SELECT * FROM launch")
    abstract fun getAll(): List<LaunchEntity>
}