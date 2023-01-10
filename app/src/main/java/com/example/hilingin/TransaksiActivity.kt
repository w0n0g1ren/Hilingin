package com.example.hilingin

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class TransaksiActivity : AppCompatActivity() {
    private lateinit var nama: EditText
    private lateinit var telepon: EditText
    private lateinit var email: EditText
    private lateinit var jumlah: EditText
    private lateinit var button: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaksi)

        var hargamasuk = intent.getStringExtra("hargamasuk")
        var namamasuk = intent.getStringExtra("namamasuk")
//        //date
//

        nama = findViewById(R.id.etnama)
        telepon = findViewById(R.id.etnomor)
        email = findViewById(R.id.etemail)
        jumlah = findViewById(R.id.etjumlah)
        button = findViewById(R.id.btn)

        button.setOnClickListener {
            var nama = nama.text.toString()
            var telepon = telepon.text.toString()
            var email = email.text.toString()
            var jumlah = jumlah.text.toString()

            val intent = Intent(this,CheckOutActivity::class.java)
            intent.putExtra("nama",nama)
            intent.putExtra("email",email)
            intent.putExtra("jumlah",jumlah)
            intent.putExtra("nomor",telepon)
            intent.putExtra("tiket",hargamasuk)
            intent.putExtra("wisata",namamasuk)
            startActivity(intent)
        }
    }
}