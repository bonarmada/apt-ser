package io.github.bonarmada.apt_ser.view.ui.main

import androidx.lifecycle.*
import io.github.bonarmada.apt_ser.data.model.Media
import io.github.bonarmada.apt_ser.data.model.MediaDataModel
import io.github.bonarmada.apt_ser.data.repo.MediaRepository
import io.github.bonarmada.apt_ser.ui.util.toModel
import io.github.bonarmada.apt_ser.ui.viewitems.MediaItem
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: MediaRepository) : ViewModel() {

    lateinit var liveFeed: LiveData<List<MediaItem>>
    internal var loadingINdicator: MutableLiveData<Boolean> = MutableLiveData(false)

    init {
        subscribe()
    }

    fun subscribe() {
        this.liveFeed = this.repository.getMediaFeed()
        this.repository.fetchMediaFromRemote("Star", "AU", "movie")
    }

    fun searchMedia(term: String) {
        loadingINdicator.value = true
        this.repository.fetchMediaFromRemote(term, "AU", "movie")
    }

}