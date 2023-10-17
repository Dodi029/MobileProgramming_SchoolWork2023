package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.broadcastreceiver.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val receiver = object: BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                Toast.makeText(context, "동적 MyReceiver", Toast.LENGTH_SHORT).show()
            }
        }

        val filter = IntentFilter("ACTION_RECEIVER")
        registerReceiver(receiver, filter)

        binding.implicitExec.setOnClickListener {
            val intent = Intent()
            intent.action = "ACTION_RECEIVER"
            sendBroadcast(intent)
        }

        binding.explicitExec.setOnClickListener {
            sendBroadcast(Intent(this, MyReceiver::class.java))
        }
    }
}