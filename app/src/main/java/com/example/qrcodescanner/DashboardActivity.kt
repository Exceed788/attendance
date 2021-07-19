package com.example.qrcodescanner


import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider


class DashboardActivity : AppCompatActivity() {

    private val listOfTitles = arrayListOf<String>()

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)



        val scanCode : Button = this.findViewById(R.id.scanCode)
        scanCode.setOnClickListener {
            val scannerPage = Intent(this , MainActivity::class.java)
            startActivity(scannerPage)
        }

        val getList : Button = this.findViewById(R.id.getData)
         getList.setOnClickListener {
             val fetchedDataPage = Intent(this , FetchedDataActivity::class.java)
             startActivity(fetchedDataPage)
         }
        val titleSpinner : Spinner = this.findViewById(R.id.titleSpinner)

        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getPosts()
        viewModel.myResponsePosts.observe(this, {
            for (post in it )
                 listOfTitles.add(post.id, post.title)
        })

        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listOfTitles)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        titleSpinner.adapter = aa
        aa.notifyDataSetChanged()


    }
}













