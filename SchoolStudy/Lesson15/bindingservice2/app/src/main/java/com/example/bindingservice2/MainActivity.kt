package com.example.bindingservice2

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bindingservice2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var aidlService: MyAidlInterface
        var connection: ServiceConnection = object : ServiceConnection {
            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                Toast.makeText(applicationContext, "onServiceConnected", Toast.LENGTH_SHORT).show()
                aidlService = MyAidlInterface.Stub.asInterface(service)
                binding.resultText.text = aidlService.funB().toString()
            }

            override fun onServiceDisconnected(name: ComponentName?) {
                Toast.makeText(applicationContext, "onServiceDisconnected", Toast.LENGTH_SHORT).show()
            }
        }

        binding.bindService.setOnClickListener {
            bindService(Intent(this, MyAIDLService::class.java), connection, BIND_AUTO_CREATE)
        }

        binding.unbindService.setOnClickListener {
            unbindService(connection)
        }
    }
}