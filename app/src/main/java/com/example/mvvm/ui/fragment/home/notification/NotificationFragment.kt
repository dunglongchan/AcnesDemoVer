package com.example.mvvm.ui.fragment.home.notification

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm.NavGraphDirections
import com.example.mvvm.R
import com.example.mvvm.data.ApiInterface
import com.example.mvvm.data.body.NotifyBody
import com.example.mvvm.data.response.NotifyResponse
import com.example.mvvm.databinding.FragmentNotificationBinding
import com.example.mvvm.module.Notification
import com.example.mvvm.ui.basefragment.BaseFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NotificationFragment : BaseFragment<FragmentNotificationBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_notification
    lateinit var adapter: NotifyAdapter
    var size: Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getNotification()
    }

    private fun getNotification() {
        binding!!.rcvNotify.layoutManager = LinearLayoutManager(context)

        val notifyList = ArrayList<Notification>()
        adapter = NotifyAdapter(notifyList)

        val getNotify = ApiInterface.create().getNotification(NotifyBody("", "", 1, 10, ""))

        getNotify.enqueue(object : Callback<NotifyResponse> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<NotifyResponse>,
                response: Response<NotifyResponse>
            ) {
                if(response.body()?.status=="success"){
                    size = response.body()?.data!!.list.size
                    for (i in response.body()!!.data!!.list.indices) {
                        val title: String = response.body()?.data!!.list[i].title
                        val content: String = response.body()?.data!!.list[i].content
                        val icon: String = response.body()?.data!!.list[i].icon
                        val createTime: String = response.body()?.data!!.list[i].createTime

                        notifyList.add(Notification(title, icon, content, createTime))

                        adapter.notifyDataSetChanged()

                        Log.e("ok","https://qa-rohto-cmsapi.niw.com.vn/${icon}")
                    }
                }else{
                    findNavController().navigate(NavGraphDirections.actionToLoginFrag())
                }

            }

            override fun onFailure(call: Call<NotifyResponse>, t: Throwable) {
                Toast.makeText(requireActivity(), t.toString(), Toast.LENGTH_SHORT).show()
            }

        })

        binding!!.rcvNotify.adapter = adapter
    }

    override fun initView() {
        getback()
    }

    private fun getback() {
        binding!!.notifyBack.setOnClickListener {
            findNavController().navigate(NavGraphDirections.actionToHomeFrag())
        }
    }
}