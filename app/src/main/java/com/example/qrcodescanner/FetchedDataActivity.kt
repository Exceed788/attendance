package com.example.qrcodescanner


import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider


class FetchedDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fetched_data)
//
//        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
//
//        viewModel.getStudents()
//        viewModel.myResponseStudents.observe(this , {
//            for (student in it) {
//                Log.d(TAG, student.id.toString())
//                Log.d(TAG , student.schoolID)
//                Log.d(TAG , student.firstName)
//                Log.d(TAG , student.lastName)
//            }
//        })
//
//        viewModel.getEvents()
//        viewModel.myResponseEvents.observe(this , {
//            for (event in it) {
//                Log.d(TAG, event.id.toString())
//                Log.d(TAG , event.name)
//                Log.d(TAG , event.time)
//                Log.d(TAG , event.status.toString())
//            }
//        })
    }
}