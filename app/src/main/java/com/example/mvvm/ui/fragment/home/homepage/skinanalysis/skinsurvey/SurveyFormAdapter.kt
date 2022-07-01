package com.example.mvvm.ui.fragment.home.homepage.skinanalysis.skinsurvey

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.R
import com.example.mvvm.data.response.Question

class SurveyFormAdapter(val qsForm: ArrayList<Question>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ViewHolder2(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val cauhoi = itemView.findViewById<TextView>(R.id.vh2_question)

        val img1 = itemView.findViewById<ImageView>(R.id.vh2_img1)
        val content1 = itemView.findViewById<TextView>(R.id.vh2_content1)

        val img2 = itemView.findViewById<ImageView>(R.id.vh2_img2)
        val content2 = itemView.findViewById<TextView>(R.id.vh2_content2)

    }

    class ViewHolder3(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val cauhoi = itemView.findViewById<TextView>(R.id.vh3_question)

        val img1 = itemView.findViewById<ImageView>(R.id.vh3_img1)
        val content1 = itemView.findViewById<TextView>(R.id.vh3_content1)

        val img2 = itemView.findViewById<ImageView>(R.id.vh3_img2)
        val content2 = itemView.findViewById<TextView>(R.id.vh3_content2)

        val img3 = itemView.findViewById<ImageView>(R.id.vh3_img3)
        val content3 = itemView.findViewById<TextView>(R.id.vh3_content3)


    }

    class ViewHolder4(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val cauhoi = itemView.findViewById<TextView>(R.id.vh4_question)

        val img1 = itemView.findViewById<ImageView>(R.id.vh4_img1)
        val content1 = itemView.findViewById<TextView>(R.id.vh4_content1)

        val img2 = itemView.findViewById<ImageView>(R.id.vh4_img2)
        val content2 = itemView.findViewById<TextView>(R.id.vh4_content2)

        val img3 = itemView.findViewById<ImageView>(R.id.vh4_img3)
        val content3 = itemView.findViewById<TextView>(R.id.vh4_content3)

        val img4 = itemView.findViewById<ImageView>(R.id.vh4_img4)
        val content4 = itemView.findViewById<TextView>(R.id.vh4_content4)


    }

    class ViewHolder5(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val cauhoi = itemView.findViewById<TextView>(R.id.vh5_question)

        val img1 = itemView.findViewById<ImageView>(R.id.vh5_img1)
        val content1 = itemView.findViewById<TextView>(R.id.vh5_content1)

        val img2 = itemView.findViewById<ImageView>(R.id.vh5_img2)
        val content2 = itemView.findViewById<TextView>(R.id.vh5_content2)

        val img3 = itemView.findViewById<ImageView>(R.id.vh5_img3)
        val content3 = itemView.findViewById<TextView>(R.id.vh5_content3)

        val img4 = itemView.findViewById<ImageView>(R.id.vh5_img4)
        val content4 = itemView.findViewById<TextView>(R.id.vh5_content4)

        val img5 = itemView.findViewById<ImageView>(R.id.vh5_img5)
        val content5 = itemView.findViewById<TextView>(R.id.vh5_content5)


    }

    class ViewHolder6(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val cauhoi = itemView.findViewById<TextView>(R.id.question)

        val img1 = itemView.findViewById<ImageView>(R.id.img1)
        val content1 = itemView.findViewById<TextView>(R.id.content1)

        val img2 = itemView.findViewById<ImageView>(R.id.img2)
        val content2 = itemView.findViewById<TextView>(R.id.content2)

        val img3 = itemView.findViewById<ImageView>(R.id.img3)
        val content3 = itemView.findViewById<TextView>(R.id.content3)

        val img4 = itemView.findViewById<ImageView>(R.id.img4)
        val content4 = itemView.findViewById<TextView>(R.id.content4)

        val img5 = itemView.findViewById<ImageView>(R.id.img5)
        val content5 = itemView.findViewById<TextView>(R.id.content5)

        val img6 = itemView.findViewById<ImageView>(R.id.img6)
        val content6 = itemView.findViewById<TextView>(R.id.content6)

    }

    override fun getItemViewType(position: Int): Int {
        return qsForm[position].formOptions.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.rcv_surveyform, parent, false)
        when (viewType) {
            2 -> return ViewHolder2(
                LayoutInflater.from(parent.context).inflate(R.layout.rcv_surveyform2, parent, false)
            )
            3 -> return ViewHolder3(
                LayoutInflater.from(parent.context).inflate(R.layout.rcv_surveyform3, parent, false)
            )
            4 -> return ViewHolder4(
                LayoutInflater.from(parent.context).inflate(R.layout.rcv_surveyform4, parent, false)
            )
            5 -> return ViewHolder5(
                LayoutInflater.from(parent.context).inflate(R.layout.rcv_surveyform5, parent, false)
            )
            6 -> return ViewHolder6(
                LayoutInflater.from(parent.context).inflate(R.layout.rcv_surveyform, parent, false)
            )
            else -> return ViewHolder2(
                LayoutInflater.from(parent.context).inflate(R.layout.rcv_surveyform2, parent, false)
            )
        }
    }

    override fun getItemCount(): Int {
        return qsForm.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val question = qsForm[position]

        when (holder.itemViewType) {
            2 -> {
                val tmpholder = holder as ViewHolder2

                tmpholder.cauhoi.text = question.formSelectId.toString() + ". " + question.name
                tmpholder.content1.text = question.formOptions[0].content.vi
                tmpholder.content2.text = question.formOptions[1].content.vi
                tmpholder.img1.setImageResource(R.drawable.ss21)
                tmpholder.img2.setImageResource(R.drawable.ss22)
            }
            3 -> {
                val tmpholder = holder as ViewHolder3

                tmpholder.cauhoi.text = question.formSelectId.toString() + ". " + question.name
                tmpholder.content1.text = question.formOptions[0].content.vi
                tmpholder.content2.text = question.formOptions[1].content.vi
                tmpholder.content3.text = question.formOptions[2].content.vi

                tmpholder.img1.setImageResource(R.drawable.ss21)
                tmpholder.img2.setImageResource(R.drawable.ss22)
                tmpholder.img3.setImageResource(R.drawable.ss23)

            }
            4 -> {
                val tmpholder = holder as ViewHolder4

                tmpholder.cauhoi.text = question.formSelectId.toString() + ". " + question.name
                tmpholder.content1.text = question.formOptions[0].content.vi
                tmpholder.content2.text = question.formOptions[1].content.vi
                tmpholder.content3.text = question.formOptions[2].content.vi
                tmpholder.content4.text = question.formOptions[3].content.vi

                tmpholder.img1.setImageResource(R.drawable.ss21)
                tmpholder.img2.setImageResource(R.drawable.ss22)
                tmpholder.img3.setImageResource(R.drawable.ss23)
                tmpholder.img4.setImageResource(R.drawable.ss34)

            }
            5 -> {
                val tmpholder = holder as ViewHolder5

                tmpholder.cauhoi.text = question.formSelectId.toString() + ". " + question.name
                tmpholder.content1.text = question.formOptions[0].content.vi
                tmpholder.content2.text = question.formOptions[1].content.vi
                tmpholder.content3.text = question.formOptions[2].content.vi
                tmpholder.content4.text = question.formOptions[3].content.vi
                tmpholder.content5.text = question.formOptions[4].content.vi

                tmpholder.img1.setImageResource(R.drawable.ss31)
                tmpholder.img2.setImageResource(R.drawable.ss32)
                tmpholder.img3.setImageResource(R.drawable.ss33)
                tmpholder.img4.setImageResource(R.drawable.ss34)
                tmpholder.img5.setImageResource(R.drawable.ss35)

            }
            6 -> {
                val tmpholder = holder as ViewHolder6

                tmpholder.cauhoi.text = question.name
                tmpholder.content1.text = question.formOptions[0].content.vi
                tmpholder.content2.text = question.formOptions[1].content.vi
                tmpholder.content3.text = question.formOptions[2].content.vi
                tmpholder.content4.text = question.formOptions[3].content.vi
                tmpholder.content5.text = question.formOptions[4].content.vi
                tmpholder.content6.text = question.formOptions[5].content.vi

                tmpholder.img1.setImageResource(R.drawable.ss21)
                tmpholder.img2.setImageResource(R.drawable.ss31)
                tmpholder.img3.setImageResource(R.drawable.ss32)
                tmpholder.img4.setImageResource(R.drawable.ss33)
                tmpholder.img5.setImageResource(R.drawable.ss34)
                tmpholder.img6.setImageResource(R.drawable.ss35)

            }
            else -> {
                val tmpholder = holder as ViewHolder6

                tmpholder.cauhoi.text = question.name
                tmpholder.content1.text = question.formOptions[0].content.vi
                tmpholder.content2.text = question.formOptions[1].content.vi
                tmpholder.content3.text = question.formOptions[2].content.vi
                tmpholder.content4.text = question.formOptions[3].content.vi
                tmpholder.content5.text = question.formOptions[4].content.vi
                tmpholder.content6.text = question.formOptions[5].content.vi

                tmpholder.img1.setImageResource(R.drawable.ss21)
                tmpholder.img2.setImageResource(R.drawable.ss31)
                tmpholder.img3.setImageResource(R.drawable.ss32)
                tmpholder.img4.setImageResource(R.drawable.ss33)
                tmpholder.img5.setImageResource(R.drawable.ss34)
                tmpholder.img6.setImageResource(R.drawable.ss35)

            }
        }
    }
}