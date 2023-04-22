package com.example.a2019150045

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.a2019150045.databinding.ActivityCalBinding

class CalActivity : AppCompatActivity() {
    lateinit var binding: ActivityCalBinding
    var result=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title ="계산기"

        binding.btnR.setOnClickListener {
            intent.putExtra("result",result +" =")
            setResult(RESULT_OK,intent)
            finish()
        }
    }

    fun clickBtn(v: View){
        when(v.id){
            binding.btn0.id -> add("0")
            binding.btn1.id -> add("1")
            binding.btn2.id -> add("2")
            binding.btn3.id -> add("3")
            binding.btn4.id -> add("4")
            binding.btn5.id -> add("5")
            binding.btn6.id -> add("6")
            binding.btn7.id -> add("7")
            binding.btn8.id -> add("8")
            binding.btn9.id -> add("9")
            binding.btnP.id -> add(" + ")
            binding.btnM.id -> add(" - ")
            binding.btnX.id -> add(" x ")
            binding.btnD.id -> add(" / ")
        }
    }

    fun add(s: String){
        result= result+s
        binding.reult.text = result
    }
}