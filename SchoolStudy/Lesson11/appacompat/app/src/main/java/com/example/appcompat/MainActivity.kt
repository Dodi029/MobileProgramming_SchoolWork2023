package com.example.appcompat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Main Activity"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(0,0,0,"menu1")
        menu?.add(0,1,0,"menu2")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            0 -> startActivity(Intent(this, MainActivity2::class.java))
            1 -> startActivity(Intent(this, MainActivity3::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
}
