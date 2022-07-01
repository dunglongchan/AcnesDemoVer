package com.example.mvvm.ui.fragment.home

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.isGone
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.mvvm.NavGraphDirections
import com.example.mvvm.R
import com.example.mvvm.data.ApiInterface
import com.example.mvvm.data.response.InforResponse
import com.example.mvvm.databinding.FragmentHomepageBinding
import com.example.mvvm.module.UserInformation
import com.example.mvvm.ui.adapter.ViewPagerAdap
import com.example.mvvm.ui.basefragment.BaseFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Response


class HomeFragment : BaseFragment<FragmentHomepageBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_homepage
    private val homeViewModel: HomeViewModel by viewModels()
    lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    override fun initView() {
        viewPager = binding!!.viewpager
        binding!!.homeVM = homeViewModel

        val adapter = this.activity?.let { ViewPagerAdap(it) }
        viewPager.adapter = adapter
        viewPager.offscreenPageLimit = 4

        viewPager.addListener()
        binding!!.taskBar.addListener()

        topbarlistener()
    }

    private fun topbarlistener() {
        binding!!.homepageSearch.setOnClickListener {
            binding!!.menuBar.isGone = true
            binding!!.searching.isGone = false
        }
        binding!!.searchingBack.setOnClickListener {
            binding!!.menuBar.isGone = false
            binding!!.searching.isGone = true
        }
        binding!!.homepageProfile.setOnClickListener {
            findNavController().navigate(NavGraphDirections.actionToProfile())
        }
        binding!!.homepageNotify.setOnClickListener {
            findNavController().navigate(NavGraphDirections.actionToNotify())
        }

    }

    private fun ViewPager2.addListener() {
        registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> {
                        binding!!.searching.isGone = true
                        binding!!.menuBar.isGone = false
                        binding!!.taskBar.menu.findItem(R.id.action_home).setChecked(true)
                    }
                    1 -> {
                        binding!!.searching.isGone = true
                        binding!!.menuBar.isGone = false
                        binding!!.taskBar.menu.findItem(R.id.action_file).setChecked(true)
                    }
                    2 -> {
                        binding!!.searching.isGone = true
                        binding!!.menuBar.isGone = false
                        binding!!.taskBar.menu.findItem(R.id.action_camera).setChecked(true)
                    }
                    3 -> {
                        binding!!.searching.isGone = true
                        binding!!.menuBar.isGone = true
                        binding!!.taskBar.menu.findItem(R.id.action_product).setChecked(true)
                    }
                    4 -> {
                        binding!!.searching.isGone = true
                        binding!!.menuBar.isGone = false
                        binding!!.taskBar.menu.findItem(R.id.action_news).setChecked(true)
                    }
                }
            }
        })
    }

    private fun BottomNavigationView.addListener() {
        setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_home -> {
                    viewPager.currentItem = 0
                    true
                }
                R.id.action_file -> {
                    viewPager.currentItem = 1
                    true
                }
                R.id.action_camera -> {
                    viewPager.currentItem = 2
                    true
                }
                R.id.action_product -> {
                    viewPager.currentItem = 3
                    true
                }
                R.id.action_news -> {
                    viewPager.currentItem = 4
                    true
                }

                else -> false
            }
        }
    }
}
















