package com.sawapps.space.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.sawapps.space.BR

/**
 * Created by Mateusz Sawa on 13/11/2020.
 */
abstract class BaseFragment<out T : BaseViewModel> : Fragment() {

    @get:LayoutRes
    protected abstract val layout: Int

    protected abstract val viewModel: T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindObservables()
        return DataBindingUtil.inflate<ViewDataBinding>(inflater, layout, container, false).apply {
            setVariable(BR.viewModel, viewModel)
            lifecycleOwner = this@BaseFragment
        }.root
    }

    protected open fun bindObservables() {
        viewModel.errorMessage.observe(viewLifecycleOwner, ::showError)
    }

    private fun showError(message: String) =
        Snackbar.make(requireView(), message, Snackbar.LENGTH_LONG).show()
}
