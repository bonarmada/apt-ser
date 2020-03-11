package io.github.bonarmada.apt_ser.ui.util

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import javax.inject.Inject

class Prefs @Inject internal constructor(internal val context: Context) {
    private val prefsName = "io.github.bonarmada.apt_ser"
    private val KEY_LAST_ACTIVITY = "key_last_activity"
    private val KEY_CACHED_MEDIA = "key_cached_media"

    private val prefs: SharedPreferences = context.getSharedPreferences(prefsName, 0)

    var lastActivity: String?
        get() {
            return prefs.getString(KEY_LAST_ACTIVITY, null)
        }
        set(value)  {
            prefs.edit().putString(KEY_LAST_ACTIVITY, value).apply()
        }

    var cachedMedia: String?
        get() = prefs.getString(KEY_CACHED_MEDIA, null)
        set(value) = prefs.edit().putString(KEY_CACHED_MEDIA, value).apply()
}