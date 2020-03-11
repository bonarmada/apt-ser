package io.github.bonarmada.apt_ser.ui.util

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


object DateBindingAdapter {
    @JvmStatic
    @BindingAdapter("imageUrl")
    fun setImageUrl(view: AppCompatImageView, url: String) {
        Glide.with(view.context).load(url)
            .into(view)
    }
}
