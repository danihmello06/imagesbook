package com.example.imagesbook.remote

import com.example.imagesbook.model.Post
import com.example.imagesbook.model.User
import retrofit2.Call
import retrofit2.http.*
import java.util.*

interface UserService {

    @GET("user")
    fun getUsersList(): Call<List<User>>

    @PUT("user/create")
    fun createUser(@Body user: User)

    @DELETE("user/{id}")
    fun deleteUser(@Path("id") id: UUID)

    fun getAllImages(): Call<List<Post>>
}