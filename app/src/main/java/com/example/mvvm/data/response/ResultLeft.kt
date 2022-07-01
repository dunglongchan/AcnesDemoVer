package com.example.mvvm.data.response

data class ResultLeft(
    val acne_box: List<List<Int>>,
    val acne_box_class: List<Int>,
    val grading: Int,
    val success: Boolean
)