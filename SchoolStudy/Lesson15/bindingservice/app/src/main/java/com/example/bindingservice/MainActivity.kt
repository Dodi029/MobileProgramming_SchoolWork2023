package com.example.bindingservice

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.os.Message
import android.os.Messenger
import com.example.bindingservice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var messenger: Messenger
    val conntection: ServiceConnection = object: ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            messenger = Messenger(service)
        }

        override fun onServiceDisconnected(name: ComponentName?) {
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bindService.setOnClickListener {
            bindService(Intent(this, MyService::class.java), conntection, BIND_AUTO_CREATE)
        }

        binding.sendData10.setOnClickListener {
            val msg = Message()
            msg.what = 10
            msg.obj = "hello"
            messenger.send(msg)
        }

        binding.sendData20.setOnClickListener {
            val msg = Message()
            msg.what = 20
            msg.obj = "hello"
            messenger.send(msg)
        }
    }
}