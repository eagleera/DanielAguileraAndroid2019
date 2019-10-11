package com.example.danielaguileraandroid2019

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_imc.*
import kotlinx.android.synthetic.main.activity_shake.*

class ShakeActivity : AppCompatActivity() {

    private var mSensorManager: SensorManager? = null
    private var mSensorListener: ShakeEventListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shake)

        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager?
        mSensorListener = ShakeEventListener()

        this.mSensorListener!!.setOnShakeListener {
            val rnd = (1..3).random()
            Log.d("hola", rnd.toString());
            when(rnd){
                1 -> Picasso.get().load(R.drawable.rock).into(imgGame)
                2 -> Picasso.get().load(R.drawable.scissors).into(imgGame)
                3 -> Picasso.get().load(R.drawable.paper).into(imgGame)
            }
            Toast.makeText(this, "Shake!!!!", Toast.LENGTH_LONG).show()
        }
    }

    override fun onResume(){
        super.onResume()
        mSensorManager!!.registerListener(
            mSensorListener,
            mSensorManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_UI
        )
    }

    override fun onPause(){
        mSensorManager!!.unregisterListener(mSensorListener)
        super.onPause()
    }
}