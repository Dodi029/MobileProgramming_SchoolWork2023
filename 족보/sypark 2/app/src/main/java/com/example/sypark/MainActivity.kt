package com.example.sypark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var cal_btn : Button; lateinit var rate_btn : Button; lateinit var quit_btn : Button
    lateinit var edit : EditText;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cal_btn = findViewById(R.id.cal_btn)
        rate_btn = findViewById((R.id.rate_btn))
        quit_btn = findViewById(R.id.quit_btn)
        edit = findViewById(R.id.edit1)

        cal_btn.setOnClickListener{
            
        }

        quit_btn.setOnClickListener{
            finish()
        }

    }
}