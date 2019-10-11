package com.example.danielaguileraandroid2019

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_playground.*
import kotlin.math.log

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

        btnLoop.setOnClickListener{
            val rnds = (1..10).random()
            var i = 0
            Log.d("SUH", rnds.toString())
            Toast.makeText(this, "${rnds}", Toast.LENGTH_SHORT).show()
            while(i <= rnds){
                Log.d("SUH", i.toString())
                i++
            }
        }
    }
}
