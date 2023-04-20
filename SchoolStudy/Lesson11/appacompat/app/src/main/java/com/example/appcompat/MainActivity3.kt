package com.example.appcompat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        title = "Three Activity"

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}