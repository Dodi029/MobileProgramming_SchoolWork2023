package com.example.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.widget.Toast

class MyService : Service() {
    class MyBinder : Binder() {
        fun funA(arg: Int) {}
        fun funB(arg: Int): Int {
            return arg * arg
        }
    }

    override fun onCreate() {
        super.onCreate()
        Toast.makeText(applicationContext, "MyService-onCreate", Toast.LENGTH_SHORT).show()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(applicationContext, "MyService-onStartCommand", Toast.LENGTH_SHORT).show()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder {
        Toast.makeText(applicationContext, "MyService-onBind", Toast.LENGTH_SHORT).show()
        return MyBinder()
    }

    override fun onDestroy() {
        Toast.makeText(applicationContext, "MyService-onDestroy", Toast.LENGTH_SHORT).show()
        super.onDestroy()
    }
}