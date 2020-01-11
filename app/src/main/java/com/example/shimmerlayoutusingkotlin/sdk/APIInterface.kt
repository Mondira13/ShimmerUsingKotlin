package com.example.shimmerlayoutusingkotlin.sdk

import com.example.shimmerlayoutusingkotlin.response.MainResponse
import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {

    @GET("/bins/1chppy")
    abstract fun getDashboardItems(): Call<MainResponse>
}


// https://api.myjson.com/bins/1chppy