package com.example.dialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.dialog.databinding.ActivityMainBinding
import com.example.dialog.databinding.DialogBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dialog.setOnClickListener{
            val dialogBinding = DialogBinding.inflate(layoutInflater)
            AlertDialog.Builder(this).run{
                setTitle("Input")
                setView(dialogBinding.root)
                setPositiveButton("닫기"){_, _ ->
                    val message = dialogBinding.editText.text.toString() +
                            when(dialogBinding.gender.checkedRadioButtonId){
                                R.id.male -> "(Male)"
                                R.id.female -> "(Female)"
                                else -> "()"
                            }
                    Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
                }
                show()
            }
        }
    }
}