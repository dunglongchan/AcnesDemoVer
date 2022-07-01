package com.example.mvvm.ui.fragment.home.news

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mvvm.R
import com.example.mvvm.adapter.NewsAdapter
import com.example.mvvm.data.ApiInterface
import com.example.mvvm.data.body.NewsBody
import com.example.mvvm.data.test.test
import com.example.mvvm.databinding.FragmentNewsmenuBinding
import com.example.mvvm.module.News
import com.example.mvvm.ui.basefragment.BaseFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsFragment : BaseFragment<FragmentNewsmenuBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_newsmenu
    private val newsViewModel: NewsViewModel by viewModels()
    lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getNewsMenu()
    }

    override fun initView() {
        binding!!.newsVM = newsViewModel
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("ok", "news")
    }

    private fun getNewsMenu() {
        binding!!.rcvNews.apply {
            layoutManager = GridLayoutManager(context, 2)
        }

        val newslist: ArrayList<News> = ArrayList()
        adapter = NewsAdapter(newslist)

        val newsbody = NewsBody("", "", 1, 10, "")
        val news = ApiInterface.create().getNews(newsbody)

        news.enqueue(object : Callback<test> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<test>, response: Response<test>) {
                for (i in response.body()?.data!!.list.indices) {
                    val title: String =
                        response.body()?.data!!.list[i].title.vi
                    val image: String =
                        response.body()?.data!!.list[i].avatar
                    val time: String =
                        response.body()?.data!!.list[i].createTime

                    newslist.add(
                        News(
                            title, image, time
                        )
                    )
                    adapter.notifyDataSetChanged()
                    Log.e("ok", "https://qa-rohto-cmsapi.niw.com.vn/${newslist[i].image}")

                }

            }

            override fun onFailure(call: Call<test>, t: Throwable) {
                Toast.makeText(requireActivity(), t.toString(), Toast.LENGTH_LONG).show()
                Log.e("ok", t.toString())
            }

        })
        binding!!.rcvNews.adapter = adapter
    }
}
