package com.example.todoapp

import java.io.Serializable

class Mytodo :Serializable{
    var name :String=""
    var description :String=""
    var spinner :String=""
    var date :String=""
    var dedline :String=""
    var parent:String=""


    constructor(
        name: String,
        description: String,
        spinner: String,
        date: String,
        dedline: String,
        parent: String
    ) {
        this.name = name
        this.description = description
        this.spinner = spinner
        this.date = date
        this.dedline = dedline
        this.parent = parent
    }

    constructor()

    override fun toString(): String {
        return "Mytodo(name='$name', description='$description', spinner='$spinner', date='$date', dedline='$dedline', parent='$parent')"
    }

}

object planObject{

val todoplanlist = ArrayList<Mytodo>()

}