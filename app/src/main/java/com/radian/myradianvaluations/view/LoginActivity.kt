package com.radian.myradianvaluations.view

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.constants.DeviceStatus

import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.utils.Pref
import com.radian.myradianvaluations.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {
    internal lateinit var loginViewModel: LoginViewModel
    private val PASSWORD_PATTERN = Pattern.compile(
        "^" +
                "(?=.*[0-9])" +         //at least 1 digit
                "(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[@#$%^&+=!()-_])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{8,}" +               //at least 8 characters
                "$"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        imgBack.visibility = View.GONE
        loginViewModel.init(this)
        btnNxt.setOnClickListener {
            //signIN()
            getUserStatus()

        }
        edtPassword.setOnEditorActionListener { p0, p1, p2 ->
            if (p1 == EditorInfo.IME_ACTION_GO) {
                // do your stuff here
                getUserStatus()
            }
            false
        }
        txtHavingTrouble.setOnClickListener {
            startActivity(Intent(this, OrgInfoActivity::class.java))
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
        loginViewModel.userStatus.observe(this, Observer {
            if (it?.status.equals(APIStatus.ok, true)) {
                Pref.setValue(
                    this,
                    Pref.PHONE_NUMBER,
                    CommonUtils.getPhoneNumber(edtPhoneNumber.text.toString())
                )

                if (it.data.deviceStatusResponse.deviceStaus == DeviceStatus.notAuthorized) {
                    CommonUtils.displayMessage(
                        relativeMain,
                        it.data.deviceStatusResponse.message
                    )
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
                CommonUtils.displayMessage(
                    relativeMain,
                    it?.errorInfo!!.get(0).errorMessage
                )
            }
        })
    }

    fun isValid(): Boolean {
        if (TextUtils.isEmpty(edtPhoneNumber.text)) {
            CommonUtils.hideKeybord(edtPhoneNumber, this)
            CommonUtils.displayMessage(
                relativeMain,
                getString(R.string.error_login_empty)
            )
            return false
        }
        if (edtPhoneNumber.text.toString().trim().length != 10) {
            CommonUtils.hideKeybord(edtUsername, this)
            CommonUtils.displayMessage(
                relativeMain,
                getString(R.string.error_login_invalid_number)
            )
            return false
        }
        if (TextUtils.isEmpty(edtUsername.text.toString())) {
            CommonUtils.hideKeybord(edtUsername, this)
            CommonUtils.displayMessage(
                relativeMain,
                getString(R.string.error_login_empty_username)
            )
            return false
        }


        if (TextUtils.isEmpty(edtPassword.text.toString())) {
            CommonUtils.hideKeybord(edtPhoneNumber, this)
            CommonUtils.displayMessage(
                relativeMain,
                getString(R.string.error_login_empty_password)
            )
            return false
        }
        if (!PASSWORD_PATTERN.matcher(edtPassword.text.toString()).matches()) {
            CommonUtils.hideKeybord(edtPassword, this)
            CommonUtils.displayMessage(
                relativeMain,
                getString(R.string.error_login_invalid_password)
            )
            return false
        }
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }

    fun getUserStatus() {
        val postParam = HashMap<String, String>()
        postParam.put("deviceID", CommonUtils.getDeviceUUID(this))
        postParam.put("PhoneNumber", edtPhoneNumber.text.toString())
        postParam.put("UserName", edtUsername.text.toString())
        postParam.put("Password", edtPassword.text.toString())
        val gson = Gson()
        loginViewModel.getUserStatus(gson.fromJson(gson.toJson(postParam), JsonObject::class.java))
    }

    fun signIN() {
        if (isValid()) {
            Pref.setValue(
                this,
                Pref.PHONE_NUMBER,
                CommonUtils.getPhoneNumber(edtPhoneNumber.text.toString())
            )

            LoadingDialog.show(this)
            loginViewModel.signIn(
                edtUsername.text.toString(),
                edtPhoneNumber.text.toString(),
                edtPassword.text.toString()
            ).let {
                it?.observe(this, Observer {
                    LoadingDialog.dismissDialog()
                    if (it?.status.equals(APIStatus.ok, true)) {
                        if (it.data.deviceStatusResponse.deviceStaus == DeviceStatus.notAuthorized) {
                            CommonUtils.displayMessage(
                                relativeMain,
                                it.data.deviceStatusResponse.message
                            )
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
                        CommonUtils.displayMessage(
                            relativeMain,
                            it?.errorInfo!!.get(0).errorMessage
                        )
                    }
                })
                if (it == null) {
                    LoadingDialog.dismissDialog()
                    CommonUtils.displayMessage(
                        relativeMain,
                        getString(R.string.please_try_again)
                    )
                }
            }


        }
    }
}