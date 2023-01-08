package com.example.hilingin.fragment

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import com.google.firebase.firestore.FirebaseFirestore
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hilingin.MainActivity
import com.example.hilingin.adapter.adapter
import com.example.hilingin.databinding.FragmentWisataBinding
import com.example.hilingin.model.tempat_wisata

class WisataFragment : Fragment() {
    private  var _binding : FragmentWisataBinding? = null
    private val Binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun fetchData() {
        FirebaseFirestore.getInstance().collection("tempatwisata")
            .get()
            .addOnSuccessListener  { documents ->
            for (document in documents){

                val twambil = documents.toObjects(tempat_wisata::class.java)
               _binding?.recyclerviewtempatwisata?.adapter = adapter(context as MainActivity, twambil)
            }

        }
            .addOnFailureListener {
                Toast.makeText(context,"gagal",Toast.LENGTH_SHORT).show()
            }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        _binding = FragmentWisataBinding.inflate(inflater, container, false)
        _binding?.recyclerviewtempatwisata?.apply {
            layoutManager = LinearLayoutManager(activity)
        }
        fetchData()
        return Binding.root

      

    }
}