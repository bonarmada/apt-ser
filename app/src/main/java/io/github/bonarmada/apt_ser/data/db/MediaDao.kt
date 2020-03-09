package io.github.bonarmada.apt_ser.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import io.github.bonarmada.apt_ser.data.model.MediaDataModel

@Dao
interface MediaDao {

    @Query("SELECT * from media_table ORDER BY trackId ASC")
    fun getAllMedia(): LiveData<List<MediaDataModel>>
} 