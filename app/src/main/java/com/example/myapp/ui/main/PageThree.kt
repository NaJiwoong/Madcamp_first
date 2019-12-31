package com.example.myapp.ui.main

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.lifecycle.ViewModelProviders

import java.io.File

class PageThree : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(com.example.myapp.R.layout.fragment_page_three, container, false)
        val saveBtn: Button = view.findViewById(com.example.myapp.R.id.saveBtn)
        var edittext: EditText = view.findViewById(com.example.myapp.R.id.edittext)
        var myList: ListView = view.findViewById(com.example.myapp.R.id.todolist)
        val filePath = context?.getFilesDir()?.getPath().toString() + "/ToDoList.txt"
        var file = File(filePath)
        file.createNewFile()
        var todoList: List<String> = load(filePath)
        var todoAdapter = TodoList(getActivity(), filePath)

        saveBtn.setOnClickListener{v->
            var writeText = edittext.text.toString()
            if (writeText != "" && writeText != null){
                save(writeText, filePath)
                todoList = load(filePath)
            }
            edittext.text.clear()
            myList.adapter = todoAdapter
        }

        edittext.setOnKeyListener { v, keyCode, event ->
            var writeText=edittext.text.toString()
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER && writeText != "" && writeText != null){
                save(writeText, filePath)
                todoList = load(filePath)
                edittext.text.clear()
                myList.adapter = todoAdapter
            }
            false
        }



        view.setOnClickListener{v->
            v.hideKeyboard()
        }


        myList.adapter = todoAdapter

        return view
    }

    fun save(text: String, filePath: String){
        var writeText = text + "\n"
        var fileOut = File(filePath)
        val curStr: ArrayList<String> = fileOut.readLines() as ArrayList<String>
        var writeStr = ""
        for (str in curStr){
            writeStr += str + "\n"
        }
        writeStr += writeText
        fileOut.writeText(writeStr)
    }

    companion object {


        fun View.hideKeyboard() {
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(windowToken, 0)
        }

        fun load(filePath: String): ArrayList<String>{
            var fileIn = File(filePath)
            var result = fileIn.readLines() as ArrayList<String>
            return result
        }



        @JvmStatic
        fun newInstance(): PageThree {
            val args = Bundle()

            val fragment = PageThree()
            fragment.arguments = args
            return fragment
        }

    }
}
