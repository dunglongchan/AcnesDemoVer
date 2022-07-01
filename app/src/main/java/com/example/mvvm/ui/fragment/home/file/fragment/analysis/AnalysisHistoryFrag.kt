package com.example.mvvm.ui.fragment.home.file.fragment.analysis

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm.R
import com.example.mvvm.module.AnalysisProduct
import com.example.mvvm.module.SurveyHistory
import com.example.mvvm.ui.fragment.home.file.fragment.adapter.AnalysisAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_analysis_history.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AnalysisHistoryFrag : Fragment() {
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
        return inflater.inflate(R.layout.fragment_analysis_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {

        Picasso.get().load(SurveyHistory.imgtrai).error(R.drawable.surveypic1).centerCrop().fit().into(imgtrai)
        Picasso.get().load(SurveyHistory.imggiua).error(R.drawable.surveypic2).centerCrop().fit().into(imggiua)
        Picasso.get().load(SurveyHistory.imgphai).error(R.drawable.surveypic3).centerCrop().fit().into(imgphai)

        rcvprofileproduct.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        val products: ArrayList<AnalysisProduct> = ArrayList()

        products.add(
            AnalysisProduct(
                R.drawable.product1,
                "Gel chuyên biệt \nsáng thâm, mờ sẹ...",
                "70.000 Đồng / 10g"
            )
        )
        products.add(
            AnalysisProduct(
                R.drawable.product2,
                "Miếng dán mụn -\n Acnes Clear Patch",
                "58.000 Đồng / Hộp 24"
            )
        )
        products.add(AnalysisProduct(R.drawable.product3, "Miếng dán mụn -\n Acnes Clear Patch", "91.000"))
        products.add(
            AnalysisProduct(
                R.drawable.product1,
                "Gel chuyên biệt \nsáng thâm, mờ sẹ...",
                "70.000 Đồng / 10g"
            )
        )
        products.add(
            AnalysisProduct(
                R.drawable.product2,
                "Miếng dán mụn -\n Acnes Clear Patch",
                "58.000 Đồng / Hộp 24"
            )
        )
        products.add(AnalysisProduct(R.drawable.product3, "Miếng dán mụn -\n Acnes Clear Patch", "91.000"))

        val adapter = AnalysisAdapter(products)
        rcvprofileproduct.adapter = adapter
    }

}