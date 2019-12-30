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
class PageTwo : Fragment() {
    // TODO: Rename and change types of parameters

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

        @JvmStatic
        fun newInstance(): PageTwo {
            val args = Bundle()

            val fragment = PageTwo()
            fragment.arguments = args
            return fragment
        }

    }
}
