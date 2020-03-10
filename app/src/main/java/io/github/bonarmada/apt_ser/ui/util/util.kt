package io.github.bonarmada.apt_ser.ui.util

import io.github.bonarmada.apt_ser.data.model.Media
import io.github.bonarmada.apt_ser.data.model.MediaDataModel

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
    this.trackTimeMillis
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
    this.trackTimeMillis
)