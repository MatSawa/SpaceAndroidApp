package com.sawapps.space.utils.bindings

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

/**
 * Created by Mateusz Sawa on 15/11/2020.
 */
@BindingAdapter("imageUrl", "placeholder")
fun ImageView.setImage(imageUrl: String, placeholder: Drawable) = load(imageUrl) {
    crossfade(true)
    placeholder(placeholder)
}