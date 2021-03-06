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

        surveyList.add(Survey("1. ????? tu???i c???a b???n l?? g?? ?", imgq1))
        surveyList.add(
            Survey(
                "2. T??nh tr???ng da m???t b???n tr??ng th??? n??o v??o bu???i s??ng tr?????c khi r???a m???t v?? v??o l??c cu???i ng??y?",
                imgq2
            )
        )
        surveyList.add(Survey("3. Lo???i m???n n??o b???n th?????ng xuy??n g???p ph???i?", imgq3))
        surveyList.add(
            Survey(
                "4. Hi???n t???i ??i???u n??o m?? t??? ch??nh x??c nh???t v??? m???c ????? nghi??m tr???ng c???a m???n tr??n da c???a b???n?",
                imgq4
            )
        )
        surveyList.add(Survey("5. N???t m???n m???i th?????ng xu???t hi???n ?????u ?????n v??o?", imgq5))
        surveyList.add(
            Survey(
                "6. Ngo??i c??c v???n ????? v??? m???n, da b???n c??n g???p t??nh tr???ng g?? n???a kh??ng?",
                imgq6
            )
        )
        surveyList.add(
            Survey(
                "7. Hi???n gi??? ??i???u g?? l?? quan tr???ng nh???t v???i b???n khi l???a ch???n m???t s???n ph???m ch??m s??c da?",
                imgq7
            )
        )


        val adapter = SurvayAdapter(surveyList)
        rcv_survey.adapter = adapter
    }
}