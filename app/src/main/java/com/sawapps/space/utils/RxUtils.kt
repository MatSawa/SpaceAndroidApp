package com.sawapps.space.utils

import com.sawapps.space.common.SchedulerProvider
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single

/**
 * Created by Mateusz Sawa on 13/11/2020.
 */
internal fun Completable.applySchedulers(schedulerProvider: SchedulerProvider) =
    observeOn(schedulerProvider.ui()).subscribeOn(schedulerProvider.io())

internal fun <T> Single<T>.applySchedulers(schedulerProvider: SchedulerProvider): Single<T> =
    observeOn(schedulerProvider.ui()).subscribeOn(schedulerProvider.io())

internal fun <T> Flowable<T>.applySchedulers(schedulerProvider: SchedulerProvider): Flowable<T> =
    observeOn(schedulerProvider.ui()).subscribeOn(schedulerProvider.io())
