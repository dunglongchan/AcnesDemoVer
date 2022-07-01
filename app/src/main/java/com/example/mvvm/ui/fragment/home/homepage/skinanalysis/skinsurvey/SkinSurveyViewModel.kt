package com.example.mvvm.ui.fragment.home.homepage.skinanalysis.skinsurvey

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SkinSurveyViewModel : ViewModel() {
    val surveyShowMode = MutableLiveData<Boolean>()
    val inforShowMode = MutableLiveData<Boolean>()

    init {
        surveyShowMode.value = true
        inforShowMode.value = false
    }
}