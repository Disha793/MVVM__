package com.radian.myradianvaluations.view.activity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.constants.DeviceStatus
import com.radian.myradianvaluations.extensions.makeGone
import com.radian.myradianvaluations.extensions.observeOnce
import com.radian.myradianvaluations.extensions.snack
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.Pref
import com.radian.myradianvaluations.viewmodel.LoginViewModel
import com.radian.myradianvaluations.viewmodel.LoginViewModelFactory
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {
    internal lateinit var loginViewModel: LoginViewModel
    private lateinit var factory: LoginViewModelFactory
    private val PASSWORD_PATTERN = Pattern.compile(
            Const.PASSWORD_PATTERN
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        imgBack.makeGone()
        initViewModel()
        btnNxt.setOnClickListener {
            //signIN()
            if (isValid())
                getUserStatus()
        }
        edtPassword.setOnEditorActionListener { _, p1, _ ->
            if (p1 == EditorInfo.IME_ACTION_GO) {
                if (isValid())
                    getUserStatus()
            }
            false
        }
        txtHavingTrouble.setOnClickListener {
            startActivity(Intent(this, HelpTroubleActivity::class.java))
        }
        txtForgotPwd.setOnClickListener {
            val intent = Intent(this, WebviewActivity::class.java)
            startActivity(intent)
        }
        txtSignup.setOnClickListener {
            val intent = Intent(this, WebviewActivity::class.java)
            intent.putExtra(Const.scrTag, Const.scrSignUp)
            startActivity(intent)
        }
        observeLoginData()

    }

    private fun initViewModel() {
        factory = LoginViewModelFactory(this)
        loginViewModel = ViewModelProvider(this, factory).get(LoginViewModel::class.java)
    }

    private fun observeLoginData() {
        loginViewModel.userStatus.observeOnce(this, Observer {
            if (it?.status.equals(APIStatus.ok, true)) {
                Pref.setValue(
                        this,
                        Pref.PHONE_NUMBER,
                        CommonUtils.getPhoneNumber(edtPhoneNumber.text.toString())
                )

                if (it.data.deviceStatusResponse.deviceStaus == DeviceStatus.notAuthorized) {
                    this.findViewById<View>(android.R.id.content).snack(it.data.deviceStatusResponse.message) {}

                } else {
                    Pref.setValue(
                            this@LoginActivity,
                            Pref.DEVICE_STATUS,
                            it.data.deviceStatusResponse.deviceStaus
                    )
                    Pref.setValue(this@LoginActivity, Pref.IS_FIRST_TIME, true)
                    var intent = Intent(this@LoginActivity, PasscodeActivity::class.java)
                    startActivity(intent)
                }
            } else if (it?.status.equals(APIStatus.error, true)) {
                this.findViewById<View>(android.R.id.content).snack(it?.errorInfo!!.get(0).errorMessage) {}
            }
        })
    }

    fun isValid(): Boolean {
        if (TextUtils.isEmpty(edtPhoneNumber.text)) {
            CommonUtils.hideKeybord(edtPhoneNumber, this)
            this.findViewById<View>(android.R.id.content).snack(getString(R.string.error_login_empty)) {}
            return false
        }
        if (edtPhoneNumber.text.toString().trim().length != 10) {
            CommonUtils.hideKeybord(edtUsername, this)
            this.findViewById<View>(android.R.id.content).snack(getString(R.string.error_login_invalid_number)) {}

            return false
        }
        if (TextUtils.isEmpty(edtUsername.text.toString())) {
            CommonUtils.hideKeybord(edtUsername, this)
            this.findViewById<View>(android.R.id.content).snack(getString(R.string.error_login_empty_username)) {}
            return false
        }
        if (TextUtils.isEmpty(edtPassword.text.toString())) {
            CommonUtils.hideKeybord(edtPhoneNumber, this)
            this.findViewById<View>(android.R.id.content).snack(getString(R.string.error_login_empty_password)) {}

            return false
        }
        if (!PASSWORD_PATTERN.matcher(edtPassword.text.toString()).matches()) {
            CommonUtils.hideKeybord(edtPassword, this)
            this.findViewById<View>(android.R.id.content).snack(getString(R.string.error_login_invalid_password)) {}
            return false
        }
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }

    fun getUserStatus() {
        val postParam = HashMap<String, Any?>()
        postParam.put("deviceID", CommonUtils.getDeviceUUID(this))
        postParam.put("PhoneNumber", edtPhoneNumber.text.toString())
        postParam.put("UserName", edtUsername.text.toString())
        postParam.put("Password", edtPassword.text.toString())
        loginViewModel.getUserStatus(postParam)
    }


}