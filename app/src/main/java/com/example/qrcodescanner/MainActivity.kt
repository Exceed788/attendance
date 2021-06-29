package com.example.qrcodescanner


import android.Manifest
import android.content.Context

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider


// for beep
import android.content.pm.PackageManager
import android.media.RingtoneManager

// for scanner
import com.budiyev.android.codescanner.*


class MainActivity : AppCompatActivity() {

    private lateinit var codescanner: CodeScanner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) ==
            PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 123)
        } else {
            startScanning()
        }

    }

    private fun startScanning() {

        val scannerView: CodeScannerView = findViewById(R.id.scanner_view)

        codescanner = CodeScanner(this, scannerView)
        codescanner.camera = CodeScanner.CAMERA_BACK
        codescanner.formats = CodeScanner.ALL_FORMATS

        codescanner.autoFocusMode = AutoFocusMode.SAFE
        codescanner.scanMode = ScanMode.SINGLE
        codescanner.isAutoFocusEnabled = true
        codescanner.isFlashEnabled = false


        val error  = "Invalid ID"
        val success = "ID confirmed"


        codescanner.decodeCallback = DecodeCallback {
            runOnUiThread {
                // get all students from server
                val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
                viewModel.getStudents()


                val toFind = it.text
                var found = false

                // compare if scanned school ID exits in server database
                viewModel.myResponseList.observe(this , {
                    for (student in it) {
                        if (toFind == student.schoolID)
                            found = true
                        break
                    }
                })
                    if (found) {
                        beep(this)
                        Toast.makeText(this , "Scan Result: $success, $toFind" , Toast.LENGTH_SHORT).show()
                        found = false
                    } else {
                        Toast.makeText(this , "Scan Result: $error" , Toast.LENGTH_SHORT).show()
                    }
            }
        }

        codescanner.errorCallback = ErrorCallback {
            runOnUiThread{
                Toast.makeText(this, "Camera initialization error: ${it.message}", Toast.LENGTH_SHORT).show()
            }
        }

        scannerView.setOnClickListener{
            codescanner.startPreview()
        }
    }

    private fun beep(context: Context) {
        try{
            val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val r = RingtoneManager.getRingtone(context, defaultSoundUri)
            r.play()
        }
        catch (e: Exception){

        }
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>,grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 123){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Camera permission granted", Toast.LENGTH_SHORT).show()
                startScanning()
            } else{
                Toast.makeText(this, "Camera permission denied", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (::codescanner.isInitialized){
            codescanner.startPreview()
        }
    }

    override fun onPause() {
        if(::codescanner.isInitialized){
            codescanner.releaseResources()

        }
        super.onPause()
    }
}