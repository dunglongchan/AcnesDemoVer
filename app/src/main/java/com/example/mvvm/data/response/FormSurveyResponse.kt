package com.example.mvvm.data.response

data class FormSurveyResponse(
    val data: List<Question>,
    val errors: Error,
    val status: String
)