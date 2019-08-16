package com.example.danielaguileraandroid2019

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class HelloWorld : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello_world)
        Log.d("SUH", "SIMON MIJO")
    }
}
