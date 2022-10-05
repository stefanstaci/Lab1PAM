package com.example.myapplication

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button1)
        button.setOnClickListener {view->
            printAge(view)
        }
    }

    private fun printAge(view:View){
        var myCalendar = Calendar.getInstance()
        var year=myCalendar.get(Calendar.YEAR)
        var month=myCalendar.get(Calendar.MONTH)
        var day=myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this
            ,DatePickerDialog.OnDateSetListener{
                    view,year,month,day->

                val selectedDate="$day/${month+1}/$year"

                var textView1=findViewById<TextView>(R.id.textView1)
                textView1.text= selectedDate



                var dob=Calendar.getInstance()
                dob.set(year,month,day)

                var age= myCalendar.get(Calendar.YEAR) - dob.get(Calendar.YEAR)
                if (myCalendar.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR))
                {
                    age--
                }

                var textView2 = findViewById<TextView>(R.id.textView2)
                textView2.text="Tu ai $age ani"

            }
            ,year
            ,month
            ,day).show()
    }
}