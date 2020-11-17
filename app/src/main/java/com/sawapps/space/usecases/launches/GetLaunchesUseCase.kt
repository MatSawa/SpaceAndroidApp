package com.sawapps.space.usecases.launches

import com.sawapps.space.models.Launch
import com.sawapps.space.repositories.LaunchesRepository
import com.sawapps.space.usecases.SingleUseCase
import io.reactivex.rxjava3.core.Single

/**
 * Created by Mateusz Sawa on 13/11/2020.
 */
class EmptyLaunches : Exception()

class GetLaunchesUseCase(private val launchesRepository: LaunchesRepository) :
    SingleUseCase<List<Launch>>() {
    override fun buildUseCase(): Single<List<Launch>> = launchesRepository.getLaunches()
        .map { if (it.isEmpty()) throw EmptyLaunches() else it }
}