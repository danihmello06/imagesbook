package com.example.imagesbook.viewmodel

import androidx.lifecycle.ViewModel
import com.example.imagesbook.adapter.StaggeredRecycleAdapter
import com.example.imagesbook.model.Post
import com.example.imagesbook.model.Posts

class AppViewModel : ViewModel() {

    lateinit var posts: Posts
    lateinit var adapter: StaggeredRecycleAdapter
    //lateinit var

    init {
        posts = Posts()
        adapter = StaggeredRecycleAdapter()
    }

}