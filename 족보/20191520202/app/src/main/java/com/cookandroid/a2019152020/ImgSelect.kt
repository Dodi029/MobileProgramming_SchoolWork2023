package com.cookandroid.a2019152020

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.imgselect.*

class ImgSelect : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.imgselect)
        title = "이미지 선택"
        radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            var intent = Intent(applicationContext, MainActivity::class.java)
            var animal = when(radioGroup.checkedRadioButtonId) {
                R.id.rdoCat -> imgPet.setImageResource(R.drawable.cat)
                R.id.rdoDog -> imgPet.setImageResource(R.drawable.dog)
                R.id.rdoRabbit -> imgPet.setImageResource(R.drawable.rabbit)
            }
        }
    }
}