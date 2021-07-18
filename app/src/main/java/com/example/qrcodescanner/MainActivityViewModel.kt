package com.example.qrcodescanner

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qrcodescanner.network.Event
import com.example.qrcodescanner.network.Post
import com.example.qrcodescanner.network.Student
import com.example.qrcodescanner.network.SimpleNetwork
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    val myResponseStudents : MutableLiveData<List<Student>> = MutableLiveData()
    val myResponseEvents : MutableLiveData<List<Event>> = MutableLiveData()
    val myResponsePosts : MutableLiveData<List<Post>> = MutableLiveData()

    fun getStudents() {
        viewModelScope.launch {
            myResponseStudents.value = SimpleNetwork.retrofitStudent.getStudents()
        }
    }

    fun getEvents() {
        viewModelScope.launch {
            myResponseEvents.value = SimpleNetwork.retrofitEvent.getEvents()
        }
    }

    fun getPosts() {
        viewModelScope.launch {
            myResponsePosts.value = SimpleNetwork.retrofitPost.getPosts()
        }
    }


}