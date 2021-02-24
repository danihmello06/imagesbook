package com.example.imagesbook.view

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen
import com.ethanhua.skeleton.Skeleton
import com.example.imagesbook.R
import com.example.imagesbook.TopSpacingItemDecoration
import com.example.imagesbook.adapter.StaggeredRecycleAdapter
import com.example.imagesbook.viewmodel.AppViewModel
import kotlinx.android.synthetic.main.fragment_01.*


class Fragment01 : Fragment() {

    private val staggeredRecycleAdapter by lazy { StaggeredRecycleAdapter() }
    lateinit var viewModel: AppViewModel
    lateinit var skeletonScreen: RecyclerViewSkeletonScreen

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_01, container, false)
    }

    override fun onResume() {
        super.onResume()
        viewModel = ViewModelProvider(requireActivity()).get(AppViewModel::class.java)
        initView()
        viewModel.post.observe(viewLifecycleOwner, Observer { posts ->
            staggeredRecycleAdapter.submitList(posts)
            skeletonScreen.hide()
            Log.e(Fragment01::class.java.simpleName, "$posts")
        })
        skeletonScreen = Skeleton.bind(recycler_view)
            .adapter(staggeredRecycleAdapter)
            .load(R.layout.layout_default_item_skeleton)
            .show()

        Handler().postDelayed({viewModel.getPosts()}, 2000)
    }

    private fun initView() {
        recycler_view.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            val topSpacingDecoration = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingDecoration)
            adapter = staggeredRecycleAdapter
        }
    }
}
