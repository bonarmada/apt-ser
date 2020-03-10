package io.github.bonarmada.apt_ser.ui.base

import androidx.appcompat.app.AppCompatActivity
import io.github.bonarmada.apt_ser.di.ViewModelFactory
import javax.inject.Inject


open class BaseActivity: AppCompatActivity(){
    @Inject
    lateinit var factory: ViewModelFactory
}