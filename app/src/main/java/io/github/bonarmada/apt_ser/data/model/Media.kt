package io.github.bonarmada.apt_ser.data.model

import java.util.*

data class Media(
    val trackId: Long = 0,
    val trackName: String = "",
    val artistName: String = "",
    val artworkUrl100: String = "",
    val trackPrice: Double = 0.0,
    val currency: String = "",
    val country: String = "",
    val primaryGenreName: String = "",
    val shortDescription: String = "",
    val longDescription: String = "",
    val trackTimeMillis: Long = 0,
    val releaseDate: Date = Date()
)