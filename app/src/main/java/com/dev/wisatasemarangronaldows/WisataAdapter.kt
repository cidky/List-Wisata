package com.dev.wisatasemarangronaldows

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WisataAdapter(private val wisataList: ArrayList<Wisata>)
    : RecyclerView.Adapter<WisataAdapter.WisataViewHolder>() {


    var onItemClick : ((Wisata) -> Unit)? = null

    class WisataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WisataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent, false)
        return WisataViewHolder(view)
    }

    override fun getItemCount(): Int {
        return wisataList.size
    }

    override fun onBindViewHolder(holder: WisataViewHolder, position: Int) {
        val wisata = wisataList[position]
        holder.imageView.setImageResource(wisata.image)
        holder.textView.text = wisata.name

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(wisata)
        }

    }
}
