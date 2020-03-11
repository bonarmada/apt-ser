package io.github.bonarmada.apt_ser.data.service

import io.github.bonarmada.apt_ser.data.model.Media
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MediaRemote {

    @GET("/search")
    fun getAll(
        @Query("term", encoded = true) term: String,
        @Query("country") country: String,
        @Query("media") media: String
    ):  Single<Response<MediaResponseData>>
}
