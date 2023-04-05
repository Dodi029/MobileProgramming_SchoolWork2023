package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Detail Activity(13-1)"

        binding.finishBtn.setOnClickListener{
            val intent = Intent()
            intent.putExtra("resultData", binding.textEdit.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}