package com.adhanjas.animations

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("search/anime?q=naruto")
    fun getAnimations() :Call<AnimationModel>

    @GET("all")
    fun getCountries() :Call<CountryModel>

    @POST("1FAIpQLSfeHIGfXwP9e-F_9EXZre8baBamyp4O2QLxhv3KLHSZY7AlQQ/formResponse")
    @FormUrlEncoded
    fun submitProject(
            @Field("entry.1383925249")firstName: String,
            @Field("entry.769848575")lastName: String,
            @Field("entry.1114189728")emailAddress:String,
            @Field("entry.531069246")gitHubLink: String
    ):Call<Void>
}

object AnimationsApi{
    private const val BASE_URL="https://api.jikan.moe/v3/"
    private const val BASE_URL2="https://restcountries.eu/rest/v2/"
    private const val BASE_URL3="https://docs.google.com/forms/d/e/"

    private val retrofit=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private val retrofit2=Retrofit.Builder()
            .baseUrl(BASE_URL2)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private val retrofit3=Retrofit.Builder()
        .baseUrl(BASE_URL3)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService1 by lazy {
        retrofit.create(ApiService::class.java)
    }

    val apiService2 by lazy {
        retrofit2.create(ApiService::class.java)
    }

    val apiService3 by lazy {
        retrofit3.create(ApiService::class.java)
    }
}