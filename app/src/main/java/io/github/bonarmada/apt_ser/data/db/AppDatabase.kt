package io.github.bonarmada.apt_ser.data.db

import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.RoomDatabase
import io.github.bonarmada.apt_ser.data.model.MediaDataModel


@Database(entities = [MediaDataModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun mediaDao(): MediaDao
}