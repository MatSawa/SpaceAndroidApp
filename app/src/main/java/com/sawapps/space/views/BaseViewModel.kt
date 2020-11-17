package com.sawapps.space.views

import androidx.lifecycle.LiveData
import autodispose2.autoDispose
import autodispose2.recipes.AutoDisposeViewModel
import com.sawapps.space.utils.SingleLiveEvent
import com.sawapps.space.utils.log
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.Disposable

open class BaseViewModel : AutoDisposeViewModel() {
    private val _errorMessage = SingleLiveEvent<String>()
    val errorMessage: LiveData<String> = _errorMessage

    fun Completable.subscribeWithDispose(
        onError: (Throwable) -> Unit = { it.log() },
        onSuccess: () -> Unit = {}
    ): Disposable = autoDispose(this@BaseViewModel).subscribe(onSuccess, onError)

    fun <T> Single<T>.subscribeWithDispose(
        onError: (Throwable) -> Unit = { it.log() },
        onSuccess: (T) -> Unit = {}
    ): Disposable = autoDispose(this@BaseViewModel).subscribe(onSuccess, onError)

    fun <T> Flowable<T>.subscribeWithDispose(
        onError: (Throwable) -> Unit = { it.log() },
        onSuccess: (T) -> Unit = {}
    ): Disposable = autoDispose(this@BaseViewModel).subscribe(onSuccess, onError)

    protected fun setError(message: String) {
        _errorMessage.postValue(message)
    }
}
