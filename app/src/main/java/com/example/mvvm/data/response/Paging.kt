package com.example.mvvm.data.response

data class Paging(
    val pageIndex: Int,
    val pageSize: Int,
    val totalPage: Int,
    val totalRecords: Int
)