package com.example.mvvm.ui.fragment.home.profile.updateprofile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.mvvm.R
import com.example.mvvm.module.UpdateInforChange
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottomsheet_setavatar_frag.*

class SetAvatarBottomSheetFrag(val choosen: UpdateInforChange) : BottomSheetDialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottomsheet_setavatar_frag, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onChoosen()
    }

    private fun onChoosen() {

        txtgallery.setOnClickListener {
            choosen.choosePicture(0)
            dismiss()
        }
        txtcamera.setOnClickListener {
            choosen.choosePicture(1)
            dismiss()
        }
    }


}