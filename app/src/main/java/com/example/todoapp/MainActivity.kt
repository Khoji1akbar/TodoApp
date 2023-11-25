package com.example.todoapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todoapp.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.addtodo.setOnClickListener {
            val intent = Intent(this@MainActivity,AddTodo::class.java)
            startActivity(intent)
        }

        binding.todolist.setOnClickListener {
            val intent = Intent(this@MainActivity,Todolist::class.java)
            startActivity(intent)
        }




    }
}