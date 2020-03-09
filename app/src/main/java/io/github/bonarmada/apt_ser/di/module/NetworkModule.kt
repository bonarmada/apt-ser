package io.github.bonarmada.apt_ser.di.module

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.github.bonarmada.apt_ser.di.scope.AppScope
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module(includes = [AppModule::class])
class NetworkModule {

    @AppScope
    @Provides
    fun provideRequestInterceptor(): Interceptor =
        Interceptor { chain ->
            chain.proceed(
                chain.request().newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept", "application/json")
                    .build()
            )
        }

    @AppScope
    @Provides
    internal fun provideHttpClient(requestInterceptor: Interceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .build()

    @Provides
    @AppScope
    internal fun provideGson(): Gson =
        GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()

    @AppScope
    @Provides
    internal fun provideRetrofit(gson: Gson, httpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("https://itunes.apple.com")
            .client(httpClient)
            .build()
}
