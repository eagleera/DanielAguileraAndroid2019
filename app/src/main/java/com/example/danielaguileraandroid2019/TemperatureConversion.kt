package com.example.danielaguileraandroid2019

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_temperature_conversion.*

class TemperatureConversion : AppCompatActivity() {
    var celsius : Double = 0.0;
    var farenheit : Double = 0.0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temperature_conversion)

        btnConvertFarenheit.setOnClickListener {
            farenheit = (editCelsius.text.toString().toDouble() * 1.8) + 32
            txtResult.text = "$farenheit Farenheit"
            Toast.makeText(this, "$farenheit Farenheit", Toast.LENGTH_LONG).show();
            changeBgContainer(farenheit, "Farenheit")
        }
        btnConvertCelsius.setOnClickListener{
            celsius = ((editFarenheit.text.toString().toDouble() - 32.0) * (5.0/9.0))
            txtResult2.text = "$celsius Celsius"
            Toast.makeText(this, "$celsius Celsius", Toast.LENGTH_LONG).show();
            changeBgContainer(celsius, "Celsius")
        }
    }

    fun changeBgContainer(temp: Double, type: String){
        if(type.equals("Farenheit")){
            if(temp < 50){
                containerCelsius.setBackgroundColor(ContextCompat.getColor(this, R.color.colorCold))
            }else{
                containerCelsius.setBackgroundColor(ContextCompat.getColor(this, R.color.colorHot))
            }
        }
        if(type.equals("Celsius")){
            if(temp < 5){
                containerFarenheit.setBackgroundColor(ContextCompat.getColor(this, R.color.colorCold))
            }else{
                containerFarenheit.setBackgroundColor(ContextCompat.getColor(this, R.color.colorHot))
            }
        }
    }
}
