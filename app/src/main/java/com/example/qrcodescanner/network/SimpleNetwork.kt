package com.example.qrcodescanner.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SimpleNetwork {

    val retrofitStudent : StudentAPI by lazy {
        Retrofit.Builder()
            .baseUrl("http://192.168.1.8:8000/generic/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StudentAPI::class.java)
    }

    val retrofitEvent : EventAPI by lazy {
        Retrofit.Builder()
            .baseUrl("http://192.168.1.8:8000/generic/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EventAPI::class.java)
    }
    

    
}