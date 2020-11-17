package com.sawapps.space.navigation

import androidx.lifecycle.LiveData
import androidx.navigation.NavDirections
import com.sawapps.space.utils.SingleLiveEvent

/**
 * Created by Mateusz Sawa on 13/11/2020.
 */

sealed class NavigationCommand(val navHostId: Int) {
    class NavigateToCommand(val navDirection: NavDirections, navHostId: Int) :
        NavigationCommand(navHostId)

    class BackCommand(navHostId: Int) : NavigationCommand(navHostId)
}

class Navigator {
    private val _navigation = SingleLiveEvent<NavigationCommand>()
    val navigation: LiveData<NavigationCommand> = _navigation

    fun navigateUp(backCommand: NavigationCommand.BackCommand) = navigateTo(backCommand)

    fun navigateTo(destination: NavigationCommand) =
        _navigation.postValue(destination)
}
