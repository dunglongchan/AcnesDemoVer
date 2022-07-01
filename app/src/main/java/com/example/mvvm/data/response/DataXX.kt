package com.example.mvvm.data.response

data class DataXX(
    val analysisId: Int,
    val code: Any,
    val createBy: Int,
    val createTime: String,
    val imageLeft: String,
    val imageMid: String,
    val imageRight: String,
    val isDelete: Boolean,
    val resultLeft: ResultLeft,
    val resultMid: ResultMid,
    val resultRight: ResultRight,
    val status: Int,
    val updateBy: Int,
    val updateTime: String
)