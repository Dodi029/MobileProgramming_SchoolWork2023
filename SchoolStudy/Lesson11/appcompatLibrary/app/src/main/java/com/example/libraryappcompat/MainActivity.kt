package com.example.libraryappcompat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Main Activity"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu1 -> startActivity(Intent(this, MainActivity2::class.java))
            R.id.menu2 -> startActivity(Intent(this, MainActivity3::class.java))
            R.id.menu3 -> Toast.makeText(this, "세번째 메뉴", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}