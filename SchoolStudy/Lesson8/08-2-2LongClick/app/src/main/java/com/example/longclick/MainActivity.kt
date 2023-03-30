package com.example.longclick

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.longclick.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            Log.d("kkang", "클릭 이벤트")
        }

        binding.button.setOnLongClickListener{
            Log.d("kkang","롱클릭 이벤트")
            true
        }
    }
}