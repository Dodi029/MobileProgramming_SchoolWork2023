package com.example.bindingservice2

import android.app.Service
import android.content.Intent
import android.os.IBinder

class MyAIDLService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}