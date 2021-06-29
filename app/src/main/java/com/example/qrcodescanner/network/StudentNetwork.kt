package com.example.qrcodescanner.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object StudentNetwork {

    val retrofit : StudentAPI by lazy {
        Retrofit.Builder()
            .baseUrl("http://127.0.0.1:8000/generic/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StudentAPI::class.java)
    }
}