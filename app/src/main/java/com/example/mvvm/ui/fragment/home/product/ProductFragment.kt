package com.example.mvvm.ui.fragment.home.product

import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.mvvm.R
import com.example.mvvm.databinding.FragmentProductBinding
import com.example.mvvm.ui.basefragment.BaseFragment
import com.example.mvvm.ui.fragment.home.file.fragment.adapter.ViewPagerAdapter
import com.example.mvvm.ui.fragment.home.product.adapter.ProductViewAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ProductFragment: BaseFragment<FragmentProductBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_product
    private val productViewModel: ProductViewModel by viewModels()
    lateinit var viewPager2: ViewPager2
    lateinit var tabLayoutMediator: TabLayoutMediator

    override fun initView() {
        viewPager2 = binding!!.viewpager

        val adapter = this.activity?.let { ProductViewAdapter(it) }
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
                        tab.setText("SẢN PHẨM")
                    }
                    1 -> {
                        tab.setText("DỊCH VỤ")
                    }
                    2 -> {
                        tab.setText("KIẾN THỨC")
                    }
                }
            })
        tabLayoutMediator.attach()
    }
}