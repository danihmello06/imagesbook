package com.example.imagesbook.remote

import com.example.imagesbook.model.Post
import com.example.imagesbook.model.Posts
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PostServiceFactory {

    private val API_BASE_URL = "http://192.168.0.10:8080/"

    fun makeService(): PostService {
        val logging = HttpLoggingInterceptor()
        logging.apply { logging.level = HttpLoggingInterceptor.Level.BODY }

        val httpClient = OkHttpClient.Builder().addInterceptor(logging)

        val gson = GsonBuilder()
            .registerTypeAdapter(
                Posts::class.java,
                JsonPostDeserializer())
            .create()

        val builder = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))

        return builder
            .client(httpClient.build())
            .build().create(PostService::class.java)
    }

}