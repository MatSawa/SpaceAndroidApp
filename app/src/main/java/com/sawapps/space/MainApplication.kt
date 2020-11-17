package com.sawapps.space

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger.addLogAdapter
import com.sawapps.space.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by Mateusz Sawa on 12/11/2020.
 */
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        addKoin()
        addLogAdapter(object : AndroidLogAdapter() {
            override fun isLoggable(priority: Int, tag: String?): Boolean = BuildConfig.DEBUG
        })
    }

    private fun addKoin() {
        val modules = listOf(
            commonModule,
            navigationModule,
            networkModule,
            viewModelModule,
            dataModule,
            repositoryModule,
            useCaseModule
        )

        startKoin {
            androidContext(this@MainApplication)
            modules(modules)
        }
    }
}
