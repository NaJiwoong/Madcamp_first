package com.example.myapp.ui.main

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.GridView
import androidx.lifecycle.ViewModelProviders
import com.example.myapp.MainActivity
import com.example.myapp.R


class PageTwo : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myView: View = inflater.inflate(R.layout.fragment_page_two, container, false)
        val albums: List<MainActivity.Companion.Album> = MainActivity.getAlbums(context)
        val grid = myView.findViewById<GridView>(R.id.gridview)

        val photoAdapter = AlbumAdapter(getActivity(), albums)
        grid.adapter = photoAdapter

        grid.setOnItemClickListener(AdapterView.OnItemClickListener{parent, v, position, id ->
            photoAdapter.callImageViewer(position)
        })


        return myView
    }



    companion object {

        @JvmStatic
        fun newInstance(): PageTwo {
            val args = Bundle()

            val fragment = PageTwo()
            fragment.arguments = args
            return fragment
        }

    }
}
