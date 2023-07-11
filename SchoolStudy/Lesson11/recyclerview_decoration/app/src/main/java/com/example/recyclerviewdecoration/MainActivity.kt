package com.example.recyclerviewdecoration

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.State
import com.example.recyclerviewdecoration.databinding.ActivityMainBinding
import com.example.recyclerviewdecoration.databinding.MydecorationBinding
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val datas = mutableListOf<String>()
        var current = 0
        for (i in 1..5){
            current = i
            datas.add("Item $i")
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = MyAdapter(datas)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(MyDecoration(this))
        binding.addBtn.setOnClickListener {
            datas.add("Item ${++current}")
            adapter.notifyDataSetChanged()
        }
    }
}

class MyDecoration(val context: Context): RecyclerView.ItemDecoration(){
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        c.drawBitmap(BitmapFactory.decodeResource(context.resources, R.drawable.stadium), 0f, 0f, null)
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: State) {
        super.onDrawOver(c, parent, state)
        val width = parent.width
        val height = parent.height

        val dr: Drawable? = ResourcesCompat.getDrawable(context.resources, R.drawable.kbo, null)
        val drWadth = dr?.intrinsicWidth
        val drHeight = dr?.intrinsicHeight

        val left = width/2 - drWadth?.div(2) as Int
        val top = height/2 - drHeight?.div(2) as Int
        c.drawBitmap(BitmapFactory.decodeResource(context.resources, R.drawable.kbo),
        left.toFloat(), top.toFloat(), null)
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: State) {
        super.getItemOffsets(outRect, view, parent, state)
        val index = parent.getChildAdapterPosition(view)+1
        if (index %3 == 0) outRect.set(10, 10, 10, 60)
        else outRect.set(10, 10, 10, 0)
        view.setBackgroundColor(Color.LTGRAY)
        ViewCompat.setElevation(view, 20.0f)
    }
}

class MyViewHolder(val binding: MydecorationBinding) : RecyclerView.ViewHolder(binding.root)

class MyAdapter(val datas: MutableList<String>):
        RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        MyViewHolder(MydecorationBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyViewHolder).binding
        binding.itemData.text = datas[position]
        binding.itemData.setOnClickListener{
            Log.d("kkang", "Item Click : $position")
        }
    }
        }