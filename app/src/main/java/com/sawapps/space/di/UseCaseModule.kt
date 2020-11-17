package com.sawapps.space.di

import com.sawapps.space.usecases.launches.GetLaunchesUseCase
import org.koin.dsl.module
import org.koin.experimental.builder.factory

/**
 * Created by Mateusz Sawa on 13/11/2020.
 */
val useCaseModule = module {
    factory<GetLaunchesUseCase>()
}