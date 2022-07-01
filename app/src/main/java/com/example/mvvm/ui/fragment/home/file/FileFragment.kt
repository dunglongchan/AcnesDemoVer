package com.example.mvvm.ui.fragment.home.file

import android.content.Context
import android.util.Log
import androidx.viewpager2.widget.ViewPager2
import com.example.mvvm.R
import com.example.mvvm.databinding.FragmentFileBinding
import com.example.mvvm.ui.basefragment.BaseFragment
import com.example.mvvm.ui.fragment.home.file.fragment.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class FileFragment : BaseFragment<FragmentFileBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_file
    lateinit var viewPager2: ViewPager2
    lateinit var tabLayoutMediator: TabLayoutMediator

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("ok", "file")
    }

    override fun initView() {
        viewPager2 = binding!!.viewpager

        val adapter = this.activity?.let { ViewPagerAdapter(it) }
        viewPager2.adapter = adapter

        setTablayoutMediator()

    }
    private fun setTablayoutMediator() {
        this.tabLayoutMediator = TabLayoutMediator(
            binding!!.tablayout,
            viewPager2,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when (position) {
                    0 -> {
                        tab.setText("Survey")
                    }
                    1 -> {
                        tab.setText("Analysis")
                    }
                }
            })
        tabLayoutMediator.attach()
    }


}