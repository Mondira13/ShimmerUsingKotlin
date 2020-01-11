package com.example.shimmerlayoutusingkotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Item {
    @SerializedName("name")
    @Expose
    val name: String? = null
    @SerializedName("image")
    @Expose
    val image: String? = null
    @SerializedName("season")
    @Expose
    val season: String? = null
}