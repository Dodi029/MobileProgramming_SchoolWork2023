package com.example.sypark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var edit1 : EditText; lateinit var edit2 : EditText
    lateinit var operator : TextView; lateinit var textResult : TextView
    lateinit var btnAdd : Button; lateinit var btnSub : Button
    lateinit var btnMul : Button; lateinit var btnDiv : Button
    lateinit var num1 : String; lateinit var num2 : String
    var result : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "ch4_test"

        edit1 = findViewById(R.id.num1)
        edit2 = findViewById(R.id.num2)
        operator = findViewById(R.id.operator)
        textResult = findViewById(R.id.result)
        btnAdd = findViewById(R.id.btnAdd)
        btnSub = findViewById(R.id.btnSub)
        btnMul = findViewById(R.id.btnMul)
        btnDiv = findViewById(R.id.btnDiv)

        btnAdd.setOnTouchListener{ view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            operator.text = " +"
            result = num1.toInt() + num2.toInt()
            textResult.text = "= " + result.toString()
            false
        }
        btnSub.setOnTouchListener{ view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            operator.text = " -"
            result = num1.toInt() - num2.toInt()
            textResult.text = "= " + result.toString()
            false
        }
        btnMul.setOnTouchListener{ view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            operator.text = " *"
            result = num1.toInt() * num2.toInt()
            textResult.text = "= " + result.toString()
            false
        }
        btnDiv.setOnTouchListener{ view, motionEvent ->
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            operator.text = " /"
            result = num1.toInt() / num2.toInt()
            textResult.text = "= " + result.toString()
            false
        }
    }
}