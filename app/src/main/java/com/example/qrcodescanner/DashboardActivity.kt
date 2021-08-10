package com.example.qrcodescanner


import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider


class DashboardActivity : AppCompatActivity() {

    private var listOfStudents = arrayListOf<String>()
    private var listOfTitles = arrayListOf<String>()
//    private var dict = emptyList<Unit>()

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val scanCode : Button = this.findViewById(R.id.scanCode)
        scanCode.setOnClickListener {
            val scannerPage = Intent(this , MainActivity::class.java)
//            scannerPage.putExtra("message_key", selectedEvent)
            startActivity(scannerPage)
        }

        val getList : Button = this.findViewById(R.id.getData)
        getList.setOnClickListener {
            val fetchedDataPage = Intent(this , FetchedDataActivity::class.java)
            startActivity(fetchedDataPage)
        }

        getPostTitles()
        setupSpinner()



        val sampleButton : Button = this.findViewById(R.id.sampleButton)
        sampleButton.setOnClickListener {
            getStudentIDs()
            Toast.makeText(this , "List of students: $listOfStudents" , Toast.LENGTH_SHORT).show()
        }

    }


    private fun getStudentIDs() {
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getStudents()
        viewModel.myResponseStudents.observe(this, {
            for(student in it) {
                listOfStudents.add(student.schoolID)
            }
        })
    }

    private fun getPostTitles() {
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getPosts()
        viewModel.myResponsePosts.observe(this, {
            for(post in it) {
                listOfTitles.add(post.title)
            }
        })
    }

    private fun setupSpinner(){
        val titleSpinner : Spinner = this.findViewById(R.id.titleSpinner)
        val aa = ArrayAdapter(this, R.layout.spinner_item , listOfTitles)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        titleSpinner.adapter = aa
        aa.notifyDataSetChanged()
    }

}


