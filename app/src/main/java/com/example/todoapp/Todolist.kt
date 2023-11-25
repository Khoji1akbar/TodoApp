package com.example.todoapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todoapp.Adapter.ExsemleAdapter
import com.example.todoapp.Utils.MySharedPreference
import com.example.todoapp.databinding.ActivityAddTodoBinding
import com.example.todoapp.databinding.ActivityTodolisBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Todolist : AppCompatActivity() {
    lateinit var map: HashMap<String, ArrayList<Mytodo>>
    lateinit var titleList:ArrayList<String>

    lateinit var openArray:ArrayList<Mytodo>
    lateinit var developmentArray:ArrayList<Mytodo>
    lateinit var uploadingArray:ArrayList<Mytodo>
    lateinit var rejectArray:ArrayList<Mytodo>
    lateinit var closedArray:ArrayList<Mytodo>
    private val binding by lazy { ActivityTodolisBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.setTitle("To do list")

        MySharedPreference.init(this)

        binding.exp.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            val intent = Intent(this, Aboutlist::class.java)
            val myTodo:Mytodo =  map[titleList[groupPosition]]?.get(childPosition)!!
            intent.putExtra("name",myTodo)
            startActivity(intent)
            return@setOnChildClickListener true
        }


    }
    private fun keshdanArrayga() {
         map = HashMap()
         titleList = ArrayList()
        titleList.add("Open")
        titleList.add("Development")
        titleList.add("Uploading")
        titleList.add("Reject")
        titleList.add("Close")

        openArray = ArrayList()
        developmentArray = ArrayList()
        uploadingArray = ArrayList()
        rejectArray = ArrayList()
        closedArray = ArrayList()

        val planArray = MySharedPreference.list
        for (todoPlan in planArray) {
            when(todoPlan.parent)
            {
                "Open"->openArray.add(todoPlan)
                "Development"->developmentArray.add(todoPlan)
                "Uploading"->uploadingArray.add(todoPlan)
                "Reject"->rejectArray.add(todoPlan)
                "Close"->closedArray.add(todoPlan)
            }
        }

        map[titleList[0]] = openArray
        map[titleList[1]] = developmentArray
        map[titleList[2]] = uploadingArray
        map[titleList[3]] = rejectArray
        map[titleList[4]] = closedArray

    }
    override fun onStart() {
        super.onStart()
        keshdanArrayga()
        val spinerAdapter1 = ExsemleAdapter(titleList, map)
        binding.exp.setAdapter(spinerAdapter1)

    }
}