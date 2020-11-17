package com.sawapps.space.di

import com.sawapps.space.navigation.Navigator
import com.sawapps.space.navigation.flow.MainFlow
import com.sawapps.space.navigation.flow.MainFlowImpl
import org.koin.dsl.module
import org.koin.experimental.builder.factoryBy
import org.koin.experimental.builder.single

/**
 * Created by Mateusz Sawa on 13/11/2020.
 */
val navigationModule = module {
    single<Navigator>()
    // Flows
    factoryBy<MainFlow, MainFlowImpl>()
}