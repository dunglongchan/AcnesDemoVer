package com.example.mvvm.ui.fragment.waiting

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.mvvm.NavGraphDirections
import com.example.mvvm.R
import com.example.mvvm.data.ApiInterface
import com.example.mvvm.data.body.LoginBody
import com.example.mvvm.data.response.LoginResponse
import com.example.mvvm.databinding.FragmentWaitingBinding
import com.example.mvvm.ui.basefragment.BaseFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WaitingFragment : BaseFragment<FragmentWaitingBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_waiting
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //checklogin()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
            checklogin()
        }, 500)

        //findNavController().navigate(NavGraphDirections.actionToLoginFrag())

    }

    override fun initView() {
    }


    private fun checklogin() {
        sharedPreferences = activity?.getSharedPreferences("checklogined", MODE_PRIVATE)!!
        if (sharedPreferences.getBoolean("logined", false)) {

            val userName: String = sharedPreferences.getString("username", "")!!
            val passWord: String = sharedPreferences.getString("password", "")!!

            val login = ApiInterface.create().postlogin(LoginBody(userName, passWord))
            login.enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.body()?.status == "success") {
                        ApiInterface.accessToken = response.body()?.data?.accessToken
                        findNavController().navigate(NavGraphDirections.actionToHomeFrag())
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(requireContext(), t.toString(), Toast.LENGTH_SHORT).show()
                    findNavController().navigate(NavGraphDirections.actionToLoginFrag())
                }
            })
        } else {
            findNavController().navigate(NavGraphDirections.actionToLoginFrag())
        }
    }
}

