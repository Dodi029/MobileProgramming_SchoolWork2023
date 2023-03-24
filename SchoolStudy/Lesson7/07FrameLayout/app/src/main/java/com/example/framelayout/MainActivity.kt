package com.example.framelayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.framelayout.databinding.ActivityMainBinding
import com.example.framelayout.databinding.ActivityMainBinding.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        val binding = inflate(layoutInflater)
        setContentView(binding.root)

        binding.myButton.setOnClickListener {
            binding.myButton.visibility = View.INVISIBLE
            binding.myImageView.visibility = View.VISIBLE
        }
        binding.myImageView.setOnClickListener {
            binding.myButton.visibility = View.VISIBLE
            binding.myImageView.visibility = View.INVISIBLE
        }
    }
}