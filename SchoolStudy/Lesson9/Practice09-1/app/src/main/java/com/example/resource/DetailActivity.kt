package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.resource.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Detail Activity"

        binding.result.text = intent.getStringExtra("result") + ":" +
                intent.getIntExtra("data", 0)

        binding.button.setOnClickListener{finish()}
    }
}