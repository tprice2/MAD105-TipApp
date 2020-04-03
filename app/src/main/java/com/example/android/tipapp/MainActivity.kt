package com.example.android.tipapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.view.*
import java.text.DecimalFormat
import android.support.*
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var meal_cost: Double = 0.00
    var tip: Double = 0.00
    var tipChoice = ""
    var tipMultiplyer: Double = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    val total_cost: EditText = findViewById(R.id.txtMealTotal)
    val group: Spinner = findViewById(R.id.spnGroup)
    val result: TextView = findViewById(R.id.txtResult)
    val calculate: Button = findViewById(R.id.btnCalculate)

    calculate.setOnClickListener{
        meal_cost = total_cost.text.toString().toDouble()
        val currency = DecimalFormat("$###,###.00")
        tipChoice = group.selectedItem.toString()
        when(tipChoice){
            "5%" -> tipMultiplyer = .05
            "10%" -> tipMultiplyer = .10
            "15%" -> tipMultiplyer = .15
            "20%" -> tipMultiplyer = .20
            "25%" -> tipMultiplyer = .25
        }


        tip = meal_cost * tipMultiplyer
        val tip_formatted = currency.format(tip)
        result.text = tip_formatted

    }
    }
}
