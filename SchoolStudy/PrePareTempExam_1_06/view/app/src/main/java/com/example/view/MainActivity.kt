package com.example.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val visibleBtn = findViewById<Button>(R.id.visibilityBtn)
        val invisibleBtn:Button = findViewById(R.id.invisibilityBtn)
        val targetView = findViewById<TextView>(R.id.targetView)

        visibleBtn.setOnClickListener{
            targetView.visibility = View.VISIBLE
        }
        invisibleBtn.setOnClickListener{
            targetView.visibility = View.INVISIBLE
        }
    }
}