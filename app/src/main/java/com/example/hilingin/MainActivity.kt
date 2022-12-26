package com.example.hilingin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val RecyclerView = findViewById<RecyclerView>(R.id._imageRecycleView)
        RecyclerView.layoutManager = LinearLayoutManager(this)
        RecyclerView.setHasFixedSize(true)
    }
}