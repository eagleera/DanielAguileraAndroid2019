package com.example.danielaguileraandroid2019

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_dialog_management.*
import kotlinx.android.synthetic.main.dialog_mgmt_close.view.*
import kotlin.system.exitProcess

class DialogManagement : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_management)

        btnShowImg.setOnClickListener {
            val DialogView = layoutInflater.inflate(R.layout.dialog_mgmt_image, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(DialogView).setTitle("Image Dialog").show()
            DialogView.btnCloseDialog.setOnClickListener {
                mBuilder.dismiss()
            }
        }
        btnCloseApp.setOnClickListener {
            val DialogView = layoutInflater.inflate(R.layout.dialog_mgmt_close, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(DialogView).setTitle("Image Dialog").show()
            DialogView.btnCloseDialog.setOnClickListener {
                moveTaskToBack(true);
                exitProcess(-1)
            }
            DialogView.btnCancel.setOnClickListener {
                mBuilder.dismiss()
            }
        }
    }
}
