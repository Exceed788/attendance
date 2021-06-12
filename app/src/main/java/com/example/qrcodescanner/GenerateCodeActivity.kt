package com.example.qrcodescanner


import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.journeyapps.barcodescanner.BarcodeEncoder


class GenerateCodeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generatecode)
        
        val generateQR : Button = this.findViewById(R.id.btn_generate)
        val txtContent = this.findViewById<EditText>(R.id.txt_content)

        generateQR.setOnClickListener{
            if(txtContent.text.toString() != ""){
                generateQrCode()
            }else{
                val toast = Toast.makeText(this, "Empty Field!", Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
            }
    
        }

    }

    private fun generateQrCode(){

        val txtContent = this.findViewById<EditText>(R.id.txt_content)
        val imgQR : ImageView = this.findViewById(R.id.img_qr)
        
        val multiFormatWriter = MultiFormatWriter()

        try {
            val bitMatrix = multiFormatWriter.encode(
                txtContent.text.toString() ,
                BarcodeFormat.QR_CODE , 300 , 300
            )
            val barcodeEncoder = BarcodeEncoder()
            val bitmap = barcodeEncoder.createBitmap(bitMatrix)
            imgQR.setImageBitmap(bitmap)

        } catch (e : WriterException) {
            e.printStackTrace()
        }
    }
}


