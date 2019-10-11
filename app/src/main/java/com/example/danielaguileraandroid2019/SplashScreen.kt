package com.example.danielaguileraandroid2019

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler
import android.view.Window
import android.view.WindowManager


class SplashScreen : Activity() {
    private val SPLASH_TIME_OUT = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash_screen)
        Handler().postDelayed(
            Runnable /*
         * Showing splash screen with a timer. This will be useful when you
         * want to show case your app logo / company
         */

            {
                // This method will be executed once the timer is over
                // Start your app main activity
                val i = Intent(this@SplashScreen, Login::class.java)
                startActivity(i)

                // close this activity
                finish()
            }, SPLASH_TIME_OUT.toLong()
        )
    }
}
