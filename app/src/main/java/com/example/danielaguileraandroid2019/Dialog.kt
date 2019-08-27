package com.example.danielaguileraandroid2019

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import kotlinx.android.synthetic.main.activity_dialog.*
import kotlinx.android.synthetic.main.dialog_login.view.*

class Dialog : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        btnMostrarDialogo.setOnClickListener {
            val DialogView = layoutInflater.inflate(R.layout.dialog_login, null)
            val mBuilder = AlertDialog.Builder(this)
                            .setView(DialogView).setTitle("Login dialog").show()
            DialogView.btnLogin.setOnClickListener{
                val name = DialogView.txtName.text.toString()
                val email = DialogView.txtEmail.text.toString()
                val password = DialogView.txtPassword.text.toString()
                txtInfo.setText("Nombre: ${name}\n Email: ${email} \n Password: ${password}")
                mBuilder.dismiss()
            }
            DialogView.btnCancel.setOnClickListener {
                mBuilder.dismiss()
            }
        }
    }
}
