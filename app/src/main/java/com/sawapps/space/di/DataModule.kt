package com.sawapps.space.di

import android.content.Context
import androidx.room.Room
import com.sawapps.space.BuildConfig
import com.sawapps.space.database.DatabaseService
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * Created by Mateusz Sawa on 14/11/2020.
 */
val dataModule = module {
    single { createDatabase(context = androidContext()) }
    single { get<DatabaseService>().getLaunchDao() }
}

private fun createDatabase(context: Context) =
    Room.databaseBuilder(context, DatabaseService::class.java, BuildConfig.APPLICATION_ID)
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()
