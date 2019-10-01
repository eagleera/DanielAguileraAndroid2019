package com.example.danielaguileraandroid2019;

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.util.Log
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_imc.*
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import org.json.JSONObject

class Imc: AppCompatActivity() {
    var qrScanIntegrator: IntentIntegrator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)
        btnQr.setOnClickListener {
            performAction()
        }
        btnCalcImc.setOnClickListener {
            calculateImc()
        }
        qrScanIntegrator = IntentIntegrator(this)
        qrScanIntegrator?.setOrientationLocked(false)

    }

    private fun calculateImc() {
        if(txtWeight.text.toString().trim().length == 0 || txtHeight.text.toString().trim().length == 0){
            return Toast.makeText(this, getString(R.string.fill_all_fields), Toast.LENGTH_LONG).show()
        }
        val imc = txtWeight.text.toString().toDouble() / (txtHeight.text.toString().toDouble() * txtHeight.text.toString().toDouble())
        if(imc >= 19 && imc <= 24.9){
            return Toast.makeText(this, getString(R.string.patient_good), Toast.LENGTH_LONG).show()
        }else{
            return Toast.makeText(this, getString(R.string.patient_bad), Toast.LENGTH_LONG).show()
        }
    }

    private fun performAction() {
        qrScanIntegrator?.initiateScan()
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            // If QRCode has no data.
            if (result.contents == null) {
                Toast.makeText(this, getString(R.string.btn_cancel), Toast.LENGTH_LONG).show()
            } else {
                // If QRCode contains data.
                try {
                    // Converting the data to json format
                    val obj = JSONObject(result.contents)

                    // Show values in UI.
                    txtName.setText(obj.getString("name"))
                    txtLastName.setText(obj.getString("lastname"))
                    txtHeight.setText(obj.getString("height"))
                    txtWeight.setText(obj.getString("weight"))
                    Log.d("url", obj.getString("url"))
                    Picasso.get().load(obj.getString("url")).into(imgQr);
                } catch (e: JSONException) {
                    e.printStackTrace()

                    // Data not in the expected format. So, whole object as toast message.
                    Toast.makeText(this, result.contents, Toast.LENGTH_LONG).show()
                }

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
