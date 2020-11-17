package com.sawapps.space.api

import com.sawapps.space.common.ConnectivityService
import com.sawapps.space.common.SchedulerProvider
import com.sawapps.space.utils.applySchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import java.util.concurrent.TimeUnit

/**
 * Created by Mateusz Sawa on 13/11/2020.
 */
private const val TIMEOUT = 20_000L

internal fun <T> Single<T>.makeRequest(
    schedulerProvider: SchedulerProvider,
    connectivityService: ConnectivityService
): Single<T> =
    applySchedulers(schedulerProvider)
        .timeout(
            TIMEOUT,
            TimeUnit.MILLISECONDS,
            Single.error(ApiException.NotRespondingException())
        )
        .checkConnectivity(connectivityService)

internal fun Completable.makeRequest(
    schedulerProvider: SchedulerProvider,
    connectivityService: ConnectivityService
): Completable =
    applySchedulers(schedulerProvider)
        .timeout(
            TIMEOUT,
            TimeUnit.MILLISECONDS,
            Completable.error(ApiException.NotRespondingException())
        )
        .checkConnectivity(connectivityService)

internal fun Completable.checkConnectivity(connectivityService: ConnectivityService): Completable =
    if (connectivityService.isNetworkConnection) this else Completable.error(ApiException.NoInternetConnectionException())

internal fun <T> Single<T>.checkConnectivity(connectivityService: ConnectivityService): Single<T> =
    if (connectivityService.isNetworkConnection) this else Single.error(ApiException.NoInternetConnectionException())
