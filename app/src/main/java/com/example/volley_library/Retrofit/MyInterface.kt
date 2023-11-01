package com.example.volley_library.Retrofit

import com.example.volley_library.dao.User
import com.example.volley_library.dao.UserItem
import retrofit2.http.GET

interface MyInterface {

    @GET("/users")

    suspend fun getUser():retrofit2.Response<User>
}