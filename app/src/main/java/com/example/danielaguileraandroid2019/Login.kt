package com.example.danielaguileraandroid2019

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.biometric.BiometricPrompt
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.activity_login.*
import java.util.concurrent.Executors

class Login : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val executor = Executors.newSingleThreadExecutor()
        val biometricPrompt = BiometricPrompt(this, executor, object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                if (errorCode == BiometricPrompt.ERROR_NEGATIVE_BUTTON) {
                    // user clicked negative button
                } else {
                }
            }
            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                Log.d("Chris","Success")
                val intent = Intent(this@Login,MainActivity::class.java)
                startActivity(intent)
            }
            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                Log.d("Chris","Called when a biometric is valid but not recognized.")
            }
        })
        val promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Set the title to display.")
            .setSubtitle("Set the subtitle to display.")
            .setDescription("Set the description to display")
            .setNegativeButtonText("Negative Button")
            .build()

        btnLogin1.setOnClickListener {
            biometricPrompt.authenticate(promptInfo)
        }
    }
}
