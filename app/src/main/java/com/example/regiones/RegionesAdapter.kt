package com.example.regiones

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class RegionesAdapter(context: Context, val lista:List<Region>):ArrayAdapter<Region>(context,0,lista) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val viewItem = convertView ?: LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_2,parent,false)
        val region = lista[position]

        viewItem.findViewById<TextView>(android.R.id.text1)?.text = region.nombre
        viewItem.findViewById<TextView>(android.R.id.text2)?.text = region.iso

        return viewItem
    }
}