package com.example.imagesbook.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.imagesbook.remote.PostService
import com.example.imagesbook.remote.PostServiceFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class Posts : Observable() {

    val postList: ArrayList<Post> = ArrayList()
    val posts: MutableLiveData<List<Post>> = MutableLiveData()

    fun addPost(post: Post) { postList.add(post) }

    fun fetchList() {
        val callback = object : Callback<Posts> {
            override fun onResponse(call: Call<Posts>, response: Response<Posts>) {
                var postBody = response.body()
                posts.value = postBody?.postList
            }

            override fun onFailure(call: Call<Posts>, t: Throwable) {
                Log.e("Test", t.message, t)
            }

        }
        PostServiceFactory.makeService().getPostsList().enqueue(callback)
    }

}