package com.example.mvvm.ui.fragment.home.homepage

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.mvvm.NavGraphDirections
import com.example.mvvm.R
import com.example.mvvm.data.ApiInterface
import com.example.mvvm.data.response.InforResponse
import com.example.mvvm.databinding.FragmentMainHomeBinding
import com.example.mvvm.module.UserInformation
import com.example.mvvm.ui.basefragment.BaseFragment
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Response

class MainHomeFrag : BaseFragment<FragmentMainHomeBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_main_home
    lateinit var imageSlider: ImageSlider

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getUserData()
    }


    override fun initView() {
        imageSlider = binding!!.imgSlider
        setImageSlider()
        onClick()
    }

    private fun onClick() {
        binding!!.homepageToskinanalysis.setOnClickListener {
            findNavController().navigate(NavGraphDirections.actionToSkinAnalysis())
        }
    }

    private fun getUserData() {
        val getUserInfor = ApiInterface.create().getProfile()

        getUserInfor.enqueue(object : retrofit2.Callback<InforResponse> {
            override fun onResponse(call: Call<InforResponse>, response: Response<InforResponse>) {
                if (response.body()?.status == "success") {

                    UserInformation.userName = response.body()?.data?.userName
                    UserInformation.fullname = response.body()?.data?.fullName
                    UserInformation.avatar = response.body()?.data?.avatar
                    UserInformation.birthday = response.body()?.data?.birthday
                    if (response.body()?.data?.sex == 1) UserInformation.sexual =
                        "Male" else UserInformation.sexual = "Female"
                    UserInformation.email = response.body()?.data?.email.toString()
                    UserInformation.phoneNumber = response.body()?.data?.phoneNumber.toString()
                    UserInformation.address = response.body()?.data?.address

                    Log.e("ok", UserInformation.fullname +
                            UserInformation.avatar)
                    setInfor()
                } else {
                    findNavController().navigate(NavGraphDirections.actionToLoginFrag())
                }
            }

            override fun onFailure(call: Call<InforResponse>, t: Throwable) {
                Toast.makeText(requireActivity(), t.toString(), Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun setInfor() {
        binding!!.mainhomeName.text = UserInformation.fullname
        Picasso.get().load(UserInformation.avatar).error(R.drawable.avatar).centerCrop().fit().into(
            binding!!.mainhomeAvatar
        )
    }

    private fun setImageSlider() {
        val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTQ4o7lEbNkI_21r8bJY4SKbth2HS37HKgX0Q&usqp=CAU"))
        imageList.add(SlideModel("https://rohto.com.vn/images/tintuc/acnes-ra-mat-san-pham-moi.jpg"))
        imageList.add(SlideModel("https://vnwriter.net/wp-content/uploads/2018/12/sua-rua-mat-acnes-chinh-hang-780x405.png"))
        imageList.add(SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQf2tWPqskzNYeHD5mY26EbdYUYnB2nIZv0RQ&usqp=CAU"))

        imageSlider.setImageList(imageList, ScaleTypes.FIT)
    }
}



