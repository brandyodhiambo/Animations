package com.adhanjas.animations


import com.google.gson.annotations.SerializedName

data class AnimationModel(

    @SerializedName("results")
    val results: List<Result?>?
) {
    data class Result(

        @SerializedName("image_url")
        val imageUrl: String?,
        @SerializedName("synopsis")
        val synopsis: String?,
        @SerializedName("title")
        val title: String?

    )
}