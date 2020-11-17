package com.sawapps.space.views

import com.sawapps.space.R
import com.sawapps.space.navigation.Navigator
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity(R.layout.activity_main) {
    override val navigator: Navigator by inject()
}