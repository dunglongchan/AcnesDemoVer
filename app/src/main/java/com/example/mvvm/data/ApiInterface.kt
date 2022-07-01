package com.example.mvvm.data

import android.content.Context
import android.content.SharedPreferences
import com.example.mvvm.BuildConfig
import com.example.mvvm.data.body.*
import com.example.mvvm.data.response.*
import com.example.mvvm.data.test.test
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit

interface ApiInterface {

    @POST("login")
    fun postlogin(
        @Body user: LoginBody
    ): Call<LoginResponse>

    @POST("ContentNew/List")
    fun getNews(
        @Body body: NewsBody
    ): Call<test>

    @GET("SurveySkin/GetByCurrentId")
    fun getInforSurvey(): Call<SurveySkinHistory>

    @GET("Analysis/DetailLastTime")
    fun getAnalysisHistory(): Call<AnalysisHistory>

    @POST("Notification/ListByAccountLogin")
    fun getNotification(
        @Body body: NotifyBody
    ):Call<NotifyResponse>

    @GET("profile")
    fun getProfile():Call<InforResponse>

    @POST("update-info")
    fun updateInfor(
        @Body body: UpdateInforBody
    ): Call<UpdateInforResponse>

    @Multipart
    @POST("upload-avatar")
    fun setAvatar(
        @Part filePart: MultipartBody.Part,
    ): Call<AvatarResponse>

    @GET("SurveySkin/GetFormSurveySkin")
    fun getFormSUrvey(): Call<FormSurveyResponse>

    @POST("SurveySkin/Create")
    fun postSurveySkin(
        @Body body: SurveySkinBody
    ): Call<SurveySkinResponse>

    companion object {
        val BASE_URL = "http://45.118.144.92:8117/api/"
        var accessToken: String? = ""

        fun create(): ApiInterface {

            val gson: Gson = GsonBuilder().setLenient().create()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(provideOkHttpClient())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
            return retrofit.create(ApiInterface::class.java)
        }

        fun provideOkHttpClient(): OkHttpClient {
            return getOkHttpClinetBuilder().build()
        }

        private fun getOkHttpClinetBuilder(): OkHttpClient.Builder {
            val logging = getHttpLoggingInterceptor()
            val builder = OkHttpClient.Builder().connectTimeout(15, TimeUnit.MINUTES)
                .readTimeout(15, TimeUnit.MINUTES)
                .addInterceptor(logging)
                .addInterceptor { chain ->
                    chain.proceed(chain.request().newBuilder().also {
                        it.addHeader("Authorization", "Bearer $accessToken")
                    }.build())
                }
                .addInterceptor {
                    it.proceed(
                        it.request()
                            .newBuilder()
                            .build()
                    )
                }
            return builder
        }

        private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
            val logging = HttpLoggingInterceptor()
            if (BuildConfig.DEBUG) {
                logging.level = HttpLoggingInterceptor.Level.BODY
            } else {
                logging.level = HttpLoggingInterceptor.Level.NONE
            }
            return logging
        }
    }
}