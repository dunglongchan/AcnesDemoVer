package com.example.mvvm.ui.fragment.login

import android.annotation.SuppressLint
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mvvm.NavGraphDirections
import com.example.mvvm.R
import com.example.mvvm.data.ApiInterface
import com.example.mvvm.data.response.InforResponse
import com.example.mvvm.databinding.FragmentLoginBinding
import com.example.mvvm.module.UserInformation
import com.example.mvvm.ui.basefragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_login.*
import retrofit2.Call
import retrofit2.Response
import kotlin.math.log

class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_login
    private val loginViewModel: LoginViewModel by viewModels()
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = activity?.getSharedPreferences("checklogined", MODE_PRIVATE)!!


    }

    private fun logingIn() {
        loginViewModel.loginResponseLiveData.observe(this) {
            if (it?.status == "success") {
                let {
                    val editor: SharedPreferences.Editor = sharedPreferences.edit()
                    editor.putBoolean("logined",true)
                    editor.putString("username",loginViewModel.curLoginUser.userName)
                    editor.putString("password", loginViewModel.curLoginUser.password)

                    Log.e("ok",loginViewModel.curLoginUser.userName)
                    Log.e("ok",loginViewModel.curLoginUser.password)

                    editor.apply()
                    findNavController().navigate(NavGraphDirections.actionToHomeFrag())
                }
            } else {
                loginViewModel.loginChecker.observe(this) {
                    Toast.makeText(requireActivity(), it, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun initView() {
        logingIn()

        binding!!.txtshowpass.setOnClickListener {
            showAndHide(textfieldpassword)
        }

        binding!!.loginVM = loginViewModel

        binding!!.textfieldusername.addTextChangedListener(
            provideTextWatcher {
                loginViewModel.onUserNameChange(it)
            })

        binding!!.textfieldpassword.addTextChangedListener(
            provideTextWatcher {
                loginViewModel.onPasswordChange(it)
            }
        )

        loginViewModel.getLoginUser(binding!!.textfieldusername.text.toString(),binding!!.textfieldpassword.text.toString())

    }

    private fun showAndHide(txtshowpass: TextView?) {
        if (txtshowpass?.getTransformationMethod()
                ?.equals(PasswordTransformationMethod.getInstance()) == true
        ) {
            //Show Password
            txtshowpass.setTransformationMethod(HideReturnsTransformationMethod.getInstance())
        } else {
            //Hide Password
            txtshowpass?.setTransformationMethod(PasswordTransformationMethod.getInstance())
        }
    }

    private fun provideTextWatcher(onchange: (String) -> Unit): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                p0?.let {
                    onchange(it.toString())
                }
            }
        }
    }

}