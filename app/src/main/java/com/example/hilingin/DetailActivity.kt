package com.example.hilingin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    private lateinit var nama: TextView
    private lateinit var harga: TextView
    private lateinit var keterangan: TextView
    private lateinit var lokasi: TextView
    private lateinit var image: ImageView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        nama = findViewById(R.id.namatempatdetail)
        harga = findViewById(R.id.hargadetail)
        keterangan = findViewById(R.id.penjelasandetail)
        lokasi = findViewById(R.id.lokasidetail)
        image = findViewById(R.id.gambardetail)
        button = findViewById(R.id.buttonbayar)

        var nama2 = intent.getStringExtra("nama")
        var harga2 = intent.getStringExtra("harga")
        var keterangan2 = intent.getStringExtra("keterangan")
        var lokasi2 = intent.getStringExtra("lokasi")
        var image2 = intent.getStringExtra("gambar")

        nama.text = nama2
        harga.text = harga2
        keterangan.text = keterangan2
        lokasi.text = lokasi2
        image.loadImage(image2)

        button.setOnClickListener {
            val intent = Intent(this,TransaksiActivity::class.java)
            intent.putExtra("hargamasuk",harga2)
            intent.putExtra("namamasuk",nama2)
            startActivity(intent)
        }

    }

    fun ImageView.loadImage(uri:String?){
        Glide.with(context)
            .load(uri)
            .centerCrop()
            .into(this)

    }
}