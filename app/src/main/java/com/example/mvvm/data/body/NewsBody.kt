package com.example.mvvm.data.body

data class NewsBody(
    val direction: String,
    val keyword: String,
    val pageIndex: Int,
    val pageSize: Int,
    val sort: String
)