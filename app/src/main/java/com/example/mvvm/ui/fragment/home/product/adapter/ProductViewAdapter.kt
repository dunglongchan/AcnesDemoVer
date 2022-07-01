package com.example.mvvm.ui.fragment.home.product.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mvvm.ui.fragment.home.file.fragment.analysis.AnalysisFrag
import com.example.mvvm.ui.fragment.home.file.fragment.survey.SurveyFrag
import com.example.mvvm.ui.fragment.home.product.knowledge.KnowledgeFragment
import com.example.mvvm.ui.fragment.home.product.productmenu.ProductMenuFrag
import com.example.mvvm.ui.fragment.home.product.service.ServiceFragment

class ProductViewAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return ProductMenuFrag()
            1 -> return ServiceFragment()
            2 -> return KnowledgeFragment()
            else -> return SurveyFrag()
        }
    }
}