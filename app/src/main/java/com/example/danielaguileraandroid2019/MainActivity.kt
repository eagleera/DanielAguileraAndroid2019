package com.example.danielaguileraandroid2019

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnHelloWorld.setOnClickListener {
            val intent = Intent(this, HelloWorld::class.java)
            startActivity(intent)
        }

        btnTimeFighter.setOnClickListener {
            val intent = Intent(this, TimeFighter::class.java)
            startActivity(intent)
        }

        btnTempConversion.setOnClickListener {
            val intent = Intent(this, TemperatureConversion::class.java)
            startActivity(intent)
        }
        btnDialog.setOnClickListener {
            val intent = Intent(this, Dialog::class.java)
            startActivity(intent)
        }
        btnDialogMgmt.setOnClickListener {
            val intent = Intent(this, DialogManagement::class.java)
            startActivity(intent)
        }
        btnPlayground.setOnClickListener {
            val intent = Intent(this, Playground::class.java)
            startActivity(intent)
        }
        btnImc.setOnClickListener{
            val intent = Intent(this, Imc::class.java)
            startActivity(intent)
        }
    }
}