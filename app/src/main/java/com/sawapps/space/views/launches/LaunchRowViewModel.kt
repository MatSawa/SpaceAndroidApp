package com.sawapps.space.views.launches

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sawapps.space.models.Launch

/**
 * Created by Mateusz Sawa on 14/11/2020.
 */
class LaunchRowViewModel(val launch: Launch) {
    val imageUrl: LiveData<String> = MutableLiveData(launch.imageUrl)
    val title: LiveData<String> = MutableLiveData(launch.name)
    val description: LiveData<String> = MutableLiveData(launch.description)
}