package com.sawapps.space.database.daos

import androidx.room.*

/**
 * Created by Mateusz Sawa on 14/11/2020.
 */
@Dao
interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: T): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: List<T>): List<Long>

    @Update
    fun update(entity: T)

    @Update
    fun update(entity: List<T>)

    @Delete
    fun delete(entity: T)

    @Delete
    fun delete(entities: List<T>)
}
