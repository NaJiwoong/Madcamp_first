package com.example.myapp.ui.main

import android.content.ClipData
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.example.myapp.MainActivity
import com.example.myapp.R
import java.io.File


class ViewHolder{
    var imagev: ImageView? = null
}

class AlbumAdapter (val context: Context?, val data: List<MainActivity.Companion.Album>): BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var switch:Int = 0
        val holder: ViewHolder
        if (convertView == null) {
            val view: View = LayoutInflater.from(context).inflate(R.layout.pictures, null)

            holder = ViewHolder()

            holder.imagev = view.findViewById<ImageView>(R.id.imageView1)

            view.setTag(holder)

            val myPic = data[position]
            val imgFile = File(myPic.getPath())
            val bitmap: Bitmap = BitmapFactory.decodeFile(imgFile.absolutePath)

            holder.imagev?.setImageBitmap(bitmap)

            return view

        }else{
            holder = convertView.getTag() as ViewHolder
        }
        val myPic = data[position]
        val imgFile = File(myPic.getPath())
        val bitmap: Bitmap = BitmapFactory.decodeFile(imgFile.absolutePath)

        holder.imagev?.setImageBitmap(bitmap)

        return convertView
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
