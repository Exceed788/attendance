package com.example.qrcodescanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*


class AddSubjectActivity : AppCompatActivity() {

// val yearlevelSpinner : Spinner = this.findViewById(R.id.yearlevels_spinner)

//    private val insertSubject: Button = this.findViewById(R.id.insertSubject)
//    private val subjectName: EditText = this.findViewById(R.id.et_subjectName)
//    private val subjectCode: EditText = this.findViewById(R.id.et_subjectCode)

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addsubject)

        val courseSpinner : Spinner = this.findViewById(R.id.courses_spinner)
        ArrayAdapter.createFromResource(
            this, R.array.courses, android.R.layout.simple_spinner_item)
            .also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                courseSpinner.adapter = adapter
            }
        courseSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent : AdapterView<*>? , view : View? , position : Int , id : Long) {
                parent?.getItemAtPosition(position)
            }

            override fun onNothingSelected(parent : AdapterView<*>?) {

            }

        }

    }

}

