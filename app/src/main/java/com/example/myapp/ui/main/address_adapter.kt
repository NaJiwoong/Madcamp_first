package com.example.myapp.ui.main

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.myapp.MainActivity
import com.example.myapp.R

class AddressAdapter (val context: Context?, val data: List<MainActivity.Companion.PhoneBook>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.address_item, null)

//        val id = view.findViewById<TextView>(R.id.id)
        val name = view.findViewById<TextView>(R.id.name)
        val tel = view.findViewById<TextView>(R.id.tel)

        val tels = data[position]

//        id.text = tels.getId()
        name.text = tels.getName()
        tel.text = tels.getTel()

        return view
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return data.size
    }

}
