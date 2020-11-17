package com.sawapps.space.views.launch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sawapps.space.R
import com.sawapps.space.common.ResourceProvider
import com.sawapps.space.models.Launch
import com.sawapps.space.navigation.flow.MainFlow
import com.sawapps.space.utils.toDateTime
import com.sawapps.space.views.BaseViewModel

/**
 * Created by Mateusz Sawa on 16/11/2020.
 */
class LaunchViewModel(
    launch: Launch,
    resourceProvider: ResourceProvider,
    private val mainFlow: MainFlow
) :
    BaseViewModel() {
    val imageUrl: LiveData<String> = MutableLiveData(launch.imageUrl)
    val title: LiveData<String> = MutableLiveData(
        resourceProvider.getString(
            R.string.launch_title,
            launch.name,
            launch.date.toDateTime()
        )
    )
    val description: LiveData<String> = MutableLiveData(launch.description)

    fun onBack() = mainFlow.navigateUp()
}