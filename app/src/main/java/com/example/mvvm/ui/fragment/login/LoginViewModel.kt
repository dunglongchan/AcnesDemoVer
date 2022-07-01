package com.example.mvvm.ui.fragment.login

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.data.ApiInterface
import com.example.mvvm.data.body.LoginBody
import com.example.mvvm.data.response.LoginResponse
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {
    private val RohtoApi = ApiInterface.create()
    var curLoginUser = LoginBody("","")

    val loginResponseLiveData = MutableLiveData<LoginResponse?>()
    val loginChecker = MutableLiveData<String>()

    init {
        loginResponseLiveData.value = null
    }

    fun getLoginUser(userName: String,password: String){
        curLoginUser = LoginBody(userName,password)
    }
    fun onUserNameChange(userName: String) {
        curLoginUser.userName = userName
    }

    fun onPasswordChange(password: String) {
        curLoginUser.password = password
    }

    fun login() = viewModelScope.launch {
        val login = RohtoApi.postlogin(curLoginUser)
        login.enqueue(object: Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if(response.body()?.status=="success"){
                    ApiInterface.accessToken = response.body()?.data?.accessToken
                    login.let {
                        loginResponseLiveData.value = response.body()
                    }
                }else{
                    loginChecker.value = response.body()?.errors?.first()?.message
                }
            }
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                loginChecker.value = t.toString()
            }
        })
    }
}