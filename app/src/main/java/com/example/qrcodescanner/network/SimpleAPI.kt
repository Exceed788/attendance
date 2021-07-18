package com.example.qrcodescanner.network


import retrofit2.http.GET

interface StudentAPI {

    @GET("students")
    suspend fun getStudents() : List<Student>
}

interface EventAPI{

    @GET("events")
    suspend fun getEvents() : List<Event>

}
interface PostAPI{

    @GET("posts")
    suspend fun getPosts() : List<Post>

}




