package com.sawapps.space.navigation.flow

import androidx.navigation.NavDirections
import com.sawapps.space.navigation.NavigationCommand
import com.sawapps.space.navigation.Navigator

/**
 * Created by Mateusz Sawa on 13/11/2020.
 */
interface Flow {
    fun navigateUp()
}

abstract class BaseFlow(
    private val navigator: Navigator,
    private val navHostId: Int
) : Flow {
    protected fun navigateTo(navDirection: NavDirections) =
        NavigationCommand.NavigateToCommand(navDirection, navHostId)
            .let { navigator.navigateTo(it) }

    override fun navigateUp() = navigator.navigateUp(NavigationCommand.BackCommand(navHostId))
}
