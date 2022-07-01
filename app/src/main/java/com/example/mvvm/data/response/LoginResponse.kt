package com.example.mvvm.data.response

data class LoginResponse(
    val `data`: Data,
    val errors: List<Error>,
    val status: String
)