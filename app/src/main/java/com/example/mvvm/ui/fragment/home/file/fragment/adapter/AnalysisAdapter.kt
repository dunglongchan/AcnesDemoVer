package com.example.mvvm.ui.fragment.home.file.fragment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.R
import com.example.mvvm.module.AnalysisProduct

class AnalysisAdapter( val productlist: List<AnalysisProduct>): RecyclerView.Adapter<AnalysisAdapter.ViewHolder>() {
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val image = itemView.findViewById<ImageView>(R.id.profile_productimage)
        val name = itemView.findViewById<TextView>(R.id.profile_productname)
        val price = itemView.findViewById<TextView>(R.id.profile_productprice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.profile_productsuggest_rcv, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = productlist[position]
        holder.image.setImageResource(product.image)
        holder.name.text = product.name
        holder.price.text= product.price
    }

    override fun getItemCount(): Int {
        return productlist.size
    }
}