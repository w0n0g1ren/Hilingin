package com.example.hilingin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.hilingin.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Toast.makeText(this,"Login Terlebih Dahulu",Toast.LENGTH_SHORT).show()

        auth = FirebaseAuth.getInstance()

        binding.btnlogin.setOnClickListener {
            val email = binding.etemaillogin.text.toString()
            val password = binding.etpasswordlogin.text.toString()

            if (email.isEmpty()){
                binding.etemaillogin.error = "Email Harus Diisi"
                binding.etpasswordlogin.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.etemaillogin.error = "Email Tidak Valid"
                binding.etpasswordlogin.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()){
                binding.etemaillogin.error = "Password Harus Diisi"
                binding.etpasswordlogin.requestFocus()
                return@setOnClickListener
            }
            LoginFirebase(email,password)
        }

        binding.belumPunya.setOnClickListener { 
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun LoginFirebase(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if(it.isSuccessful){
                    Toast.makeText(this,"Selamat Datang $email",Toast.LENGTH_SHORT).show()
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this,"${it.exception?.message}",Toast.LENGTH_SHORT).show()
                }
            }
    }
}