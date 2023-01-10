package com.example.hilingin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class CheckOutActivity : AppCompatActivity() {
    private lateinit var nama: TextView
    private lateinit var telepon: TextView
    private lateinit var jumlah: TextView
    private lateinit var email: TextView
    private lateinit var wisata: TextView
    private lateinit var tiket: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_out)


        nama = findViewById(R.id.tvnama)
        telepon = findViewById(R.id.tvtelepon)
        jumlah = findViewById(R.id.tvjumlah)
        email = findViewById(R.id.tvemail)
        wisata = findViewById(R.id.tvwisata)
        tiket = findViewById(R.id.tvtiket)

        var getnama = intent.getStringExtra("nama")
        var gettelepon = intent.getStringExtra("nomor")
        var getjumlah = intent.getStringExtra("jumlah").toString().toInt()
        var getemail = intent.getStringExtra("email")
        var getharga = intent.getStringExtra("tiket").toString().toInt()
        var getwisata = intent.getStringExtra("wisata")

        var total = getharga * getjumlah

        nama.text = getnama.toString()
        telepon.text = gettelepon.toString()
        jumlah.text = total.toString()
        email.text = getemail.toString()
        wisata.text = getwisata.toString()
        tiket.text = getharga.toString()
    }
}