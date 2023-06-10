package com.example.sypark

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SecondActivity : Activity(){
    lateinit var num1 : EditText; lateinit var num2 : EditText
    lateinit var ret_btn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculate)
        num1 = findViewById(R.id.num1)
        num2 = findViewById(R.id.num2)
        ret_btn = findViewById(R.id.ret_btn)
    }
}