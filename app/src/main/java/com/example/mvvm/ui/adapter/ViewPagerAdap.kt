package com.example.mvvm.ui.adapter

import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.Switch
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mvvm.ui.fragment.home.camera.CameraFragment
import com.example.mvvm.ui.fragment.home.file.FileFragment
import com.example.mvvm.ui.fragment.home.homepage.MainHomeFrag
import com.example.mvvm.ui.fragment.home.news.NewsFragment
import com.example.mvvm.ui.fragment.home.product.ProductFragment

class ViewPagerAdap(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return MainHomeFrag()
            1 -> return FileFragment()
            2 -> return CameraFragment()
            3 -> return ProductFragment()
            4 -> return NewsFragment()
            else -> return MainHomeFrag()
        }
    }

}