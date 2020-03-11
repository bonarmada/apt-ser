package io.github.bonarmada.apt_ser.view.ui.main

import android.os.Bundle
import android.util.Log
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import io.github.bonarmada.apt_ser.AptApplication
import io.github.bonarmada.apt_ser.R
import io.github.bonarmada.apt_ser.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: GroupAdapter<GroupieViewHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as AptApplication).component.inject(this)

        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
        adapter = GroupAdapter()

        viewModel.liveFeed.observe(this, Observer {
            viewModel.loadingINdicator.value = false
            adapter.update(it)
        })

        viewModel.loadingINdicator.observe(this, Observer {
            Log.e("loadingINdicator", it.toString())
        })
    }

    override fun onStart() {
        super.onStart()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        btnSearch.setOnClickListener {
            viewModel.searchMedia(search.text.toString())
        }
    }

}