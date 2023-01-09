package com.example.hilingin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class CheckOutActivity : AppCompatActivity() {
    private lateinit var namaCheckOut : TextView
    private lateinit var tanggalCheckOut : TextView
    private lateinit var tempatCheckOut : TextView
    private lateinit var jumlahCheckOut : TextView
    private lateinit var hargaCheckOut : TextView
    private lateinit var totalCheckOut : TextView
    private lateinit var emailCheckOut : TextView
    private lateinit var teleponCheckOut : TextView
    private lateinit var bayarButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_out)

        namaCheckOut = findViewById(R.id.checkoutnama)
        tanggalCheckOut = findViewById(R.id.checkouttanggal)
        tempatCheckOut = findViewById(R.id.checkouttempat)
        jumlahCheckOut = findViewById(R.id.checkouttiket)
        hargaCheckOut = findViewById(R.id.checkoutharga)
        totalCheckOut = findViewById(R.id.checkouttotal)
        bayarButton = findViewById(R.id.bayarbuttoncheckout)

        var nama = intent.getStringExtra("namatransaksi")
        var telepon = intent.getStringExtra("telepontransaksi")
        var email = intent.getStringExtra("emailtransaksi")
        var tiket = intent.getStringExtra("tikettransaksi").toString().toInt()
        var tanggal = intent.getStringExtra("tanggaltransaksi")
        var harga = intent.getStringExtra("hargakeluar").toString().toInt()
        var tempat = intent.getStringExtra("namakeluar")

        var total = tiket*harga

        namaCheckOut.text = nama
        teleponCheckOut.text = telepon
        tempatCheckOut.text = tempat
        emailCheckOut.text = email
        jumlahCheckOut.text = tiket.toString()
        tanggalCheckOut.text = tanggal
        hargaCheckOut.text = harga.toString()
        totalCheckOut.text = total.toString()
    }
}