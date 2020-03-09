package io.github.bonarmada.apt_ser.di.component

import dagger.Component
import io.github.bonarmada.apt_ser.MainActivity
import io.github.bonarmada.apt_ser.di.module.AppModule
import io.github.bonarmada.apt_ser.di.module.NetworkModule
import io.github.bonarmada.apt_ser.di.module.RemoteModule
import io.github.bonarmada.apt_ser.di.scope.AppScope


@AppScope
@Component(modules = [AppModule::class, RemoteModule::class, NetworkModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}