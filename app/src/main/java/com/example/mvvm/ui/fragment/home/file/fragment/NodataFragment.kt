package com.example.mvvm.ui.fragment.home.file.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mvvm.NavGraphDirections
import com.example.mvvm.R
import kotlinx.android.synthetic.main.fragment_nodata.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class NodataFragment : Fragment() {
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

        val rootview: View = inflater.inflate(R.layout.fragment_nodata,container,false)

        return rootview
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cardview.setOnClickListener {
            findNavController().navigate(NavGraphDirections.actionToLoginFrag())
        }
    }

}