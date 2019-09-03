package com.example.danielaguileraandroid2019

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_playground.*

class Playground : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playground)
        val date= Pair(5, 22)
        val (day, month) = date
        val dayOfMonth = Triple(29, 8, 2019)
        btnToast.setOnClickListener {
            Toast.makeText(this, "${date}", Toast.LENGTH_LONG).show()
            Handler().postDelayed({
                Toast.makeText(this, "month = ${month} day = ${day} ", Toast.LENGTH_SHORT).show()
            }, 2000)
            Handler().postDelayed({
                Toast.makeText(this, "${dayOfMonth}", Toast.LENGTH_SHORT).show()
            }, 4000)
        }
    }
}
