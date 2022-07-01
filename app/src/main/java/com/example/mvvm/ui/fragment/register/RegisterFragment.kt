package com.example.mvvm.ui.fragment.register

import android.os.Bundle
import com.example.mvvm.R
import com.example.mvvm.databinding.FragmentRegisterBinding
import com.example.mvvm.ui.basefragment.BaseFragment

class RegisterFragment :BaseFragment<FragmentRegisterBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_register

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun initView() {

    }
}