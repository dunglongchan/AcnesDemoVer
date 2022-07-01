package com.example.mvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.R
import com.example.mvvm.module.News
import com.squareup.picasso.Picasso

class NewsAdapter(val newslist: ArrayList<News>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val image = itemView.findViewById<ImageView?>(R.id.news_image)
        val title = itemView.findViewById<TextView?>(R.id.news_title)
        val time = itemView.findViewById<TextView?>(R.id.news_time)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.news_recyclerview, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news = newslist[position]
        Picasso.get().load("https://qa-rohto-cmsapi.niw.com.vn/${news.image}")
            .error(R.drawable.img3).centerCrop().fit().into(holder.image)
        holder.title.text = news.title
        holder.time.text = news.createTime
    }

    override fun getItemCount(): Int {
        return newslist.size
    }


}