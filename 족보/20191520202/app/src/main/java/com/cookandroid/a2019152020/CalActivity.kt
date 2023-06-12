package com.cookandroid.a2019152020

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.cal.*

class CalActivity : AppCompatActivity() {
    var num1 = ""
    var num2 = ""
    var result = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cal)
        title = "계산기"

        val num = arrayOf(btn0, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9)
        val Yeonsan = arrayOf(btnAdd, btnSub, btnMul, btnDiv)

        btnAdd.setOnClickListener {

        }

        btnReturn.setOnClickListener { finish() }


    }
}