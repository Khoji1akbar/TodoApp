package com.example.todoapp.Utils

import android.content.Context
import android.content.SharedPreferences
import com.example.todoapp.Mytodo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object MySharedPreference {
    private const val NAME = "catch_file_name"
    private const val MODE = Context.MODE_PRIVATE

    private lateinit var preferences: SharedPreferences

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }


    var list: ArrayList<Mytodo>
        get() = gsonStringToList(preferences.getString("my_list", "[]")!!)
        set(value) = preferences.edit {
            it.putString("my_list", listToGsonString(value))
        }
}

private fun gsonStringToList(gsonString: String): ArrayList<Mytodo> {
    val list = ArrayList<Mytodo>()
    val type = object : TypeToken<ArrayList<Mytodo>>() {}.type
    list.addAll(Gson().fromJson(gsonString, type))
    return list
}

private fun listToGsonString(list: ArrayList<Mytodo>): String {

    return Gson().toJson(list)
}
