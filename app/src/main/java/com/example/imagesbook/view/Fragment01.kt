package com.example.imagesbook.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.imagesbook.R
import com.example.imagesbook.adapter.StaggeredRecycleAdapter
import com.example.imagesbook.TopSpacingItemDecoration
import com.example.imagesbook.model.Post
import com.example.imagesbook.model.Posts
import com.example.imagesbook.remote.PostServiceFactory
import kotlinx.android.synthetic.main.fragment_01.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlin.system.measureTimeMillis


class Fragment01 : Fragment() {

    private val staggeredRecycleAdapter by lazy { StaggeredRecycleAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_01, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        CoroutineScope(IO).launch {
            initializeData()
        }
//        initRecyclerView()
//        addDataSet()
    }

    private suspend fun initializeData() {

        withContext(Main) {

            //ROTINAS SEQUENCIAIS

            val executionTime = measureTimeMillis {

                val result1 = async {
                    initRecyclerView()
                }.await()

                val result2 = async {
                    addDataSet()
                }.await()

            }
            println("Total elapsed time: $executionTime ms.")
        }
    }

    private suspend fun addDataSet() {
        delay(100)

        val data = PostServiceFactory.makeService().getPostsList()
        //staggeredRecycleAdapter.submitList(data)
    }

//    private fun getAllPosts() : List<Posts>{
//        return PostServiceFactory.makeService().getPostsList()
//    }

    private suspend fun initRecyclerView() {
        delay(1500)
        recycler_view.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            //layoutManager =   LinearLayoutManager(context)
            val topSpacingDecoration = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingDecoration)
            adapter = staggeredRecycleAdapter
        }
    }


}