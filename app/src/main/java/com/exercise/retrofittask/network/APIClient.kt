package com.exercise.retrofittask.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIClient {
    const val  BASE_URL ="https://api.themoviedb.org/3/"

    val instance : MovieAPI by lazy {
        val retrofit= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(MovieAPI::class.java)
    }
}