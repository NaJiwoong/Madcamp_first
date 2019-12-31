package com.example.myapp.ui.main

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import com.example.myapp.R
import java.io.File

class TodoList (val context: Context?, var filePath: String): BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.activity_todo_list, null)
        val v2: View = LayoutInflater.from(context).inflate(R.layout.fragment_page_three, null)
        var todolist: ArrayList<String> = PageThree.load(filePath)
        if (todolist == null){
            return view
        }

        var sizefile = PageThree.load(filePath)
        if (position >= sizefile.size || position <0){
            return view
        }

        var showText = todolist[position]

        var num = view.findViewById<TextView>(R.id.number)
        var text = view.findViewById<TextView>(R.id.todo)
        var btn = v2.findViewById<Button>(R.id.saveBtn)
        var rem = view.findViewById<Button>(R.id.remove)


        fun View.hideKeyboard() {
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(windowToken, 0)
        }

        view.setOnClickListener{v->
            view.hideKeyboard()
        }

        btn.setOnClickListener{v->
            notifyDataSetChanged()
        }

        rem.setOnClickListener{v->
            todolist.removeAt(position)
            var resStr: String = ""
            for (str in todolist){
                resStr += str + "\n"
            }
            var fileOut = File(filePath)
            fileOut.writeText(resStr)
            notifyDataSetChanged()
        }


        num.setText((position+1).toString() + ". ")
        text.setText(showText)

        return view
    }

    override fun getItem(position: Int): String{
        var todolist = PageThree.load(filePath)
        if (todolist == null){
            return ""
        }
        return todolist[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int{
        var todolist = PageThree.load(filePath)
        if (todolist == null){
            return 0
        }
        return todolist.size
    }

}
