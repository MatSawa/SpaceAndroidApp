package com.sawapps.space.di

import com.sawapps.space.common.*
import org.koin.dsl.module
import org.koin.experimental.builder.factoryBy

/**
 * Created by Mateusz Sawa on 12/11/2020.
 */
val commonModule = module {
    factoryBy<ResourceProvider, ResourceProviderImpl>()
    factoryBy<SchedulerProvider, ApplicationSchedulerProvider>()
    factoryBy<ConnectivityService, ConnectivityServiceImpl>()
}