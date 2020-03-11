package io.github.bonarmada.apt_ser.data.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import io.github.bonarmada.apt_ser.data.service.MediaRemote
import io.github.bonarmada.apt_ser.data.db.MediaDao
import io.github.bonarmada.apt_ser.data.model.Media
import io.github.bonarmada.apt_ser.data.model.MediaDataModel
import io.github.bonarmada.apt_ser.ui.util.toDataModel
import io.github.bonarmada.apt_ser.ui.util.toModel
import io.github.bonarmada.apt_ser.ui.viewitems.MediaItem
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class MediaRepository @Inject internal constructor(
    internal val remote: MediaRemote,
    internal val dao: MediaDao
) {
    companion object {
        const val TAG = "MediaRepository"
    }

    fun fetchMediaFromRemote(
        term: String,
        country: String,
        media: String
    ) {
        remote.getAll(term, country, media)
            .subscribeOn(Schedulers.io())
            .subscribe { res, ex ->
                if (res.code() == 200) {
                    dao.clear()
                    res.body()?.results?.forEach {
                        dao.insert(it.toDataModel())
                    }
                }
            }
    }

    fun getMediaFeed(): LiveData<List<MediaItem>> =
        Transformations.map(dao.getAllMedia()) {
            ArrayList<MediaItem>().apply {
                it.forEach {
                    this.add(MediaItem(it))
                }
            }
        }

    fun getMedia(trackId: Int): LiveData<Media> =
        Transformations.map(dao.getMedia(trackId)){
            it.toModel()
        }
}