package com.example.cp2

import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleCursorAdapter

class MainActivity : AppCompatActivity() {
    lateinit var cpListview: ListView
    lateinit var adapter: SimpleCursorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cpListview = findViewById(R.id.cpListView)

        val PROVIDER_NAME = "com.example.datastorage.ContentProvider.MyContentProvider"
        val URL = "content://$PROVIDER_NAME/DETAIL_TABLE"
        val CONTENT_URI : Uri = Uri.parse(URL)

        var fromColumn = arrayOf("NAME","DEPARTMENT")
        var rs: Cursor? = contentResolver.query(CONTENT_URI,null,null,null,null,null)
        var rowLayout = android.R.layout.simple_list_item_2
        var toTextView = intArrayOf(android.R.id.text1,android.R.id.text2)
        adapter = SimpleCursorAdapter(this,rowLayout,rs,fromColumn,toTextView,1)
        cpListview.adapter =adapter
    }
}