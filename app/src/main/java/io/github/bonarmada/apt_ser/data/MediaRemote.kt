package io.github.bonarmada.apt_ser.data

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MediaRemote {

    @GET("search")
    fun getAll(
        @Query("term") term: String,
        @Query("country") country: String,
        @Query("media") media: String
    ): Single<Response<List<Int>>>
}
