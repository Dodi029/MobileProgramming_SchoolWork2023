package com.example.textview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import androidx.activity.OnBackPressedCallback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        onBackPressedDispatcher.addCallback(this, object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                Log.d("kkang","Callback()-BACK Button을 눌렀네요")
            }
        })
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action){
            MotionEvent.ACTION_DOWN -> {
                Log.d("kkang", "Main Touch down event X: ${event.x}, rawX: ${event.rawX}")
            }
        }
        return super.onTouchEvent(event)
    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode){
            KeyEvent.KEYCODE_BACK -> Log.d("kkang", "BACK Bytton을 눌렀네요")
            KeyEvent.KEYCODE_VOLUME_UP ->Log.d("kkang","Volume Up 키를 눌렀네요")
            KeyEvent.KEYCODE_VOLUME_DOWN -> Log.d("kkang", "Volume Down 키를 눌렀네요")
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onBackPressed() {
        Log.d("kkang", "onBackPressed()-BACK Button을 눌렀네요")
        super.onBackPressed()
    }
}

class MyTextView(context: Context, attrs: AttributeSet):
    androidx.appcompat.widget.AppCompatTextView(context, attrs){
    override fun onTouchEvent(event: MotionEvent?): Boolean{
        when (event?.action){
            MotionEvent.ACTION_DOWN -> {
                Log.d("kkang", "TextView Touch down event X: ${event.x}, rawX: ${event.rawX}")
            }
        }
        return super.onTouchEvent(event)
    }
    }