package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.myapp.ui.main.PageTwo

class img_pop : AppCompatActivity() {

    val imgWidth: Int = 320
    val imgHeight: Int = 372

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_img_pop)

        val i: Intent = getIntent()
        val extras: Bundle? = i.getExtras()
        val imgPath: String? = extras?.getString("filename")

        val imagev = findViewById<ImageView>(R.id.imagePop)
        Glide.with(this).load(imgPath).into(imagev)

        val btn_back: Button = findViewById<Button>(R.id.back)
        btn_back.setOnClickListener { v: View ->
            if (v.getId() == R.id.back) {
                val intent: Intent = Intent(this, (PageTwo::class.java))
//                startActivity(intent)
                finish()
            }
        }

    }

}