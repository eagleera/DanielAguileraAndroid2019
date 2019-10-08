package com.example.danielaguileraandroid2019

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shared_preferences.*

class SharedPreferences : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)
        val sharedPreferences = getSharedPreferences("MINIBD", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        var name = sharedPreferences.getString("name", "Sin asignar")
        var lastName = sharedPreferences.getString("lastName", "")
        var email = sharedPreferences.getString("email", "")
        var phone = sharedPreferences.getString("phone", "")
        this.editName.setText(name)
        this.editLastName.setText(lastName)
        this.editEmail.setText(email)
        this.editPhone.setText(phone)

        btnGuardar.setOnClickListener {
            editor.putString("name", editName.text.toString())
            editor.putString("lastName", editLastName.text.toString())
            editor.putString("email", editEmail.text.toString())
            editor.putString("phone", editPhone.text.toString())
            editor.commit()
            Toast.makeText(this, "Se armo", Toast.LENGTH_LONG).show()
        }
        btnBorrar.setOnClickListener {
            editor.clear()
            editor.commit()
            Toast.makeText(this, "Se borro todo", Toast.LENGTH_LONG).show()
        }
    }
}
