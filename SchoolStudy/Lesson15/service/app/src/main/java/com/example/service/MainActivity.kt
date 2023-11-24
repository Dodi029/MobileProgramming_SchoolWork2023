package com.example.service

import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.Toast
import com.example.service.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startService.setOnClickListener {
            startService(Intent(this, MyService::class.java))
        }

        binding.stopService.setOnClickListener {
            stopService(Intent(this, MyService::class.java))
        }

        var serviceBinder: MyService.MyBinder
        var connection: ServiceConnection = object : ServiceConnection{
            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                Toast.makeText(applicationContext, "onServiceConnected", Toast.LENGTH_SHORT).show()
                serviceBinder = service as MyService.MyBinder
                binding.resultText.text = serviceBinder.funB(10).toString()
            }

            override fun onServiceDisconnected(name: ComponentName?) {
                Toast.makeText(applicationContext, "onServiceDisconnected", Toast.LENGTH_SHORT).show()
            }
        }

        binding.bindService.setOnClickListener {
            bindService(Intent(this, MyService::class.java), connection, BIND_AUTO_CREATE)
        }
        binding.unbindService.setOnClickListener {
            unbindService(connection)
        }
    }
}
