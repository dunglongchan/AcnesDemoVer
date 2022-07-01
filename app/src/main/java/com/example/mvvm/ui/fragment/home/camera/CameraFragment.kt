package com.example.mvvm.ui.fragment.home.camera

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.mvvm.R
import com.example.mvvm.databinding.FragmentCameraBinding
import com.example.mvvm.ui.basefragment.BaseFragment

class CameraFragment: BaseFragment<FragmentCameraBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_camera
    lateinit var sharedPreferences: SharedPreferences

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPreferences = activity?.getSharedPreferences("checklogined", Context.MODE_PRIVATE)!!

        Log.e("ok","camera")
    }

    override fun initView() {
        binding!!.btn.setOnClickListener {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putBoolean("logined",false)
            editor.apply()
        }
    }
}