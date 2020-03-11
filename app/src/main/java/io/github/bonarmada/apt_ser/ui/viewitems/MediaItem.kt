package io.github.bonarmada.apt_ser.ui.viewitems

import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.xwray.groupie.databinding.BindableItem
import io.github.bonarmada.apt_ser.R
import io.github.bonarmada.apt_ser.data.model.MediaDataModel
import io.github.bonarmada.apt_ser.databinding.ItemMediaBinding


class MediaItem(private val media: MediaDataModel): BindableItem<ItemMediaBinding>() {
    override fun getLayout(): Int = R.layout.item_media

    override fun bind(viewBinding: ItemMediaBinding, position: Int) {
        viewBinding.item = media
    }
}