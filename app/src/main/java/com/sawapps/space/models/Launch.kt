package com.sawapps.space.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.time.LocalDateTime

/**
 * Created by Mateusz Sawa on 14/11/2020.
 */
@Parcelize
data class Launch(
    val id: String,
    val name: String,
    val description: String,
    val imageUrl: String,
    val date: LocalDateTime
) : Parcelable