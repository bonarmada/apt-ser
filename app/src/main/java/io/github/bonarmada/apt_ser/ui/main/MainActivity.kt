package io.github.bonarmada.apt_ser.view.ui.main

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import com.xwray.groupie.OnItemClickListener
import io.github.bonarmada.apt_ser.AptApplication
import io.github.bonarmada.apt_ser.R
import io.github.bonarmada.apt_ser.data.repo.MediaRepository
import io.github.bonarmada.apt_ser.databinding.ItemMediaBinding
import io.github.bonarmada.apt_ser.ui.base.BaseActivity
import io.github.bonarmada.apt_ser.ui.detail.DetailActivity
import io.github.bonarmada.apt_ser.ui.detail.DetailActivity.Companion.EXTRA_MEDIA_DATA
import io.github.bonarmada.apt_ser.ui.util.MediaType
import io.github.bonarmada.apt_ser.ui.util.Prefs
import io.github.bonarmada.apt_ser.ui.util.toGson
import io.github.bonarmada.apt_ser.ui.viewitems.MediaItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_media.*
import javax.inject.Inject


//class MainActivity @Inject constructor(private val prefs: Prefs) : BaseActivity() {
class MainActivity : BaseActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: GroupAdapter<GroupieViewHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as AptApplication).component.inject(this)

        // Provide viewmodel via ViewModelFactory.
        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)

        // Init Groupie
        adapter = GroupAdapter()

        // Observe feed data changes.
        viewModel.liveFeed.observe(this, Observer {
            viewModel.loadingINdicator.value = false
            adapter.update(it)
        })

        // Loading indicator change listener/observer.
        viewModel.loadingINdicator.observe(this, Observer {
            recyclerViewContainer.isRefreshing = it
        })
    }

    override fun onResume() {
        if ((prefs.cachedMedia) != null){
            startActivity(Intent(this, DetailActivity::class.java))
        }

        prefs.lastActivity = this::class.java.simpleName
        super.onResume()
    }

    override fun onStart() {
        super.onStart()

        // Check cached data, undone session
        when (prefs.lastActivity) {
            DetailActivity::class.java.simpleName -> {

            }
            else -> {
            }
        }

        setupTabLayout()
        setupRecyclerView()
    }

    /**
     * Setup Tablayout with MediaType enum values.
     * @see MediaType
     */
    private fun setupTabLayout() {
        enumValues<MediaType>().forEach {
            tabLayout.addTab(tabLayout.newTab().setText(it.stringValue))
        }

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewModel.selectedTabValue.value = tab?.text.toString()
                refreshFeed()
            }
        })
    }


    /**
     * Setup recyclerview usingn Groupie
     * @link https://github.com/lisawray/groupie
     */
    private fun setupRecyclerView() {
        recyclerViewContainer.setOnRefreshListener {
            refreshFeed()
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        search.setOnEditorActionListener { v, actionId, _ ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_GO -> {
                    v.isFocusableInTouchMode = false
                    v.isFocusable = false
                    v.isFocusableInTouchMode = true
                    v.isFocusable = true
                    refreshFeed()
                    true
                }
                else -> false
            }
        }

        adapter.setOnItemClickListener { item, _ ->
            (item as MediaItem).let { mediaItem ->
                val intent = Intent(this, DetailActivity::class.java).apply {
                    putExtra(EXTRA_MEDIA_DATA, mediaItem.media.toGson())
                }
                startActivity(intent)
            }
        }
    }

    private fun refreshFeed() =
        viewModel.searchMedia(search.text.toString(), viewModel.selectedTabValue.value)
}