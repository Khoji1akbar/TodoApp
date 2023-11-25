package com.example.todoapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import com.example.todoapp.Mytodo
import com.example.todoapp.databinding.ChildItemBinding
import com.example.todoapp.databinding.ParentItemBinding

class ExsemleAdapter(val otasi :List<String> , val hashMap: HashMap<String , ArrayList<Mytodo>>):BaseExpandableListAdapter() {
    override fun getGroupCount(): Int {
        return otasi.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        try {
            return hashMap[otasi[groupPosition]]!!.size
        } catch (e: Exception) {
            return 0
        }
    }

    override fun getGroup(groupPosition: Int): Any {
        return otasi[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return otasi[groupPosition][childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val otasinibinding=
            ChildItemBinding.inflate(LayoutInflater.from(parent!!.context),parent,false)
        otasinibinding.tvName.text=otasi[groupPosition]
        return otasinibinding.root

    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val bolasiBinding=
            ChildItemBinding.inflate(LayoutInflater.from(parent!!.context),parent,false)
        bolasiBinding.tvName.text=hashMap[otasi[groupPosition]]!!.get(childPosition).name
        return bolasiBinding.root
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

}