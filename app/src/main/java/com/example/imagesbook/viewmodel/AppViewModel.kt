package com.example.imagesbook.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.imagesbook.adapter.StaggeredRecycleAdapter
import com.example.imagesbook.model.Post
import com.example.imagesbook.model.Posts
import com.example.imagesbook.remote.PostServiceFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AppViewModel : ViewModel() {

    var post: MutableLiveData<MutableList<Post>> = MutableLiveData()

    fun getPosts() {

        PostServiceFactory.makeService().getPostsList().enqueue(object : Callback<MutableList<Post>>{
            override fun onResponse(
                call: Call<MutableList<Post>>,
                response: Response<MutableList<Post>>
            ) {
                post.postValue(response.body())
                println("Onresponse: ${post.value}")

            }

            override fun onFailure(call: Call<MutableList<Post>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

}