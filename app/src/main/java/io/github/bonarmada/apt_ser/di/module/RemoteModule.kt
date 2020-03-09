package io.github.bonarmada.apt_ser.di.module

import dagger.Module
import dagger.Provides
import io.github.bonarmada.apt_ser.data.MediaRemote
import io.github.bonarmada.apt_ser.di.scope.AppScope
import retrofit2.Retrofit


@Module(includes = [NetworkModule::class])
class RemoteModule{
    @AppScope
    @Provides
    internal fun provideMediaRemote(retrofit: Retrofit): MediaRemote = retrofit.create(MediaRemote::class.java)
}