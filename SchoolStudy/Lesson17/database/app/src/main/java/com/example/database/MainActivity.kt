package com.example.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.database.databinding.ActivityMainBinding
import com.example.database.databinding.ResultItemBinding
import java.io.File

class MainActivity : AppCompatActivity() {
    val names = mutableListOf<String>()
    val phones = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "전화번호부"

//        val path: File = getDatabasePath("testdb")
//        if(path.exists().not()) {
//            val db = openOrCreateDatabase("testdb", MODE_PRIVATE, null)
//            db.execSQL("create table USER_TB (_id integer primary key autoincrement, name text not null, phone text)")
//            db.close()
//        }
        val dbHelper = DBHelpter(this)

        binding.resultList.layoutManager = LinearLayoutManager(this)
        val adapter = ResultAdapter(names, phones)
        binding.resultList.adapter = adapter
        binding.resultList.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

        binding.searchAllBtn.setOnClickListener {
//            val db = openOrCreateDatabase("testdb", Context.MODE_PRIVATE, null)
            val db = dbHelper.readableDatabase
            val cursor = db.rawQuery("select name, phone from USER_TB", null)
            names.clear()
            phones.clear()
            while (cursor.moveToNext()) {
                names.add(cursor.getString(0))
                phones.add(cursor.getString(1))
            }
            db.close()
            adapter.notifyDataSetChanged()
        }
        binding.insertBtn.setOnClickListener {
//            val db = openOrCreateDatabase("testdb", Context.MODE_PRIVATE, null)
            val db = dbHelper.writableDatabase

            db.execSQL("insert into USER_TB(name, phone) values(?, ?)",
                arrayOf(binding.inputName.text.toString(), binding.inputPhone.text.toString()))
            db.close()
        }
        binding.deleteBtn.setOnClickListener {
//            val db = openOrCreateDatabase("testdb", Context.MODE_PRIVATE, null)
            val db = dbHelper.writableDatabase
            db.execSQL("delete from USER_TB")
            db.close()
        }
    }
}

class ResultHolder(val binding: ResultItemBinding) : RecyclerView.ViewHolder(binding.root)

class ResultAdapter(val names: MutableList<String>, val phones: MutableList<String>):
        RecyclerView.Adapter<ResultHolder>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultHolder =
                ResultHolder(ResultItemBinding.inflate(LayoutInflater.from(parent.context),
                parent, false))

    override fun getItemCount(): Int = names.size + 1

    override fun onBindViewHolder(holder: ResultHolder, position: Int) {
        if (position == 0) {
            holder.binding.name.text = "[[ NAME ]]"
            holder.binding.phone.text = "[[ PHONE ]]"
        } else {
            holder.binding.name.text = names[position - 1]
            holder.binding.phone.text = phones[position - 1]
        }
    }
}
class DBHelpter(context: Context): SQLiteOpenHelper(context, "testdb", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table USER_TB (_id integer primary key autoincrement, name text not null, phone text)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table if exists USER_TB")
        onCreate(db)
    }
}