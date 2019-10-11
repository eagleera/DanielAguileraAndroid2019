package com.example.danielaguileraandroid2019

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_time_fighter.*

class TimeFighter : AppCompatActivity() {
    var score : Int = 0
    lateinit var countDownTimer : CountDownTimer
    val initialCountDown : Long = 10000
    val countDownInterval : Long = 500
    private var startMusic : MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce)
        val shakeAnimation = AnimationUtils.loadAnimation(this, R.anim.shake)
        setContentView(R.layout.activity_time_fighter)
        txtScore.text = ""
        txtTimeLeft.text = ""
        initTimer()
        btnTapMe.setOnClickListener {
            it.startAnimation(bounceAnimation)
            txtScore.startAnimation(shakeAnimation)
            if(score === 0){
                countDownTimer.start()
                startMusic = MediaPlayer.create(this, R.raw.game)
                startMusic?.start()
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
                txtTimeLeft.text = getString(R.string.time_left, timeLeft.toString())
            }
            override fun onFinish() {
                endGame()
            }
        }
    }

    private fun endGame(){
        startMusic?.stop()
        startMusic?.release()
        startMusic = MediaPlayer.create(this, R.raw.endgame)
        startMusic?.start()
        Toast.makeText(this, getString(R.string.end_game, score.toString()), Toast.LENGTH_LONG)
            .show()
        btnTapMe.isEnabled = false
    }
}
