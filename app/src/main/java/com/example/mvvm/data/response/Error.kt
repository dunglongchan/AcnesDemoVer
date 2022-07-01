package com.example.mvvm.data.response

data class Error(
    val code: Int,
    val field: String,
    val message: String
)