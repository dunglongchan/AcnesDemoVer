package com.example.mvvm.ui.fragment.home.file.fragment.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mvvm.ui.fragment.home.file.fragment.analysis.AnalysisFrag
import com.example.mvvm.ui.fragment.home.file.fragment.survey.SurveyFrag

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return SurveyFrag()
            1 -> return AnalysisFrag()
            else -> return SurveyFrag()
        }
    }
}