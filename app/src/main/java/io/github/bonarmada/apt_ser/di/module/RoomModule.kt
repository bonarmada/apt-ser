package io.github.bonarmada.apt_ser.di.module

import androidx.room.Room
import dagger.Module
import dagger.Provides
import io.github.bonarmada.apt_ser.AptApplication
import io.github.bonarmada.apt_ser.data.db.AppDatabase
import io.github.bonarmada.apt_ser.di.scope.AppScope


@Module(includes = [AppModule::class])
class RoomModule{

    @AppScope
    @Provides
    fun provideHnDatabase(app: AptApplication): AppDatabase = Room.databaseBuilder(app,
        AppDatabase::class.java, "hn-todo.db").build()

    @AppScope
    @Provides
    fun provideStoryDao(db: AppDatabase) = db.mediaDao()
}