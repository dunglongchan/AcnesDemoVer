package com.example.mvvm.ui.fragment.home.profile.updateprofile

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.example.mvvm.R
import com.example.mvvm.module.UpdateInforChange
import com.example.mvvm.module.UserInformation
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.datepicker_fragment.*
import kotlinx.android.synthetic.main.fragment_profile_updateinfor.*
import kotlinx.android.synthetic.main.fragment_profile_updateinfor.submit

class DatepickerFrag(val date: UpdateInforChange) : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.datepicker_fragment, container, false)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        submit.setOnClickListener {
            date.getBirthday(datepicker.year,datepicker.month,datepicker.dayOfMonth)
            //Toast.makeText(context,"selected: "+datepicker.year+datepicker.month+(datepicker.dayOfMonth+1),Toast.LENGTH_SHORT).show()
            dismiss()
        }

    }
}