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
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.lifecycle.ViewModelProviders

import java.io.File




// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [PageOne.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [PageOne.newInstance] factory method to
 * create an instance of this fragment.
 */
class PageThree : Fragment() {
    // TODO: Rename and change types of parameters

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
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER){
                save(writeText, filePath)
                todoList = load(filePath)
                edittext.text.clear()
                myList.adapter = todoAdapter
            }
            false
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


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PageOne.
         */
        // TODO: Rename and change types and number of parameters

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
