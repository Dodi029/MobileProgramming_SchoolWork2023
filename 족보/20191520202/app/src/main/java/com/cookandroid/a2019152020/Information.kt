package com.cookandroid.a2019152020

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Information : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.information)
        title = "개인정보 입력"
    }
}