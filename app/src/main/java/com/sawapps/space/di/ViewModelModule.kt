package com.sawapps.space.di

import com.sawapps.space.models.Launch
import com.sawapps.space.views.launch.LaunchViewModel
import com.sawapps.space.views.launches.LaunchesViewModel
import org.koin.androidx.experimental.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Mateusz Sawa on 13/11/2020.
 */
val viewModelModule = module {
    viewModel<LaunchesViewModel>()
    viewModel { (launch: Launch) ->
        LaunchViewModel(
            launch = launch,
            mainFlow = get(),
            resourceProvider = get()
        )
    }
}