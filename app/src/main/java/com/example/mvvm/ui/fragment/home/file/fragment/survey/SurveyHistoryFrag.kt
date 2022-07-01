package com.example.mvvm.ui.fragment.home.file.fragment.survey

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm.R
import com.example.mvvm.module.Survey
import com.example.mvvm.module.SurveyHistory
import com.example.mvvm.ui.fragment.home.file.fragment.SurvayAdapter
import kotlinx.android.synthetic.main.fragment_survey_surveyhistory.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SurveyHistoryFrag : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_survey_surveyhistory, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

    }

    private fun initView() {

        rcv_survey.layoutManager = LinearLayoutManager(context)
        val surveyList: ArrayList<Survey> = ArrayList()

        var age = SurveyHistory.age
        var q2 = SurveyHistory.typeSkinQ2
        var q3 = SurveyHistory.acneSeverityQ3
        var q4 = SurveyHistory.acneFrequencyQ4
        var q5 = SurveyHistory.q5
        var q6 = SurveyHistory.skinConditionQ6
        var q7 = SurveyHistory.skinTargetQ7

        var imgq1 = 0
        var imgq2 = 0
        var imgq3 = 0
        var imgq4 = 0
        var imgq5 = 0
        var imgq6 = 0
        var imgq7 = 0

        when (age?.toInt()) {
            in 0..18 -> imgq1 = R.drawable.ss11
            in 18..25 -> imgq1 = R.drawable.ss12
            in 25..40 -> imgq1 = R.drawable.ss13
            else -> imgq1 = R.drawable.ss14
        }

        when (q2) {
            "1" -> imgq2 = R.drawable.ss21
            "2" -> imgq2 = R.drawable.ss22
            "3" -> imgq2 = R.drawable.ss23
            "4" -> imgq2 = R.drawable.ss23
            "5" -> imgq2 = R.drawable.ss23
            else -> imgq2 = R.drawable.temp
        }

        when (q3) {
            "1" -> imgq3 = R.drawable.ss31
            "2" -> imgq3 = R.drawable.ss32
            "3" -> imgq3 = R.drawable.ss33
            "4" -> imgq3 = R.drawable.ss34
            "5" -> imgq3 = R.drawable.ss35
            else -> imgq3 = R.drawable.temp
        }

        when (q4) {
            "1" -> imgq4 = R.drawable.ss41
            "2" -> imgq4 = R.drawable.ss42
            "3" -> imgq4 = R.drawable.ss43
            "4" -> imgq4 = R.drawable.ss44
            else -> imgq4 = R.drawable.temp
        }

        when (q6) {
            "1" -> imgq6 = R.drawable.ss51
            "2" -> imgq6 = R.drawable.ss52
            "3" -> imgq6 = R.drawable.ss53
            "4" -> imgq6 = R.drawable.ss54
            "5" -> imgq6 = R.drawable.ss55
            else -> imgq6 = R.drawable.temp
        }

        when (q5) {
            "1" -> imgq5 = R.drawable.calendar
            "2" -> imgq5 = R.drawable.calendar
            "3" -> imgq5 = R.drawable.calendar
            "4" -> imgq5 = R.drawable.calendar
            else -> imgq5 = R.drawable.temp
        }

        when (q7) {
            "1" -> imgq7 = R.drawable.ss71
            "2" -> imgq7 = R.drawable.ss72
            "3" -> imgq7 = R.drawable.ss73
            "4" -> imgq7 = R.drawable.ss74
            "5" -> imgq7 = R.drawable.ss75
            else -> imgq7 = R.drawable.temp
        }

        surveyList.add(Survey("1. Độ tuổi của bạn là gì ?", imgq1))
        surveyList.add(
            Survey(
                "2. Tình trạng da mặt bạn trông thế nào vào buổi sáng trước khi rửa mặt và vào lúc cuối ngày?",
                imgq2
            )
        )
        surveyList.add(Survey("3. Loại mụn nào bạn thường xuyên gặp phải?", imgq3))
        surveyList.add(
            Survey(
                "4. Hiện tại điều nào mô tả chính xác nhất về mức độ nghiêm trọng của mụn trên da của bạn?",
                imgq4
            )
        )
        surveyList.add(Survey("5. Nốt mụn mới thường xuất hiện đều đặn vào?", imgq5))
        surveyList.add(
            Survey(
                "6. Ngoài các vấn đề về mụn, da bạn còn gặp tình trạng gì nữa không?",
                imgq6
            )
        )
        surveyList.add(
            Survey(
                "7. Hiện giờ điều gì là quan trọng nhất với bạn khi lựa chọn một sản phẩm chăm sóc da?",
                imgq7
            )
        )


        val adapter = SurvayAdapter(surveyList)
        rcv_survey.adapter = adapter
    }
}