package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import com.example.myapplication.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Main Activity"

        val requestLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultCintracts.StartActivityForResult()){
            val resultData = it.data?.getStringExtra("result")
            binding.mainResultView.text = "result: $resultData"
        }

        binding.newActivity.setOnClickListener{
            val intent = Intent(this, DetailActivity::class.java)
            requestLauncher.launch(intent)
            startActivity(Intent("ACTION_HELLO"))
        }
    }
}