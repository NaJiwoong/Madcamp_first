package com.example.myapp

import android.content.Context
import android.database.Cursor
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.myapp.ui.main.SectionsPagerAdapter
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.provider.ContactsContract
import java.util.ArrayList



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }





    companion object{

        class PhoneBook {

            private var id: String? = null
            private var name: String? = null
            private var tel: String? = null

            fun setId(id: String?){
                this.id = id
            }
            fun setName(name: String?){
                this.name = name
            }
            fun setTel(num: String?){
                this.tel = num
            }
        }

        @JvmStatic
        fun getContacts(context: Context?): List<PhoneBook>{
            val datas = ArrayList<PhoneBook>()
            val resolver = context?.contentResolver

            val phoneUri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI

            val projection = arrayOf(ContactsContract.CommonDataKinds.Phone.CONTACT_ID // 인덱스 값, 중복될 수 있음 -- 한 사람 번호가 여러개인 경우
                ,  ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                ,  ContactsContract.CommonDataKinds.Phone.NUMBER)

            val cursor: Cursor? = resolver?.query(phoneUri, projection, null, null, null)

            if (cursor != null){
                while(cursor.moveToNext()){
                    var idIndex = cursor.getColumnIndex(projection[0])
                    var nameIndex = cursor.getColumnIndex(projection[1])
                    var numberIndex = cursor.getColumnIndex(projection[2])

                    var id = cursor.getString(idIndex)
                    var name = cursor.getString(nameIndex)
                    var number = cursor.getString(numberIndex)

                    val phoneBook = PhoneBook().apply{
                        setId(id); setName(name); setTel(number)
                    }

                    datas.add(phoneBook)
                }
            }
            cursor?.close()
            return datas
        }
    }

}