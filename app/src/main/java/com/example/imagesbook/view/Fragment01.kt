package com.example.imagesbook.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.imagesbook.R
import com.example.imagesbook.adapter.StaggeredRecycleAdapter
import com.example.imagesbook.TopSpacingItemDecoration
import com.example.imagesbook.model.Post
import com.example.imagesbook.model.Posts
import com.example.imagesbook.remote.PostServiceFactory
import com.example.imagesbook.viewmodel.AppViewModel
import kotlinx.android.synthetic.main.fragment_01.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlin.system.measureTimeMillis


class Fragment01 : Fragment() {

    private val staggeredRecycleAdapter by lazy { StaggeredRecycleAdapter() }
    lateinit var viewModel: AppViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_01, container, false)
    }

    override fun onStart() {
        super.onStart()
        initRecyclerView()

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(AppViewModel::class.java)
        viewModel.post.observe(viewLifecycleOwner, Observer { posts ->
            Log.e(Fragment01::class.java.simpleName, "$posts")
        })
        viewModel.getPosts()
        println("post value: ${viewModel.post.value}")


    }

    private fun initRecyclerView() {
        recycler_view.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            val topSpacingDecoration = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingDecoration)
            adapter = staggeredRecycleAdapter
        }
    }
}