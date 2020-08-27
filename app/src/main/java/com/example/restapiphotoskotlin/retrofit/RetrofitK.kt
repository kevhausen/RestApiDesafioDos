package com.example.restapiphotoskotlin.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitK {
    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com"
        fun retrofitInstance(): ApiK {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiK::class.java)
        }
    }
}