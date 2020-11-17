package com.sawapps.space.views

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.sawapps.space.R
import com.sawapps.space.navigation.NavigationCommand
import com.sawapps.space.navigation.Navigator

/**
 * Created by Mateusz Sawa on 13/11/2020.
 */
abstract class BaseActivity(@LayoutRes layoutId: Int) : AppCompatActivity(layoutId) {

    protected abstract val navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigator.navigation.observe(this, { navigationCommand ->
            when (navigationCommand) {
                is NavigationCommand.NavigateToCommand -> runCatching {
                    findNavController(navigationCommand.navHostId).navigate(navigationCommand.navDirection)
                }
                is NavigationCommand.BackCommand -> findNavController(navigationCommand.navHostId).navigateUp()
            }
        })
    }
}
