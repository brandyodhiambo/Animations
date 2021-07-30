package com.adhanjas.animations

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("search/anime?q=naruto")
    fun getAnimations() :Call<AnimationModel>


    fun getCountries()
}

object AnimationsApi{
    private const val BASE_URL="https://api.jikan.moe/v3/"
    private val retrofit=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val apiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}