package io.github.bonarmada.apt_ser.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "media_table")
data class MediaDataModel(

    @PrimaryKey val trackId: Long = 0,
    val trackName: String = "",
    val artistName: String = "",
    val artworkUrl100: String = "",
    val trackPrice: Double = 0.0,
    val currency: String = "",
    val country: String = "",
    val primaryGenreName: String = "",
    val shortDescription: String = "",
    val longDescription: String = "",
    val trackTimeMillis: Long = 0
)