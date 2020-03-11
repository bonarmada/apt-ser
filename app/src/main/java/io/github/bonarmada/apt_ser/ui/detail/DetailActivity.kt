package io.github.bonarmada.apt_ser.ui.detail

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import io.github.bonarmada.apt_ser.AptApplication
import io.github.bonarmada.apt_ser.R
import io.github.bonarmada.apt_ser.data.model.Media
import io.github.bonarmada.apt_ser.databinding.ActivityDetailBinding
import io.github.bonarmada.apt_ser.ui.base.BaseActivity
import io.github.bonarmada.apt_ser.ui.util.Prefs
import javax.inject.Inject


class DetailActivity : BaseActivity() {
    companion object {
        const val EXTRA_MEDIA_DATA = "extra_media_data"
    }

    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as AptApplication).component.inject(this)


        // Retrieve media data from cache via prefs, other wise retrieve from intent
        val mediaJson = when (prefs.cachedMedia != null) {
            true -> prefs.cachedMedia
            else -> intent?.extras?.getString(EXTRA_MEDIA_DATA, "{}")
        }


        // Save data to preferences cache
        prefs.cachedMedia = mediaJson

        val media = Gson().fromJson(mediaJson, Media::class.java)

        val binding: ActivityDetailBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_detail)

        binding.item = media

        // Provide viewmodel via ViewModelFactory.
        viewModel = ViewModelProvider(this, factory).get(DetailViewModel::class.java)

    }

    override fun onResume() {
        prefs.lastActivity = this::class.java.simpleName
        super.onResume()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        prefs.cachedMedia = null
    }
}