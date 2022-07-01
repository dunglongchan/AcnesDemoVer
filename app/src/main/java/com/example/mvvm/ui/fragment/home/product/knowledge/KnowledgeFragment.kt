package com.example.mvvm.ui.fragment.home.product.knowledge

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm.R
import com.example.mvvm.databinding.FragmentProductKnowledgeBinding
import com.example.mvvm.module.KnowledgeRCV
import com.example.mvvm.ui.basefragment.BaseFragment

class KnowledgeFragment : BaseFragment<FragmentProductKnowledgeBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_product_knowledge

    override fun initView() {
        getKnowledge()
    }

    private fun getKnowledge() {
        binding!!.rcvKnowledge.layoutManager = LinearLayoutManager(context)
        val knowledgeList: ArrayList<KnowledgeRCV> = ArrayList()

        knowledgeList.add(
            KnowledgeRCV(
                R.drawable.knowledge3,
                "9 phút mỗi ngày cho làn da “lão hoá ngược”, bạn tin không? ",
                "21/12/2020 08:54:17"
            )
        )
        knowledgeList.add(
            KnowledgeRCV(
                R.drawable.knowledge2,
                "Cách làm tẩy tế bào chết môi tại nhà cho đôi môi căng mọng",
                "21/12/2020 08:54:17"
            )
        )
        knowledgeList.add(
            KnowledgeRCV(
                R.drawable.knowledge1,
                "Tập thể dục giữ dáng đúng cách để có làn da khỏe đẹp  ",
                "21/12/2020 08:54:17"
            )
        )

        val adapter = KnowledgeAdapter(knowledgeList)
        binding!!.rcvKnowledge.adapter = adapter

    }
}