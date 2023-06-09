package com.example.notification

import android.app.NotificationManager
import android.app.RemoteInput
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notification.databinding.ActivityMain2Binding
import com.example.notification.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "알림 결과"

        val replyTxt = RemoteInput.getResultsFromIntent(intent)
            ?.getCharSequence("key_text_reply")

        binding.result.text = replyTxt

        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        manager.cancel(11)
    }
}