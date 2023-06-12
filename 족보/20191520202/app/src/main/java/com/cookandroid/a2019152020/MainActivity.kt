package com.cookandroid.a2019152020

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "중간고사"

    }

    override fun OnCreateOptionsMenu(menu: Menu?) : Boolean {
        menuInflater.inflate(R.menu.menu1, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.itemCal -> Intent(applicationContext, CalActivity::class.java)
            R.id.itemInformation -> Intent(applicationContext, Information::class.java)
            R.id.itemImg -> Intent(applicationContext, ImgSelect::class.java)
        }
        return super.onOptionsItemSelected(item)
    }
}