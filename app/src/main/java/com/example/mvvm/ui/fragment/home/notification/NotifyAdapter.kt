package com.example.mvvm.ui.fragment.home.notification

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.R
import com.example.mvvm.module.Notification
import com.squareup.picasso.Picasso

class NotifyAdapter(val notifiList: List<Notification>) :
    RecyclerView.Adapter<NotifyAdapter.ViewHolder>() {
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val title = itemView.findViewById<TextView?>(R.id.notifi_sothutu)
        val noidung = itemView.findViewById<TextView?>(R.id.notifi_noidung)
        val image = itemView.findViewById<ImageView?>(R.id.nottifi_icon)
        val time = itemView.findViewById<TextView?>(R.id.notifi_time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.notifi_layoutcard, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val notifi = notifiList[position]
        holder.title.text = notifi.title
        Picasso.get().load("https://qa-rohto-cmsapi.niw.com.vn/${notifi.icon}").error(R.drawable.new1).centerCrop().fit().into(holder.image)
        holder.noidung.text = notifi.noidung
        holder.time.text = notifi.time
    }

    override fun getItemCount(): Int {
        return notifiList.size
    }
}

