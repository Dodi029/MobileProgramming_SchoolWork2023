package com.example.bindingservice2

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class MyAIDLService : Service() {
    var name: String = ""
    override fun onBind(intent: Intent): IBinder {
        return object: MyAidlInterface.Stub() {
            override fun funA(data: String) {}
            override fun funB(): Int {
                return 10
            }
        }
    }

    override fun onDestroy() {
        Toast.makeText(applicationContext, "MyAIDLService-onDestroy", Toast.LENGTH_SHORT).show()
        super.onDestroy()
    }
}