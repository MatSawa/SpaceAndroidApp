package com.sawapps.space.utils

import com.orhanobut.logger.Logger

/**
 * Created by Mateusz Sawa on 13/11/2020.
 */
private const val TAG = "[DEBUG]"
private const val TAG_ERROR = "$TAG ERROR:"

fun Any.log() = Logger.t(TAG).v(this.toString())
fun Exception.log() = Logger.t(TAG).e(this.message ?: this.toString())
fun Throwable.log() = Logger.t(TAG).e(this.message ?: this.toString())