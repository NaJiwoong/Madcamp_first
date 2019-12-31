package com.example.myapp.ui.main

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.lifecycle.ViewModelProviders
import com.example.myapp.MainActivity
import com.example.myapp.R
import kotlinx.android.synthetic.main.fragment_page_one.*


class PageOne : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myView: View = inflater.inflate(R.layout.fragment_page_one, container, false)
        val list = myView.findViewById<ListView>(R.id.listview)
        val phoneBooks: List<MainActivity.Companion.PhoneBook> = MainActivity.getContacts(context)
        val telAdapter = AddressAdapter(getActivity(), phoneBooks)
        list.adapter = telAdapter

        return myView
    }



    companion object {
        @JvmStatic
        fun newInstance(): PageOne {
            val args = Bundle()

            val fragment = PageOne()
            fragment.arguments = args
            return fragment
        }

    }
}
