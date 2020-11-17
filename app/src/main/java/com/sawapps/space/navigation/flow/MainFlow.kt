package com.sawapps.space.navigation.flow

import com.sawapps.space.R
import com.sawapps.space.models.Launch
import com.sawapps.space.navigation.Navigator
import com.sawapps.space.views.launches.LaunchesFragmentDirections

/**
 * Created by Mateusz Sawa on 13/11/2020.
 */
interface MainFlow : Flow {
    fun show(launch: Launch)
}

class MainFlowImpl(navigator: Navigator) : MainFlow, BaseFlow(navigator, R.id.navigationFragment) {
    override fun show(launch: Launch) = navigateTo(
        LaunchesFragmentDirections.actionLaunchesFragmentToLaunchFragment(
            launch
        )
    )
}