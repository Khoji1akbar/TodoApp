package com.example.todoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.todoapp.Adapter.SpinneredAdapter
import com.example.todoapp.Utils.MySharedPreference
import com.example.todoapp.databinding.ActivityAddTodoBinding

class AddTodo : AppCompatActivity() {
    private val binding by lazy { ActivityAddTodoBinding.inflate(layoutInflater) }
    private lateinit var adapter: SpinneredAdapter
    private var data1list = ArrayList<Mytodo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val list = listOf<String>("Urgent", "Hard", "Normal", "Low")
        adapter = SpinneredAdapter(list)
        binding.spinner.adapter = adapter
        MySharedPreference.init(this)
        data1list.addAll(MySharedPreference.list)
        binding.btnSave.setOnClickListener {

            if (binding.edtName.text.isNotEmpty()) {
                if (binding.edtDescription.text.isNotEmpty()) {
                    if (binding.edtDate.text.isNotEmpty()) {
                        if (binding.edtDedline.text.isNotEmpty()) {
                            val name = binding.edtName.text.toString().trim()
                            val description = binding.edtDescription.text.toString().trim()
                            val date = binding.edtName.text.toString().trim()
                            val dedline = binding.edtDedline.text.toString().trim()
                            val spinner = binding.spinner.selectedItem.toString()

                            data1list.add(Mytodo(name, description, spinner, date, dedline, "Open"))

                            MySharedPreference.list = data1list

                            //oynani yopish
                            finish()
                        }
                    }
                }
            }
        }
    }
}
