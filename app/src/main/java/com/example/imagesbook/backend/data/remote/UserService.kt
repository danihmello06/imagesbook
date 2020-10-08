package com.example.imagesbook.backend.data.remote

import com.example.imagesbook.backend.model.User
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

}