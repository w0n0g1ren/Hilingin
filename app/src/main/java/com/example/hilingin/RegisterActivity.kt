package com.example.hilingin

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.hilingin.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegisterActivity : AppCompatActivity() {
    lateinit var auth : FirebaseAuth
    private lateinit var database : DatabaseReference
    private lateinit var _binding : ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        auth = FirebaseAuth.getInstance()

        _binding.buatakun.setOnClickListener {
            database = FirebaseDatabase.getInstance().getReference("User")
            var takenama = _binding.etnamaregister.text.toString()
            var takehp = _binding.etteleponregister.text.toString()
            var takeemail = _binding.etemailregister.text.toString()
            var takepassword = _binding.etpasswordregister.text.toString()


            val db = database.push().key!!
            val user = User(takenama,takehp,takeemail)
            database.child(db).setValue(user)
            auth.createUserWithEmailAndPassword(takeemail, takepassword)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this,LoginActivity::class.java)
                        Toast.makeText(this, "Input berhasil", Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Input gagal", Toast.LENGTH_SHORT).show()
                    }
                }
        }
        }
    }
