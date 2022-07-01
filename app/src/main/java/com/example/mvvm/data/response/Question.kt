package com.example.mvvm.data.response

data class Question(
    val code: String,
    val formOptions: List<FormOption>,
    val formSelectId: Int,
    val isDelete: Boolean,
    val name: String
)
