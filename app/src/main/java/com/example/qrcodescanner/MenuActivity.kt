 package com.example.qrcodescanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button

 class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val scanCode: Button = this.findViewById(R.id.scanCode)

        scanCode.setOnClickListener{
            val scannerPage = Intent(this, MainActivity::class.java)
            startActivity(scannerPage)
        }

        val generateCode : Button = this.findViewById(R.id.generateCode)

        generateCode.setOnClickListener{
            val generatorPage = Intent(this, GenerateCodeActivity::class.java)
            startActivity(generatorPage)
        }


    }
}