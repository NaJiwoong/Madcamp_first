package com.example.myapp.ui.main

import android.app.Activity
import android.content.ClipData
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.ContextCompat.startActivity
import com.bumptech.glide.Glide
import com.example.myapp.MainActivity
import com.example.myapp.R
import com.example.myapp.img_pop
import java.io.File

class AlbumAdapter (val context: Context?, val data: List<MainActivity.Companion.Album>): BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val myPic = data[position]

        val view: View? = LayoutInflater.from(context).inflate(R.layout.pictures, null)
        val imagev = view?.findViewById<ImageView>(R.id.imageView1)
        Glide.with(context).load(myPic.getPath()).into(imagev)

        return view
    }


    fun callImageViewer(selectedIndex: Int){
        val popImg = img_pop()
        val i: Intent = Intent(context, popImg::class.java)
        val imgPath: String? = data[selectedIndex].getPath()
        i.putExtra("filename", imgPath)
        context?.startActivity(i)
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


    companion object{

        class ViewHolder{
            var imagev: ImageView? = null
        }
    }


}
