package com.sawapps.space.utils.bindings

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

/**
 * Created by Mateusz Sawa on 15/11/2020.
 */
@BindingAdapter("app:isVisible")
fun View.isVisible(isVisible: Boolean) {
    this.isVisible = isVisible
}