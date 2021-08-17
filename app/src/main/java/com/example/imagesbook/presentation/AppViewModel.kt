package com.example.imagesbook.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.imagesbook.model.Post
import com.example.imagesbook.remote.PostServiceFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AppViewModel : ViewModel() {

    private var _post: MutableLiveData<List<Post>> = MutableLiveData()
    var post: LiveData<List<Post>> = _post

    fun getPosts() {

        PostServiceFactory.makeService().getPostsList().enqueue(object : Callback<MutableList<Post>>{
            override fun onResponse(
                call: Call<MutableList<Post>>,
                response: Response<MutableList<Post>>
            ) {
                _post.postValue(response.body())
            }

            override fun onFailure(call: Call<MutableList<Post>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

}