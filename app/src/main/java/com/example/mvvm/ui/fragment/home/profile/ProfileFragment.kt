package com.example.mvvm.ui.fragment.home.profile

import android.content.Context
import android.content.SharedPreferences
import androidx.navigation.fragment.findNavController
import com.example.mvvm.NavGraphDirections
import com.example.mvvm.R
import com.example.mvvm.databinding.FragmentProfileBinding
import com.example.mvvm.module.UserInformation
import com.example.mvvm.ui.basefragment.BaseFragment
import com.squareup.picasso.Picasso

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_profile
    lateinit var sharedPreferences: SharedPreferences

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPreferences = activity?.getSharedPreferences("checklogined", Context.MODE_PRIVATE)!!
    }

    override fun initView() {
        getBack()
        toUpdateprofile()
        setInfor()
        logOut()
    }

    private fun logOut() {
        binding!!.dangxuat.setOnClickListener {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putBoolean("logined", false)
            editor.apply()

            findNavController().navigate(NavGraphDirections.actionToLoginFrag())
        }
    }

    private fun setInfor() {
        binding!!.profileName.text = UserInformation.fullname
        binding!!.profilePhone.text = UserInformation.phoneNumber
        Picasso.get().load(UserInformation.avatar).error(R.drawable.avatar).centerCrop().fit()
            .into(binding!!.profileAvatar)
    }

    private fun toUpdateprofile() {
        binding!!.toUpdateprofile.setOnClickListener {
            findNavController().navigate(NavGraphDirections.actionToUpdateProfile())
        }
    }

    private fun getBack() {
        binding!!.profileBack.setOnClickListener {
            findNavController().navigate(NavGraphDirections.actionToHomeFrag())
        }
    }
}