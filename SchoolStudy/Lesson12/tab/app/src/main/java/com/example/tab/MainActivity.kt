package com.example.tab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.tab.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Tab Layout"

        binding.tabs.addTab(binding.tabs.newTab().apply { text="Tab1" })
        binding.tabs.addTab(binding.tabs.newTab().apply { text="Tab2" })
        binding.tabs.addTab(binding.tabs.newTab().apply { text="Tab3" })

        binding.tabs.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(applicationContext, tab?.text, Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(0,0,0,"Tab(XML)")?.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
        menu?.add(0,1,0,"Tab+ViewPager")?.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            0 -> { startActivity(Intent(this, MainActivity2::class.java))}
            1 -> { startActivity(Intent(this, MainActivity3::class.java))}
        }
        return super.onOptionsItemSelected(item)
    }
}