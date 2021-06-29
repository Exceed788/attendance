package com.example.qrcodescanner

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qrcodescanner.network.Student
import com.example.qrcodescanner.network.StudentNetwork
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    val myResponseList: MutableLiveData<List<Student>> = MutableLiveData()


    fun getStudents() {
        viewModelScope.launch {
            myResponseList.value = StudentNetwork.retrofit.getStudents()
        }
    }

}