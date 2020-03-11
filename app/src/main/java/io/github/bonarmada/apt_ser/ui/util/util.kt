package io.github.bonarmada.apt_ser.ui.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.google.gson.Gson
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
    this.trackTimeMillis
)

fun MediaDataModel.toGson() = Gson().toJson(this)

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
fun Double.toCurrencyFormat() = String.format("$ %.2f", this)

