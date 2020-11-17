package com.sawapps.space.views.launches

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.sawapps.space.R
import com.sawapps.space.common.ResourceProvider
import com.sawapps.space.models.Launch
import com.sawapps.space.navigation.flow.MainFlow
import com.sawapps.space.usecases.launches.GetLaunchesUseCase
import com.sawapps.space.views.BaseViewModel

/**
 * Created by Mateusz Sawa on 13/11/2020.
 */
class LaunchesViewModel(
    private val resourceProvider: ResourceProvider,
    private val mainFlow: MainFlow,
    getLaunchesUseCase: GetLaunchesUseCase
) : BaseViewModel() {
    private val _launches = MutableLiveData<List<LaunchRowViewModel>>(emptyList())
    val launches: LiveData<List<LaunchRowViewModel>> = _launches
    val isEmptyList = Transformations.map(launches) { it.isEmpty() }

    init {
        getLaunchesUseCase.execute()
            .map { it.map { launch -> LaunchRowViewModel(launch) } }
            .subscribeWithDispose(onSuccess = {
                _launches.postValue(it)
            }, onError = {
                setError(resourceProvider.getString(R.string.error_launch))
            })
    }

    fun open(launch: Launch) = mainFlow.show(launch)
}