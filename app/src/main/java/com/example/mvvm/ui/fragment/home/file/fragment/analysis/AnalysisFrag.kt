package com.example.mvvm.ui.fragment.home.file.fragment.analysis

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.example.mvvm.R
import com.example.mvvm.data.ApiInterface
import com.example.mvvm.data.response.AnalysisHistory
import com.example.mvvm.data.response.SurveySkinHistory
import com.example.mvvm.databinding.FragmentFileAnalysisBinding
import com.example.mvvm.module.SurveyHistory
import com.example.mvvm.ui.basefragment.BaseFragment
import com.example.mvvm.ui.fragment.home.file.fragment.NodataFragment
import com.example.mvvm.ui.fragment.home.file.fragment.survey.SurveyHistoryFrag
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnalysisFrag: BaseFragment<FragmentFileAnalysisBinding>(){
    override val layoutId: Int
        get() = R.layout.fragment_file_analysis

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getData()
    }

    private fun getData() {
        val getAnalysisData = ApiInterface.create().getAnalysisHistory()
        getAnalysisData.enqueue(object : Callback<AnalysisHistory> {
            override fun onResponse(
                call: Call<AnalysisHistory>,
                response: Response<AnalysisHistory>
            ) {
                val transaction: FragmentTransaction =
                    requireActivity().supportFragmentManager.beginTransaction()

                if (response.body()?.status == "success") {

                    SurveyHistory.imgtrai = response.body()?.data?.imageLeft.toString()
                    SurveyHistory.imggiua = response.body()?.data?.imageMid.toString()
                    SurveyHistory.imgphai = response.body()?.data?.imageRight.toString()

                    SurveyHistory.time = response.body()?.data?.createTime.toString()

                    val analysisHistory = AnalysisHistoryFrag()
                    transaction.replace(R.id.analysis_frag,analysisHistory )
                    transaction.addToBackStack(null)
                    transaction.commit()
                } else {
                    val nodataFragment = NodataFragment()
                    transaction.replace(R.id.analysis_frag, nodataFragment)
                    transaction.addToBackStack(null)
                    transaction.commit()
                }
            }

            override fun onFailure(call: Call<AnalysisHistory>, t: Throwable) {
                Toast.makeText(requireActivity(), t.toString(), Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun initView() {
        binding!!.createTime.text=SurveyHistory.time
    }
}