package com.sawapps.space.common

import android.content.Context
import androidx.annotation.StringRes

/**
 * Created by Mateusz Sawa on 12/11/2020.
 */
interface ResourceProvider {
    fun getString(@StringRes id: Int): String
    fun getString(@StringRes id: Int, vararg args: Any?): String
}

class ResourceProviderImpl(private val context: Context) : ResourceProvider {
    override fun getString(@StringRes id: Int): String = context.getString(id)
    override fun getString(@StringRes id: Int, vararg args: Any?): String =
        context.getString(id, *args)
}
