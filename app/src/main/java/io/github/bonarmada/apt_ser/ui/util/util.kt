package io.github.bonarmada.apt_ser.ui.util

import io.github.bonarmada.apt_ser.data.model.Media
import io.github.bonarmada.apt_ser.data.model.MediaDataModel
import java.text.SimpleDateFormat
import java.util.*

fun MediaDataModel.toModel() = Media(
    this.trackId,
    this.trackName,
    this.artistName,
    this.artworkUrl100,
    this.trackPrice,
    this.currency,
    this.country,
    this.primaryGenreName,
    this.shortDescription,
    this.longDescription,
    this.trackTimeMillis,
    this.releaseDate
)

fun Media.toDataModel() = MediaDataModel(
    this.trackId,
    this.trackName,
    this.artistName,
    this.artworkUrl100,
    this.trackPrice,
    this.currency,
    this.country,
    this.primaryGenreName,
    this.shortDescription,
    this.longDescription,
    this.trackTimeMillis,
    this.releaseDate
)

fun Double.toCurrencyFormat() = String.format("$ %.2f", this)
fun Date.getYearString() = SimpleDateFormat("yyyy").format(this);