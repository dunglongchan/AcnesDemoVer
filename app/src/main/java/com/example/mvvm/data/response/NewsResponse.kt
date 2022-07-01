package com.example.mvvm.data.response



data class NewsResponse(
  val status: String,
  val data: List<New>,
  var error: Error
)

data class New(
    val listdetail: List<Detail>,
    val paging: Paging
)
data class Detail(
    val newId: Int,
    val title: Language,
    val statusShow: Boolean,
    val content: Language,
    var link: String,
    var type: String,
    var isLink: Boolean,
    var avatar: String,
    var createBy: Int,
    var createTime: String,
    var updateBy: String,
    var updateTime: String,
    var isDelete: Boolean
)
data class Language(
    var vi: String,
    var en: String
)

