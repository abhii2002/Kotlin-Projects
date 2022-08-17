package com.example.electricitybillcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.ArithmeticException


var tvField : TextView? = null

var power : EditText? = null
var hours : EditText? = null
var days : EditText? = null
var cost : EditText? = null

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       tvField = findViewById(R.id.tvField)
        power = findViewById(R.id.power)
        hours = findViewById(R.id.hours)
        days = findViewById(R.id.days)
        cost = findViewById(R.id.cost)
    }


   fun onCalculate(view : View) {
       val textviewField = tvField

       val powerStr: String = power?.text.toString()
       val hoursStr: String = hours?.text.toString()
       val daysStr: String = days?.text.toString()
       val costStr: String = cost?.text.toString()

       try {

           if(powerStr.isNotEmpty() && hoursStr.isNotEmpty() && daysStr.isNotEmpty() && costStr.isNotEmpty()) {

               val total = (((powerStr.toDouble() * hoursStr.toDouble() * daysStr.toDouble()) / 1000) * costStr.toDouble()).toString()

               textviewField?.text = ("₹ $total")
           }else{

               Toast.makeText(this, "Please fill All entries!",Toast.LENGTH_SHORT).show()

           }
       }catch(e: ArithmeticException) {

           e.printStackTrace()
       }

   }

    fun onClear(view : View){
           tvField?.text = ""
        power?.text = null
        hours?.text = null
        days?.text = null
        cost?.text = null

    }

}