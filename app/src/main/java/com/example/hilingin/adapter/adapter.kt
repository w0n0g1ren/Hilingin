package com.example.hilingin.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.drawToBitmap
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hilingin.DetailActivity
import com.example.hilingin.R
import com.example.hilingin.model.tempat_wisata
import com.makeramen.roundedimageview.RoundedImageView

class adapter(private val context: Context, private val model: List<tempat_wisata>) : RecyclerView.Adapter<adapter.UserViewHolder> () {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nama : TextView = itemView.findViewById(R.id.tempatwisatanama)
        var harga : TextView = itemView.findViewById(R.id.tempatwisataharga)
        var lokasi : TextView = itemView.findViewById(R.id.tempatwisatalokasi)
        var gambar_holder : RoundedImageView = itemView.findViewById(R.id.tempatwisatagambar)
        var item_list : CardView = itemView.findViewById(R.id.item_list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list,parent,false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val list = model[position]

        holder.nama.text = list.nama
        holder.harga.text = list.tiket.toString()
        holder.lokasi.text = list.lokasi

        if (context != null) {
            Glide.with(context)
                .load(list.gambar)
                .centerCrop()
                .into(holder.gambar_holder)
        }

        var nama = list.nama
        var harga = list.tiket.toString()
        var lokasi = list.lokasi
        var keterangan = list.keterangan
        var gambar = list.gambar
        holder.item_list.setOnClickListener {
            val intent = Intent(context,DetailActivity::class.java)
            intent.putExtra("nama",nama)
            intent.putExtra("harga",harga)
            intent.putExtra("lokasi",lokasi)
            intent.putExtra("keterangan",keterangan)
            intent.putExtra("gambar",gambar)
            context.startActivity(intent)
        }

    }
    override fun getItemCount(): Int {
        return model.size
    }
}