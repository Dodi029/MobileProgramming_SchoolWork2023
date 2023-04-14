package com.example.exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn.setOnClickListener {
            val data = binding.btn.text.toString()
            binding.te.text = data
        }
    }
}