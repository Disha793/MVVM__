package com.radian.myradianvaluations.view

import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.databinding.ActivityLoginBinding
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.viewmodel.LoginViewModel
import kotlin.math.sign

class LoginActivity : AppCompatActivity() {
    internal lateinit var loginViewModel: LoginViewModel
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.loginViewModel = loginViewModel
        binding.executePendingBindings()
        loginViewModel.init(this)
        binding.btnNxt.setOnClickListener {
            signIN()

        }
        binding.edtPassword.setOnEditorActionListener { p0, p1, p2 ->
            if (p1 == EditorInfo.IME_ACTION_GO) {
                // do your stuff here
               signIN()
            }
            false
        }

    }
    fun signIN(){
        if (loginViewModel.isValid(binding)) {
            LoadingDialog.show(this)
            loginViewModel.signIn(binding.edtUsername.text.toString(),binding.edtPhoneNumber.text.toString(),binding.edtPassword.text.toString())
                .observe(this, Observer {
                    LoadingDialog.dismissDialog()
                    if (it?.status.equals("ok", true)) {

                    } else if (it?.status.equals("error", true)) {
                        CommonUtils.displayMessage(
                            binding.relativeMain,
                            it?.errorInfo!!.get(0).errorMessage
                        )
                    }
                })

        }
    }
}