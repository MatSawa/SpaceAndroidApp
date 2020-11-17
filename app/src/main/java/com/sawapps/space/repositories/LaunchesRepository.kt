package com.sawapps.space.repositories

import com.sawapps.space.api.ApiService
import com.sawapps.space.api.makeRequest
import com.sawapps.space.common.ConnectivityService
import com.sawapps.space.common.SchedulerProvider
import com.sawapps.space.database.daos.LaunchDao
import com.sawapps.space.mappers.toDomain
import com.sawapps.space.mappers.toEntity
import com.sawapps.space.models.Launch
import io.reactivex.rxjava3.core.Single

/**
 * Created by Mateusz Sawa on 13/11/2020.
 */
interface LaunchesRepository {
    fun getLaunches(): Single<List<Launch>>
}

class LaunchesRepositoryImpl(
    private val schedulerProvider: SchedulerProvider,
    private val connectivityService: ConnectivityService,
    private val apiService: ApiService,
    private val launchDao: LaunchDao
) : LaunchesRepository {
    
    //We can return here LiveData to have real time update from Room
    override fun getLaunches(): Single<List<Launch>> {
        return apiService.getLaunches().makeRequest(schedulerProvider, connectivityService)
            .map { it.map { launchResponse -> launchResponse.toEntity() } }
            .doOnSuccess { launchDao.insert(it) }
            .onErrorReturn { launchDao.getAll() }
            .map { it.map { launchEntity -> launchEntity.toDomain() } }
    }
}