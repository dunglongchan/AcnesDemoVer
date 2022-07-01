package com.example.mvvm.ui.fragment.home.search

import android.os.Bundle
import com.example.mvvm.R
import com.example.mvvm.databinding.FragmentSearchingBinding
import com.example.mvvm.ui.basefragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_product.*

class SearchingFragment:BaseFragment<FragmentSearchingBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_searching

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun initView() {
        binding!!.searchBar.requestFocus()
    }
}