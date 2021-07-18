package com.example.qrcodescanner


import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.qrcodescanner.adapter.CustomSpinnerAdapter
import com.example.qrcodescanner.network.Post
import com.google.gson.Gson


class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)


        val scanCode : Button = this.findViewById(R.id.scanCode)
//        val getList : Button = this.findViewById(R.id.getData)
//         scanCode.setOnClickListener {
//             val fetchedDataPage = Intent(this , FetchedDataActivity::class.java)
//             startActivity(fetchedDataPage)
//         }


        scanCode.setOnClickListener {
            val scannerPage = Intent(this , MainActivity::class.java)
            startActivity(scannerPage)


            val modelList : List<Post> = readFromAsset()
            val customSpinner : Spinner = this.findViewById(R.id.customSpinner)

            val customDropDownAdapter = CustomSpinnerAdapter(this , modelList)
            customSpinner.adapter = customDropDownAdapter
        }
    }

    private fun readFromAsset() : List<Post> {
        val fileName = "android_version.json"

        val bufferReader = application.assets.open(fileName).bufferedReader()

        val jsonString = bufferReader.use {
            it.readText()
        }
        val gson = Gson()
        return gson.fromJson(jsonString , Array<Post>::class.java).toList()
        }
}














