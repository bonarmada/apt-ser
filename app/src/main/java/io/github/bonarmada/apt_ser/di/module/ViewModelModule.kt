package io.github.bonarmada.apt_ser.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.github.bonarmada.apt_ser.di.ViewModelFactory
import io.github.bonarmada.apt_ser.di.ViewModelKey
import io.github.bonarmada.apt_ser.di.scope.AppScope
import io.github.bonarmada.apt_ser.ui.detail.DetailViewModel
import io.github.bonarmada.apt_ser.view.ui.main.MainViewModel


@Module
abstract class ViewModelModule {

    @AppScope
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @AppScope
    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun bindDetailViewModel(detailViewModel: DetailViewModel): ViewModel

    // Factory
    @AppScope
    @Binds
    abstract fun bindViewModelFactory(vmFactory: ViewModelFactory): ViewModelProvider.Factory
}
