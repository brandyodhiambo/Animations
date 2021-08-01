package com.adhanjas.animations


import com.google.gson.annotations.SerializedName

class CountryModel : ArrayList<CountryModel.CountryModelItem>(){
    data class CountryModelItem(

        @SerializedName("capital")
        val capital: String?,
        @SerializedName("flag")
        val flag: String?,
        @SerializedName("name")
        val name: String?
    )
}
