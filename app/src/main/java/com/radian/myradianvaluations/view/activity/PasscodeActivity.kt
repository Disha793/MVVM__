package com.radian.myradianvaluations.view.activity

import android.annotation.TargetApi
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.iid.FirebaseInstanceId
import com.radian.myradianvaluations.BuildConfig
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.constants.DeviceStatus
import com.radian.myradianvaluations.extensions.*
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LogUtils
import com.radian.myradianvaluations.utils.Pref
import com.radian.myradianvaluations.viewmodel.PasscodeViewModel
import com.radian.myradianvaluations.viewmodel.PasscodeViewModelFactory
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.access_code_keyboard.*
import kotlinx.android.synthetic.main.activity_passcode.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import java.io.IOException


class PasscodeActivity : AppCompatActivity(), View.OnClickListener {
    private var counter = 0
    private var accessCode = ""
    private var previousAccessCode = ""
    private var scrTag = 0
    private var isNew = false
    private var isConfirmed = false
    private var isForgot = false
    private var isFirstSetup = false
    private var fcmToken = ""
    private lateinit var context: Context
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    private val firebaseParams = Bundle()
    lateinit var passcodeModel: PasscodeViewModel
    private lateinit var factory: PasscodeViewModelFactory
    private var TAG = PasscodeActivity::class.java.toString()

    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passcode)
        context = this
        firebaseAnalytics = FirebaseAnalytics.getInstance(this)
        firebaseParams.clear()
        firebaseParams.putString(Const.screenLaunched, "AccessCode_Launched")
        initViewModel()
        CommonUtils.addParamstoFirebaseEvent(
            firebaseAnalytics,
            Const.screenLaunched,
            firebaseParams
        )
        LogUtils.logD(TAG, Pref.getValue(this, Pref.FCM_TOKEN, "")!!)

        FirebaseApp.initializeApp(this)
        getToken()
        observePasscodeData()
        manageUI()
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)
        btn0.setOnClickListener(this)
        imgDelete.setOnClickListener(this)
        txtForgot.setOnClickListener(this)


    }

    private fun observePasscodeData() {
        passcodeModel.otpResponse.observeOnce(this, Observer {
            if (it.data.deviceStatus == DeviceStatus.verifyOTP) {
                Pref.setValue(
                    this,
                    Pref.DEVICE_STATUS,
                    it.data.deviceStatus
                )
                firebaseParams.clear()
                firebaseParams.putString(Const.methodInvoked, "OTPGenerated")
                CommonUtils.addParamstoFirebaseEvent(
                    firebaseAnalytics,
                    Const.methodInvoked,
                    firebaseParams
                )
            }
        })
        passcodeModel.verifyotpResponse.observeOnce(this, Observer {
            firebaseParams.clear()
            firebaseParams.putString("Phonenumber", Pref.getValue(this, Pref.PHONE_NUMBER, "")!!)
            firebaseParams.putString("DeviceID", CommonUtils.getDeviceUUID(this))
            firebaseParams.putString("OS", android.os.Build.VERSION.SDK_INT.toString())
            firebaseParams.putString("DeviceType", "Android")
            firebaseParams.putString("Manufacture", "Build.MANUFACTURER")
            firebaseParams.putString("FCM Token", fcmToken)
            CommonUtils.addParamstoFirebaseEvent(
                firebaseAnalytics,
                "DeviceConfiguration",
                firebaseParams
            )
            isForgot = false
            if (it.status.equals(APIStatus.ok, true)) {
                if (it.data.deviceStatus == DeviceStatus.createAccessCode) {
                    Pref.setValue(
                        this@PasscodeActivity,
                        Pref.DEVICE_STATUS,
                        it.data.deviceStatus
                    )
                    txtEnter.setText(getString(R.string.create_new_access_code))
                    txtForgot.makeInVisible()
                    isFirstSetup = false
                    isNew = true
                    clearData()
                    Pref.setValue(this@PasscodeActivity, Pref.IS_FIRST_TIME, true)
                    firebaseParams.clear()
                    firebaseParams.putString(Const.methodInvoked, "OTPVerified")
                    CommonUtils.addParamstoFirebaseEvent(
                        firebaseAnalytics,
                        Const.methodInvoked,
                        firebaseParams
                    )

                }
            } else if (it.status.equals(APIStatus.unauth, true)) {
                //
            } else if (it.status.equals(APIStatus.error, true)) {
                clearData()
                CommonUtils.showOkDialog(
                    this@PasscodeActivity,
                    getString(R.string.please_try_again),
                    DialogInterface.OnClickListener { _, _ ->
                        generateOtp()
                    },
                    getString(R.string.ok)
                )
            }
        })
        passcodeModel.loginResponse.observeOnce(this, Observer {
            if (it.status.equals(APIStatus.ok, true)) {

                Pref.setValue(
                    this@PasscodeActivity,
                    Pref.DEVICE_STATUS,
                    DeviceStatus.enterAccessCode
                )
                Pref.setValue(
                    this@PasscodeActivity,
                    Pref.AUTH_TOKEN,
                    "Bearer " + it.data.authToken
                )
                Pref.setValue(
                    this@PasscodeActivity,
                    Pref.MOBILE_USER_ID,
                    it.data.mobileUserId
                )
                Pref.setValue(
                    this@PasscodeActivity,
                    Pref.USER_ID,
                    it.data.userDetailJson.userList.get(0).userId!!
                )
                Pref.setValue(this@PasscodeActivity, Pref.ACCESS_CODE, accessCode)
                Pref.setValue(
                    this@PasscodeActivity,
                    Pref.ORGANIZATN_ID,
                    it.data.userDetailJson.userList.get(0).orgId
                )
                val params = Bundle()
                params.putString(
                    "userId",
                    it.data.userDetailJson.userList.get(0).userId!!.toString()
                )

                CommonUtils.addParamstoFirebaseEvent(firebaseAnalytics, "Logged_IN", params)
                var intent: Intent

                if (it.data.userDetailJson.cocFlag) {
                    intent = Intent(this@PasscodeActivity, CodeofConductActivity::class.java)
                    intent.putExtra(Const.btnCount, it.data.userDetailJson.btnCount)
                    startActivity(intent)
                } else {
                    intent = Intent(
                        this@PasscodeActivity,
                        BottomNavigationActivity::class.java
                    )
                    intent.putExtra(Const.basicLoginDetail, it)
                    startActivity(intent)

                }

            } else {
                if (it.status.equals(APIStatus.unauth, true)) {
//status unauthorized
                } else if (it.status.equals(APIStatus.error, true)) {
                    this.findViewById<View>(android.R.id.content)
                        .snack(it.errorInfo.get(0).errorMessage) {}
                    clearData()
                }
            }
        })
    }

    private fun manageUI() {
        imgBack.makeGone()
        if (Pref.getValue(this, Pref.DEVICE_STATUS, 0) == DeviceStatus.firstTimeSetUP) {
            txtForgot.makeInVisible()
            txtEnter.setText(
                getString(R.string.forgot_text) + " +" + Pref.getValue(
                    this,
                    Pref.PHONE_NUMBER,
                    ""
                )
            )
            isFirstSetup = true
            generateOtp()
        } else if (Pref.getValue(this, Pref.DEVICE_STATUS, 0) == DeviceStatus.verifyOTP) {
            txtForgot.makeInVisible()
            txtEnter.setText(
                getString(R.string.forgot_text) + " +" + Pref.getValue(
                    this,
                    Pref.PHONE_NUMBER,
                    ""
                )
            )
            isFirstSetup = true
        } else if (Pref.getValue(this, Pref.DEVICE_STATUS, 0) == DeviceStatus.createAccessCode) {
            txtEnter.setText(getString(R.string.create_new_access_code))
            txtForgot.makeInVisible()
        } else if (Pref.getValue(this, Pref.DEVICE_STATUS, 0) == DeviceStatus.enterAccessCode) {
            txtEnter.setText(getString(R.string.enter_access_code))
            txtForgot.makeVisible()
        }

        if (intent != null)
            scrTag = intent.getIntExtra(Const.scrTag, 0)
        if (scrTag == Const.scrSettingsTag) {
            txtForgot.makeInVisible()
            txtEnter.setText(getString(R.string.enter_current_access_code))
        }
        if (Pref.getValue(this, Pref.PROFILE_PIC_STATUS, "").equals("Y", true)) {
            loadProfileImage()
        }
    }

    private fun initViewModel() {
        factory = PasscodeViewModelFactory(this)
        passcodeModel = ViewModelProvider(this, factory).get(PasscodeViewModel::class.java)
    }

    override fun onClick(p0: View?) {

        when (p0?.id) {
            R.id.btn1 -> {
                accessCode = accessCode + "1"
                incrementCountr()
                checkRadiobutton()
            }
            R.id.btn2 -> {
                accessCode = accessCode + "2"
                incrementCountr()
                checkRadiobutton()
            }
            R.id.btn3 -> {
                accessCode = accessCode + "3"
                incrementCountr()
                checkRadiobutton()
            }
            R.id.btn4 -> {
                accessCode = accessCode + "4"
                incrementCountr()
                checkRadiobutton()
            }
            R.id.btn5 -> {
                accessCode = accessCode + "5"
                incrementCountr()
                checkRadiobutton()
            }
            R.id.btn6 -> {
                accessCode = accessCode + "6"
                incrementCountr()
                checkRadiobutton()
            }
            R.id.btn7 -> {
                accessCode = accessCode + "7"
                incrementCountr()
                checkRadiobutton()
            }
            R.id.btn8 -> {
                accessCode = accessCode + "8"
                incrementCountr()
                checkRadiobutton()
            }
            R.id.btn9 -> {
                accessCode = accessCode + "9"
                incrementCountr()
                checkRadiobutton()
            }

            R.id.btn0 -> {
                accessCode = accessCode + "0"
                incrementCountr()
                checkRadiobutton()
            }
            R.id.imgDelete -> {
                if (counter > 0) {
                    counter--
                    resetRadioBtn()
                }
            }
            R.id.imgBack -> {
                if (isForgot) {
                    isForgot = false
                    txtForgot.makeVisible()
                    txtEnter.text = getString(R.string.enter_new_access_code)
                    imgBack.makeGone()


                } else {
                    finish()
                    overridePendingTransition(R.anim.no_change, R.anim.slide_down)
                }
            }
            R.id.txtForgot -> {
                firebaseParams.clear()
                firebaseParams.putString(Const.methodInvoked, "forgotCodeTapped")
                CommonUtils.addParamstoFirebaseEvent(
                    firebaseAnalytics,
                    Const.methodInvoked,
                    firebaseParams
                )
                isForgot = true
                setForgotLayout()
                generateOtp()
            }
        }

    }

    private fun setForgotLayout() {
        txtEnter.setText(
            getString(R.string.forgot_text) + " +" + Pref.getValue(
                this,
                Pref.PHONE_NUMBER,
                ""
            )
        )
        txtForgot.makeInVisible()
        imgBack.makeGone()
        clearData()
    }

    private fun generateOtp() {

        val postParam = HashMap<String, Any?>()
        postParam.put("deviceID", CommonUtils.getDeviceUUID(this))
        postParam.put("PhoneNumber", Pref.getValue(context, Pref.PHONE_NUMBER, "")!!)
        passcodeModel.generateOtp(postParam)
    }

    private fun verifyOtp() {
        val postParam = HashMap<String, Any?>()
        postParam.put("deviceID", CommonUtils.getDeviceUUID(this))
        postParam.put("PhoneNumber", Pref.getValue(context, Pref.PHONE_NUMBER, "")!!)
        postParam.put("VerificationCode", accessCode)
        postParam.put("DeviceName", android.os.Build.MODEL)
        postParam.put("DeviceType", "Android")
        postParam.put("Manufacturer", Build.MANUFACTURER)
        postParam.put("OsVersion", android.os.Build.VERSION.SDK_INT.toString())
        postParam.put("FcmToken", fcmToken)
        passcodeModel.verifyOtp(postParam)
    }

    private fun callSignIn() {
        val postParam = HashMap<String, Any?>()
        postParam.put("deviceID", CommonUtils.getDeviceUUID(this))
        postParam.put("PhoneNumber", Pref.getValue(this, Pref.PHONE_NUMBER, "")!!)
        postParam.put("PinNo", accessCode)
        postParam.put("FcmToken", Pref.getValue(context, Pref.FCM_TOKEN, "")!!)
        passcodeModel.callSignIn(postParam)

    }

    private fun loadProfileImage() {
        Handler(Looper.getMainLooper()).post(Runnable {
            if (!TextUtils.isEmpty(Pref.getValue(this, Pref.PROFILE_URI, ""))) {

                Picasso.with(context)
                    .load(BuildConfig.HOST + Pref.getValue(context, Pref.PROFILE_URI, ""))
                    .placeholder(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.profile_placeholder
                        )
                    ).into(imgProfile)
            }
        })
    }

    private fun checkRadiobutton() {
        if (counter == 1) {
            radioBtn1.isChecked = true
        }
        if (counter == 2) {
            radioBtn2.isChecked = true
        }
        if (counter == 3) {
            radioBtn3.isChecked = true
        }
        if (counter == 4) {
            radioBtn4.isChecked = true
        }
        if (counter == 5) {
            radioBtn5.isChecked = true
        }
        if (counter == 6) {
            radioBtn6.isChecked = true
        }
    }

    private fun incrementCountr() {
        if (counter != 6)
            counter++
        if (counter == 6) {
            if (scrTag == Const.scrSettingsTag) {

                if (isConfirmed && isNew) {

                    if (accessCode.equals(previousAccessCode)) {
                        callSignIn()
                    } else {
                        this.findViewById<View>(android.R.id.content)
                            .snack(resources.getString(R.string.confirm_passcode_text)) {}
                    }
                } else if (isNew) {
                    previousAccessCode = accessCode
                    txtEnter.setText(getString(R.string.confirm_new_access_code))
                    isConfirmed = true
                    clearData()
                } else {
                    checkcurrentCode()
                }

            } else if (isForgot) {
                verifyOtp()
            } else if (isNew && !isConfirmed) {
                previousAccessCode = accessCode
                txtEnter.setText(getString(R.string.confirm_new_access_code))
                isConfirmed = true
                clearData()

            } else if (isNew && isConfirmed) {
                if (previousAccessCode.equals(accessCode)) {
                    callSignIn()
                }

            } else if (Pref.getValue(
                    this, Pref.DEVICE_STATUS, 0
                ) == DeviceStatus.verifyOTP || Pref.getValue(
                    this,
                    Pref.DEVICE_STATUS,
                    0
                ) == DeviceStatus.firstTimeSetUP
            ) {
                verifyOtp()
            } else if (Pref.getValue(
                    this,
                    Pref.DEVICE_STATUS,
                    0
                ) == DeviceStatus.createAccessCode
            ) {
                callSignIn()
                txtEnter.setText(getString(R.string.enter_access_code))
                txtForgot.makeVisible()
                clearData()
            } else if (Pref.getValue(this, Pref.DEVICE_STATUS, 0) == DeviceStatus.enterAccessCode) {
                callSignIn()
            }

        }

    }


    private fun checkcurrentCode() {
        if (accessCode.equals(Pref.getValue(this, Pref.ACCESS_CODE, ""))) {
            isNew = true
            txtEnter.setText(getString(R.string.enter_new_access_code))
            clearData()
        }
    }

    private fun resetRadioBtn() {
        if (radioBtn6.isChecked) {
            radioBtn6.isChecked = false
        } else if (radioBtn5.isChecked) {
            radioBtn5.isChecked = false
        } else if (radioBtn4.isChecked) {
            radioBtn4.isChecked = false
        } else if (radioBtn3.isChecked) {
            radioBtn3.isChecked = false
        } else if (radioBtn2.isChecked) {
            radioBtn2.isChecked = false
        } else if (radioBtn1.isChecked) {
            radioBtn1.isChecked = false
        }
        accessCode = accessCode.substring(0, accessCode.length - 1)
    }

    override fun onResume() {
        super.onResume()
        clearData()
        if (Pref.getValue(this, Pref.PROFILE_PIC_STATUS, "").equals("Y", true)) {
            loadProfileImage()
        }

    }

    private fun clearData() {
        counter = 0
        radioBtn1.isChecked = false
        radioBtn2.isChecked = false
        radioBtn3.isChecked = false
        radioBtn4.isChecked = false
        radioBtn5.isChecked = false
        radioBtn6.isChecked = false
        accessCode = ""


    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (isForgot) {
            txtForgot.makeVisible()
            txtEnter.setText(getString(R.string.enter_new_access_code))

        } else {
            finishAffinity()
            overridePendingTransition(R.anim.no_change, R.anim.slide_down)
        }


    }

    private fun getToken() {
        Thread(Runnable {
            try {
                FirebaseInstanceId.getInstance().instanceId
                    .addOnCompleteListener(OnCompleteListener { task ->
                        if (!task.isSuccessful) {
                            LogUtils.logE(TAG, task.exception!!)

                            return@OnCompleteListener
                        }
                        // Get new Instance ID token
                        fcmToken = task.result?.token!!
                        Pref.setValue(this, Pref.FCM_TOKEN, fcmToken)

                    })

            } catch (e: IOException) {
                LogUtils.logE(TAG, e)
            }
        }).start()
    }

}