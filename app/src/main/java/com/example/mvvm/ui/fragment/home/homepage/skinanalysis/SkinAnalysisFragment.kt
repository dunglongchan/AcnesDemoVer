package com.example.mvvm.ui.fragment.home.homepage.skinanalysis

import androidx.navigation.fragment.findNavController
import com.example.mvvm.NavGraphDirections
import com.example.mvvm.R
import com.example.mvvm.databinding.FragmentMainhomeSkinanalysisBinding
import com.example.mvvm.ui.basefragment.BaseFragment

class SkinAnalysisFragment: BaseFragment<FragmentMainhomeSkinanalysisBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_mainhome_skinanalysis
    override fun initView() {
        onClick()
    }

    private fun onClick() {
        binding!!.skinanalysisBack.setOnClickListener {
            findNavController().navigate(NavGraphDirections.actionToHomeFrag())
        }
        binding!!.skinanalysisStart.setOnClickListener{
            findNavController().navigate(NavGraphDirections.actionToSkinSurvey())
        }
        binding!!.skinanalysisHistory.setOnClickListener{
            findNavController().navigate(NavGraphDirections.actionToSurveyHistory())
        }
    }
}