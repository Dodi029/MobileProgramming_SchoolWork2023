package com.doyoung.lesson06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedinstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 화면 출력 XML 명시
        val name = TextView(this).apply{}
        val image = ImageView(this).apply {}
        val address = TextView(this).apply {}
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER

            addView(name, WRAP_CONTENT, WRAP_CONTEXT)
        }

        setContentView(layout)
    }
}