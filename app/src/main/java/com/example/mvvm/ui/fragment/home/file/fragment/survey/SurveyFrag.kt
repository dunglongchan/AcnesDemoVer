package com.example.mvvm.ui.fragment.home.file.fragment.survey

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.example.mvvm.R
import com.example.mvvm.data.ApiInterface
import com.example.mvvm.data.response.SurveySkinHistory
import com.example.mvvm.databinding.FragmentFileSurveyBinding
import com.example.mvvm.module.SurveyHistory
import com.example.mvvm.ui.basefragment.BaseFragment
import com.example.mvvm.ui.fragment.home.file.fragment.NodataFragment
import kotlinx.android.synthetic.main.fragment_file_survey.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SurveyFrag : BaseFragment<FragmentFileSurveyBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_file_survey

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getData()
    }


    override fun initView() {
        binding!!.createTime.text=SurveyHistory.time
        Log.e("ok",SurveyHistory.time.toString())
    }

    private fun getData() {
        val getSurveyData = ApiInterface.create().getInforSurvey()
        getSurveyData.enqueue(object : Callback<SurveySkinHistory> {
            override fun onResponse(
                call: Call<SurveySkinHistory>,
                response: Response<SurveySkinHistory>
            ) {
                val transaction: FragmentTransaction =
                    requireActivity().supportFragmentManager.beginTransaction()

                if (response.body()?.status == "success") {


                    SurveyHistory.age = response.body()?.data?.age
                    SurveyHistory.typeSkinQ2 = response.body()?.data?.typeSkin
                    SurveyHistory.acneSeverityQ3 = response.body()?.data?.acneSeverity
                    SurveyHistory.acneFrequencyQ4 = response.body()?.data?.acneFrequency
                    SurveyHistory.q5 = ""
                    SurveyHistory.skinConditionQ6 = response.body()?.data?.skinCondition
                    SurveyHistory.skinTargetQ7 = response.body()?.data?.skinTarget


                    val surveyHistoryFrag = SurveyHistoryFrag()
                    transaction.replace(R.id.survey_frag, surveyHistoryFrag)
                    transaction.addToBackStack(null)
                    transaction.commit()

                    SurveyHistory.time = response.body()?.data?.createTime.toString()

                    createTime.text = response.body()?.data?.createTime
                } else {
                    val nodataFragment = NodataFragment()
                    transaction.replace(R.id.survey_frag, nodataFragment)
                    transaction.addToBackStack(null)
                    transaction.commit()
                }
            }

            override fun onFailure(call: Call<SurveySkinHistory>, t: Throwable) {
                Toast.makeText(requireActivity(), t.toString(), Toast.LENGTH_SHORT).show()
            }
        })
    }

}