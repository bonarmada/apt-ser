package io.github.bonarmada.apt_ser.ui.util

import android.util.Log
import androidx.room.TypeConverter
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object DateConverter {

    private val serverDfPatern: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")

    @TypeConverter
    @JvmStatic
    fun fromTimestamp(value: String): Date {
        try {
            return serverDfPatern.parse(value)
        } catch (e: ParseException) {
            e.printStackTrace()
            Log.e("ParseEcception", e.toString())
        }
        return Date()
    }

    @TypeConverter
    @JvmStatic
    fun dateToTimestamp(value: Date): String {
        return serverDfPatern.format(value)
    }


}