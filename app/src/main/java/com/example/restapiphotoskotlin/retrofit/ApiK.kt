package com.example.restapiphotoskotlin.retrofit

import com.example.restapiphotoskotlin.pojo.Jphoto
import retrofit2.Call
import retrofit2.http.GET

interface ApiK {

    @GET("/photos")
    fun getPhotos(): Call<ArrayList<Jphoto>>


}