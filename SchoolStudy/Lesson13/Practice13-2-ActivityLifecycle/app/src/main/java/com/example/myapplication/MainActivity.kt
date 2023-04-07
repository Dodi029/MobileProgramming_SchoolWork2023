package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("kkang", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("kkang", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("kkang", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("kkang", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("kkang", "onDestory")
    }
}