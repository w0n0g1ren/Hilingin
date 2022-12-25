package com.example.hilingin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegisterActivity : AppCompatActivity() {
    lateinit var auth : FirebaseAuth
    private lateinit var database : DatabaseReference
    private lateinit var btnregister : Button
    private lateinit var email : EditText
    private lateinit var password : EditText
    private lateinit var nama : EditText
    private lateinit var hp : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnregister = findViewById(R.id.buatakun)
        email = findViewById(R.id.etemailregister)
        password = findViewById(R.id.etpasswordregister)
        nama = findViewById(R.id.etnamaregister)
        hp = findViewById(R.id.etteleponregister)
        auth = FirebaseAuth.getInstance()

        btnregister.setOnClickListener{
            var takenama = nama.text.toString()
            var takehp = hp.text.toString()
            var takeemail = email.text.toString()
            var takepassword = password.text.toString()

            val db = database.push().key!!
            val user = User(takenama,takehp,takeemail,takepassword)
            database.child(db).setValue(user)
            auth.createUserWithEmailAndPassword(takeemail,takepassword)
                .addOnCompleteListener{
                    if (it.isSuccessful){
                        Toast.makeText(this,"Input berhasil",Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this,"Input gagal",Toast.LENGTH_SHORT).show()
                    }
                }


        }
    }
}