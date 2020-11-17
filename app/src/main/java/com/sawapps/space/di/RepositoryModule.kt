package com.sawapps.space.di

import com.sawapps.space.repositories.LaunchesRepository
import com.sawapps.space.repositories.LaunchesRepositoryImpl
import org.koin.dsl.module
import org.koin.experimental.builder.singleBy

/**
 * Created by Mateusz Sawa on 13/11/2020.
 */
val repositoryModule = module {
    singleBy<LaunchesRepository, LaunchesRepositoryImpl>()
}