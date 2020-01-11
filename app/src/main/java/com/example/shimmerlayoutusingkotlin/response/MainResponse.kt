package com.example.shimmerlayoutusingkotlin.response

import com.example.shimmerlayoutusingkotlin.model.Item
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

public class MainResponse {
    @SerializedName("items")
    @Expose
    var items: List<Item>? = null
    @SerializedName("result")
    @Expose
    var result: String? = null
}