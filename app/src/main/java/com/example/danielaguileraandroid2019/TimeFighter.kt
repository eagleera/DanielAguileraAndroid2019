package com.example.danielaguileraandroid2019

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_time_fighter.*

class TimeFighter : AppCompatActivity() {
    var score : Int = 0
    lateinit var countDownTimer : CountDownTimer
    val initialCountDown : Long = 10000
    val countDownInterval : Long = 500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_fighter)
        txtScore.text = ""
        txtTimeLeft.text = ""
        initTimer()
        btnTapMe.setOnClickListener {
            if(score === 0){
                countDownTimer.start()
            }
            incrementStore()
        }
    }

    private fun incrementStore(){
        score++
        val newScore: String = getString(R.string.score, score.toString())
        txtScore.text = newScore
    }

    private fun initTimer(){
        countDownTimer = object: CountDownTimer(initialCountDown, countDownInterval){
            override fun onTick(millisUntilFinished: Long) {
                val timeLeft : Long = millisUntilFinished / 1000
                Log.d("SUH", "eltimerr")
                txtTimeLeft.text = getString(R.string.time_left, timeLeft.toString())
            }
            override fun onFinish() {
                endGame()
            }
        }
    }

    private fun endGame(){
        Toast.makeText(this, getString(R.string.end_game, score.toString()), Toast.LENGTH_LONG)
            .show()
        btnTapMe.isEnabled = false
    }
}
