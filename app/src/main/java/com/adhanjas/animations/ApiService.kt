package com.adhanjas.animations

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("search/anime?q=naruto")
    fun getAnimations() :Call<AnimationModel>

    @GET("all")
    fun getCountries() :Call<CountryModel>
}

object AnimationsApi{
    private const val BASE_URL="https://api.jikan.moe/v3/"
    private const val BASE_URL2="https://restcountries.eu/rest/v2/"

    private val retrofit=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private val retrofit2=Retrofit.Builder()
            .baseUrl(BASE_URL2)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val apiService1 by lazy {
        retrofit.create(ApiService::class.java)
    }

    val apiService2 by lazy {
        retrofit2.create(ApiService::class.java)
    }
}