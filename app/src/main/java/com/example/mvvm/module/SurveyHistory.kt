package com.example.mvvm.module


interface SurveyHistory {
    companion object {
        var time: String? =""

        var age: String? = ""
        var typeSkinQ2: String? = ""
        var acneSeverityQ3: String? = ""
        var acneFrequencyQ4: String? = ""
        var q5: String? = ""
        var skinConditionQ6: String? = ""
        var skinTargetQ7: String? = ""

        //analysis

        var imgtrai: String=""
        var imggiua: String=""
        var imgphai: String=""
    }
}