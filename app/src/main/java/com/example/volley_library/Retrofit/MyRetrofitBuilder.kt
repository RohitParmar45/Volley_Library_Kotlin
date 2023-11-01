package com.example.volley_library.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object MyRetrofitBuilder {

    val api = "https://api.github.com/"

    fun getInstance(): Retrofit{
        return Retrofit.Builder().baseUrl(api)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}