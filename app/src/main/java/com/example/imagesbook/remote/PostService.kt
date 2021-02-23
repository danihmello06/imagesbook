package com.example.imagesbook.remote

import com.example.imagesbook.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface PostService {

    @GET("post")
    fun getPostsList() : Call<MutableList<Post>>

}