package com.example.imagesbook.backend.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object UserServiceFactory {

//talvez essa bagaça de treta por nao ser o ip certo
private const val API_BASE_URL = "http://192.168.0.19:8080/"

    fun makeService(): UserService {
        val logging = HttpLoggingInterceptor()
        logging.apply { logging.level = HttpLoggingInterceptor.Level.BODY }

        val httpCLient = OkHttpClient.Builder().addInterceptor(logging)

        val builder = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

        return builder
            .client(httpCLient.build())
            .build().create(UserService::class.java)
    }
}
