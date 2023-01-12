package com.example.hilingin

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.hilingin.Object.Constant.BASE_URL_MIDTRANS
import com.example.hilingin.Object.Constant.CLIENT_KEY_MIDTRANS
import com.example.hilingin.model.User
import com.example.hilingin.model.transaksi
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.net.URLEncoder

class CheckOutActivity : AppCompatActivity() {
    private lateinit var nama: TextView
    private lateinit var telepon: TextView
    private lateinit var jumlah: TextView
    private lateinit var email: TextView
    private lateinit var wisata: TextView
    private lateinit var tiket: TextView
    private lateinit var jmltiket : TextView

    private lateinit var buttonMidtrans: Button
    private lateinit var database : DatabaseReference

    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_out)


        nama = findViewById(R.id.tvnama)
        telepon = findViewById(R.id.tvtelepon)
        jumlah = findViewById(R.id.tvjumlah)
        email = findViewById(R.id.tvemail)
        wisata = findViewById(R.id.tvwisata)
        tiket = findViewById(R.id.tvtiket)
        buttonMidtrans = findViewById(R.id.btnbayar)
        jmltiket = findViewById(R.id.tvjumlahtiket)

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
        jmltiket.text = getjumlah.toString()

        var email = getemail.toString()

        var total2 = total.toString()
        buttonMidtrans.setOnClickListener {
            database= FirebaseDatabase.getInstance().getReference("Transaksi")
            var db = database.push().key!!
            val transaksi = transaksi(getnama,gettelepon,getemail,getwisata,getharga.toString(),getjumlah.toString(),total.toString())
                database.child(db).setValue(transaksi)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(this, "Input berhasil", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "Input gagal", Toast.LENGTH_SHORT).show()
                        }
                    }

            val intent = packageManager.getLaunchIntentForPackage("com.example.kotlin_payment_gateway")

            if (intent != null){
                startActivity(intent)
            }
        }
    }
    }
