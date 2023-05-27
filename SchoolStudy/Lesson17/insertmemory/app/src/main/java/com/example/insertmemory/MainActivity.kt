package com.example.insertmemory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.insertmemory.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.writeBtn.setOnClickListener {
            val file = File(filesDir, "test.txt")
            val writeStream: OutputStreamWriter = file.writer()
            writeStream.write("hello world")
            writeStream.flush()
        }
        binding.readBtn.setOnClickListener {
            val file = File(filesDir, "test.txt")
            val readStream: BufferedReader = file.reader().buffered()
            var resultString = ""
            readStream.forEachLine {
                resultString += it
            }
            binding.result.text = resultString
        }
        binding.outputBtn.setOnClickListener {
            val output: FileOutputStream = openFileOutput("text.txt", MODE_PRIVATE)
            output.write("\nhello world".toByteArray())
        }
        binding.inputBtn.setOnClickListener {
            var resultString = ""
            openFileInput("text.txt").bufferedReader().forEachLine {
                resultString += it
            }
            binding.result.text = resultString
        }
    }
}