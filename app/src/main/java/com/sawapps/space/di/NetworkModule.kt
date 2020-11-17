package com.sawapps.space.di

import android.content.Context
import com.google.gson.internal.bind.util.ISO8601Utils
import com.readystatesoftware.chuck.ChuckInterceptor
import com.sawapps.space.BuildConfig
import com.sawapps.space.api.ApiService
import com.sawapps.space.utils.CustomDateAdapter
import com.squareup.moshi.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


/**
 * Created by Mateusz Sawa on 12/11/2020.
 */

private const val TIMEOUT = 15_000L

val networkModule = module {
    factory {
        Moshi.Builder()
            .add(CustomDateAdapter())
            .add(com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory())
            .build()
    }
    single { createOkHttpClient(context = androidContext()) }
    single { createApiService<ApiService>(okHttpClient = get(), moshi = get()) }
}

private inline fun <reified T> createApiService(okHttpClient: OkHttpClient, moshi: Moshi): T =
    createWebService(
        okHttpClient,
        url = BuildConfig.API_URL,
        factory = MoshiConverterFactory.create(moshi)
    )

private inline fun <reified T> createWebService(
    okHttpClient: OkHttpClient,
    url: String,
    factory: Converter.Factory
): T = Retrofit.Builder()
    .baseUrl(url)
    .client(okHttpClient)
    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
    .addConverterFactory(factory)
    .build().create(T::class.java)

private fun createOkHttpClient(context: Context): OkHttpClient {
    val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    return OkHttpClient.Builder()
        .connectTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
        .readTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
        .addInterceptor(logging)
        .addInterceptor(ChuckInterceptor(context))
        .build()
}