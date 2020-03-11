package io.github.bonarmada.apt_ser.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.bonarmada.apt_ser.data.model.Media
import io.github.bonarmada.apt_ser.data.repo.MediaRepository
import io.github.bonarmada.apt_ser.ui.viewitems.MediaItem
import javax.inject.Inject


class DetailViewModel @Inject constructor(private val repository: MediaRepository) : ViewModel() {

    internal var currentTrackId: MutableLiveData<Int> = MutableLiveData(0);

    internal val liveMedia: LiveData<Media> by lazy {
//        repository.getMedia(trackId = currentTrackId.value!!)
        repository.getMedia(trackId = currentTrackId.value!!)
    }


}