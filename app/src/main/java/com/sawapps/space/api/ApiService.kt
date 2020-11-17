package com.sawapps.space.api

import com.sawapps.space.api.responses.LaunchResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

/**
 * Created by Mateusz Sawa on 13/11/2020.
 */
interface ApiService {
    @GET("/v4/launches")
    fun getLaunches(): Single<List<LaunchResponse>>
}