package com.example.hilingin

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class TransaksiActivity : AppCompatActivity() {
    private lateinit var datepicker : Button
    private lateinit var selectedDateTV : TextView
    private lateinit var nama : EditText
    private lateinit var telepon : EditText
    private lateinit var email : EditText
    private lateinit var tiket : EditText
    private lateinit var button: Button
    private lateinit var taketanggal2 : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaksi)

        nama = findViewById(R.id.namatransaksi)
        telepon = findViewById(R.id.telepontransaksi)
        email = findViewById(R.id.emailtransaksi)
        tiket = findViewById(R.id.jmltikettransaksi)

        var hargamasuk = intent.getStringExtra("hargamasuk")
        //date

        datepicker = findViewById(R.id.idBtnPickDate)
        selectedDateTV = findViewById(R.id.tampiltanggal)
        datepicker.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(
                this,
                { view, year, monthOfYear, dayOfMonth ->
                    selectedDateTV.text = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                    taketanggal2 = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)

                },
                year,
                month,
                day)
            datePickerDialog.show()
        }


        var takenama = nama.text.toString()
        var taketelepon = telepon.text.toString()
        var takeemail = email.text.toString()
        var taketiket = tiket.text.toString()
        var taketanggal = taketanggal2

        button.setOnClickListener {
            val intent = Intent(this,CheckOutActivity::class.java)
            intent.putExtra("namatransaksi",takenama)
            intent.putExtra("telepontransaksi",taketelepon)
            intent.putExtra("emailtransaksi",takeemail)
            intent.putExtra("tikettransaksi",taketiket)
            intent.putExtra("tanggaltransaksi",taketanggal)
            intent.putExtra("hargakeluar",hargamasuk)
            startActivity(intent)
        }
    }
}