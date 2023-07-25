package com.example.viewpager

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.RecoverySystem
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager.databinding.ActivityMainBinding
import com.example.viewpager.databinding.ItemPagerBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = mutableListOf("Pager1", "Pager2", "Pager3")

        binding.viewpager.adapter = MyPagerAdapter(data)
    }
}

class MyPagerViewHolder(val binding:ItemPagerBinding) :
        RecyclerView.ViewHolder(binding.root)

class MyPagerAdapter(val data: MutableList<String>):
        RecyclerView.Adapter<MyPagerViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPagerViewHolder {
        return MyPagerViewHolder(ItemPagerBinding.inflate(LayoutInflater.from(parent.context),
        parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyPagerViewHolder, position: Int) {
        val binding = (holder as MyPagerViewHolder).binding
        binding.itemPagerTextView.text = data[position]
        when (position %3){
            0 -> binding.itemPagerTextView.setBackgroundColor(Color.RED)
            1 -> binding.itemPagerTextView.setBackgroundColor(Color.BLUE)
            2 -> binding.itemPagerTextView.setBackgroundColor(Color.GREEN)
        }
    }
        }