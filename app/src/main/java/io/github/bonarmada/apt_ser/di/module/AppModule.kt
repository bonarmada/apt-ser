package io.github.bonarmada.apt_ser.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import io.github.bonarmada.apt_ser.AptApplication
import io.github.bonarmada.apt_ser.di.scope.AppScope

@Module
class AppModule constructor(private val app: AptApplication, private val context: Context){

    @AppScope
    @Provides
    internal fun provideApplication(): AptApplication = app

    @AppScope
    @Provides
    internal fun provideContext(): Context = context
}