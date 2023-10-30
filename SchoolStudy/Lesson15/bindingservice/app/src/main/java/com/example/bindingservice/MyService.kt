package com.example.bindingservice

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.*
import android.widget.Toast


class MyService : Service() {
    lateinit var messenger: Messenger
    internal class IncomingHandler(val context: Context) : Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                10 -> Toast.makeText(context.applicationContext, "${msg.obj}", Toast.LENGTH_SHORT).show()
                20 -> Toast.makeText(context.applicationContext, "${(msg.obj as Bundle).getString("data")}", Toast.LENGTH_SHORT).show()
                else -> super.handleMessage(msg)
            }
        }
    }

    override fun onBind(intent: Intent) : IBinder {
        Toast.makeText(applicationContext, "MyService-onBind", Toast.LENGTH_SHORT).show()
        messenger = Messenger(IncomingHandler(this))
        return messenger.binder
    }
}