package com.sawapps.space.views.launch

import com.sawapps.space.R
import com.sawapps.space.views.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

/**
 * Created by Mateusz Sawa on 16/11/2020.
 */
class LaunchFragment : BaseFragment<LaunchViewModel>() {
    override val layout: Int = R.layout.fragment_launch
    override val viewModel: LaunchViewModel by viewModel {
        val arguments = LaunchFragmentArgs.fromBundle(requireArguments());
        parametersOf(arguments.launch)
    }
}
