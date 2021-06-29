 package com.example.qrcodescanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button

 class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val scanCode: Button = this.findViewById(R.id.scanCode)


        scanCode.setOnClickListener{
            val scannerPage = Intent(this, MainActivity::class.java)
            startActivity(scannerPage)
        }



    }
}