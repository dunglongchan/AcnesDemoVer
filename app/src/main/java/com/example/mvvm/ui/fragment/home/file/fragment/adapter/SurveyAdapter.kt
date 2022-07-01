package com.example.mvvm.ui.fragment.home.file.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.R
import com.example.mvvm.module.Survey

class SurvayAdapter (val surveylist: List<Survey>): RecyclerView.Adapter<SurvayAdapter.ViewHolder>() {
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){
        val cauhoi = itemView.findViewById<TextView?>(R.id.survey_cauhoi)
        val image = itemView.findViewById<ImageView?>(R.id.survey_image)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurvayAdapter.ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.profile_survey_rcv,parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val survey = surveylist[position]
        holder.cauhoi.text = survey.cauhoi
        holder.image.setImageResource(survey.image)
    }
    override fun getItemCount(): Int {
        return surveylist.size
    }
}