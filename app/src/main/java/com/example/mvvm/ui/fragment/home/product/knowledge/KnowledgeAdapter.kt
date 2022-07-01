package com.example.mvvm.ui.fragment.home.product.knowledge

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.R
import com.example.mvvm.module.KnowledgeRCV
import com.example.mvvm.ui.fragment.home.file.fragment.adapter.AnalysisAdapter

class KnowledgeAdapter(val knowledgeList: List<KnowledgeRCV>): RecyclerView.Adapter<KnowledgeAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image = itemView.findViewById<ImageView>(R.id.img)
        val title = itemView.findViewById<TextView>(R.id.title)
        val time = itemView.findViewById<TextView>(R.id.time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KnowledgeAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rcv_product_knowledge, parent, false)
        return KnowledgeAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: KnowledgeAdapter.ViewHolder, position: Int) {
        val knowledge = knowledgeList[position]
        holder.image.setImageResource(knowledge.image)
        holder.title.text = knowledge.title
        holder.time.text= knowledge.time
    }

    override fun getItemCount(): Int {
        return knowledgeList.size
    }
}