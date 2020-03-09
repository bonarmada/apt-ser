package io.github.bonarmada.apt_ser

import android.app.Application
import io.github.bonarmada.apt_ser.di.component.AppComponent
import io.github.bonarmada.apt_ser.di.component.DaggerAppComponent
import io.github.bonarmada.apt_ser.di.module.AppModule
import io.github.bonarmada.apt_ser.di.module.NetworkModule

class AptApplication: Application(){

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder()
            .appModule(AppModule(this,this))
            .networkModule(NetworkModule())
            .build()
    }
}