package com.example.mvvm.ui.fragment.home.profile.updateprofile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvvm.R
import com.example.mvvm.module.UpdateInforChange
import com.example.mvvm.module.UserInformation
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.gender_bottomsheetfrag.*

class SetGenderBottomSheetFrag( val gender: UpdateInforChange): BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.gender_bottomsheetfrag,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pickfemale.setOnClickListener {
            gender.getGender(0)
            dismiss()
        }
        pickmale.setOnClickListener {
            gender.getGender(1)
            dismiss()
        }
    }
}