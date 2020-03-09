package io.github.bonarmada.apt_ser.data.repo

import io.github.bonarmada.apt_ser.data.MediaRemote
import io.github.bonarmada.apt_ser.data.db.MediaDao
import javax.inject.Inject


class MediaRepository @Inject internal constructor(
    internal val remote: MediaRemote,
    internal val dao: MediaDao
) {
    companion object {
        const val TAG = "MediaRepository"
    }

}