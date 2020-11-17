package com.sawapps.space.usecases

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single


/**
 * Created by Mateusz Sawa on 13/11/2020.
 */
abstract class CompletableUseCase : UseCase<Completable>()

abstract class CompletableParamUseCase<T> : ParamUseCase<Completable, T>()

abstract class SingleUseCase<T> : UseCase<Single<T>>()

abstract class SingleParamUseCase<T, Z> : ParamUseCase<Single<T>, Z>()

abstract class FlowableUseCase<T> : UseCase<Flowable<T>>()

abstract class FlowableParamUseCase<T, Z> : ParamUseCase<Flowable<T>, Z>()

abstract class UseCase<out T> {

    abstract fun buildUseCase(): T

    open fun execute(): T = buildUseCase()
}

abstract class ParamUseCase<in T, out Z> {

    abstract fun buildUseCase(param: T): Z

    open fun execute(param: T): Z = buildUseCase(param)
}