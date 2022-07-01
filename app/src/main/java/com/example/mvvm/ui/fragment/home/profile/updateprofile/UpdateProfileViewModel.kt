package com.example.mvvm.ui.fragment.home.profile.updateprofile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.coroutines.coroutineContext

class UpdateProfileViewModel: ViewModel() {
    val avatarChoosen = MutableLiveData<Int>()

}