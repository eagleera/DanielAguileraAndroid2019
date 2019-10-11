package com.example.danielaguileraandroid2019

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.danielaguileraandroid2019.ShakeEventListener as ShakeEvtListener

class HelloWorld : AppCompatActivity() {

    private var mSensorManager: SensorManager? = null
    private var mSensorListener: ShakeEvtListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello_world)
        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager?
        mSensorListener = ShakeEvtListener()

        this.mSensorListener!!.setOnShakeListener {
            Log.d("SUH", "SIMON MIJO2")
            Toast.makeText(this, "Shake!!!!", Toast.LENGTH_LONG).show()
        }
        Log.d("SUH", "SIMON MIJO")
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
