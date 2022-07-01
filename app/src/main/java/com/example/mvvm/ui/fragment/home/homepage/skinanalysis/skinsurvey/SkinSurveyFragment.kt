package com.example.mvvm.ui.fragment.home.homepage.skinanalysis.skinsurvey

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.core.view.isGone
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm.NavGraphDirections
import com.example.mvvm.R
import com.example.mvvm.data.ApiInterface
import com.example.mvvm.data.response.FormSurveyResponse
import com.example.mvvm.data.response.Question
import com.example.mvvm.databinding.FragmentSkinanalysisSurveyBinding
import com.example.mvvm.module.UserInformation
import com.example.mvvm.ui.basefragment.BaseFragment
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Response

class SkinSurveyFragment : BaseFragment<FragmentSkinanalysisSurveyBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_skinanalysis_survey

    private val ssViewModel: SkinSurveyViewModel by viewModels()

    lateinit var adapter: SurveyFormAdapter

    override fun initView() {
        onClick()
        setInfor()
        getSurvey()
    }

    private fun getSurvey() {

        binding!!.rcvSurvey.layoutManager = LinearLayoutManager(context)

        val qsList = ArrayList<Question>()
        adapter = SurveyFormAdapter(qsList)

        val getSurveyForm = ApiInterface.create().getFormSUrvey()
        getSurveyForm.enqueue(object : retrofit2.Callback<FormSurveyResponse> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<FormSurveyResponse>,
                response: Response<FormSurveyResponse>
            ) {
                if (response.isSuccessful) {
                    for (i in response.body()?.data!!.indices) {
                        qsList.add(response.body()?.data!![i])
                        adapter.notifyDataSetChanged()
                        Log.e("ok", qsList.size.toString())
                    }

                } else {
                    Toast.makeText(
                        requireActivity(),
                        response.body()?.errors?.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<FormSurveyResponse>, t: Throwable) {
                Toast.makeText(requireActivity(), t.toString(), Toast.LENGTH_SHORT).show()
            }

        })

        Log.e("ok", qsList.size.toString())
        binding!!.rcvSurvey.adapter = adapter
    }



    private fun setInfor() {
        Picasso.get().load(UserInformation.avatar).error(R.drawable.avatar).centerCrop().fit()
            .into(binding!!.avatar)
        binding!!.name.text = UserInformation.fullname
        binding!!.birthday.text = UserInformation.birthday
        binding!!.sexual.text = UserInformation.sexual
        binding!!.homeaddress.text = UserInformation.address
        binding!!.phone.text = UserInformation.phoneNumber
        binding!!.mail.text = UserInformation.email
    }

    private fun onClick() {
        binding!!.skinanalysisBack.setOnClickListener {
            findNavController().navigate(NavGraphDirections.actionToSkinAnalysis())
        }

        binding!!.showprofile.setOnClickListener {
            if (ssViewModel.inforShowMode.value == false) {
                binding!!.showprofile.text = "arrow-down4"
                binding!!.userInformation.isGone = false
                ssViewModel.inforShowMode.value = true
            } else {
                binding!!.showprofile.text = "arrow-right4"
                binding!!.userInformation.isGone = true
                ssViewModel.inforShowMode.value = false
            }
        }

        binding!!.showsurvey.setOnClickListener {
            if (ssViewModel.surveyShowMode.value == false) {
                binding!!.showsurvey.text = "arrow-down4"
                binding!!.bottomSubmit.isGone = false
                binding!!.rcvSurvey.isGone = false
                ssViewModel.surveyShowMode.value = true
            } else {
                binding!!.showsurvey.text = "arrow-right4"
                binding!!.bottomSubmit.isGone = true
                binding!!.rcvSurvey.isGone = true
                ssViewModel.surveyShowMode.value = false
            }
        }

        binding!!.sendsurvey.setOnClickListener {

        }

    }
}