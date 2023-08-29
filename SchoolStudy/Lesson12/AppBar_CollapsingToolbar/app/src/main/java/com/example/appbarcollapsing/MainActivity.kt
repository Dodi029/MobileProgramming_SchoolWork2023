package com.example.appbarcollapsing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.appbarcollapsing.MainActivity2
import com.example.appbarcollapsing.MainActivity3
import com.example.appbarcollapsing.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        title="App Bar"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(0, 0, 0, "RecycleView")?.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
        menu?.add(0, 1, 0, "CollapsingToolbar")?.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            0 -> { startActivity(Intent(this, MainActivity2::class.java))}
            1 -> { startActivity(Intent(this, MainActivity3::class.java))}
        }
        return super.onOptionsItemSelected(item)
    }
}