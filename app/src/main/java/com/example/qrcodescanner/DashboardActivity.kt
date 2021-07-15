 package com.example.qrcodescanner


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity



 class DashboardActivity : AppCompatActivity() {

     override fun onCreate(savedInstanceState : Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_dashboard)

         val scanCode : Button = this.findViewById(R.id.scanCode)
         val getFetchedData : Button = this.findViewById(R.id.getFetchedData)


         scanCode.setOnClickListener {
             val scannerPage = Intent(this , MainActivity::class.java)
             startActivity(scannerPage)
         }

         getFetchedData.setOnClickListener{
             val fetchedDataPage = Intent(this , FetchedDataActivity::class.java)
             startActivity(fetchedDataPage)
         }
     }
 }
