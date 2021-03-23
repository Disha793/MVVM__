package com.radian.myradianvaluations.view.activity

import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.radian.myradianvaluations.BuildConfig
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.StatusResponse
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.extensions.makeGone
import com.radian.myradianvaluations.extensions.makeVisible
import com.radian.myradianvaluations.extensions.snack
import com.radian.myradianvaluations.extensions.toastShort
import com.radian.myradianvaluations.network.APIList
import com.radian.myradianvaluations.network.RetrofitBase
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.utils.Pref
import kotlinx.android.synthetic.main.activity_code_conduct.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CodeofConductActivity : AppCompatActivity(), View.OnClickListener {
    private var response = MutableLiveData<StatusResponse>()
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btnAccept -> {
                if (isValid()) {
                    saveVendorcompliance("A", edtUserName.text.toString())
                }
            }
            R.id.btnReject -> {
                saveVendorcompliance("D", null)

            }
            R.id.btnnRemind -> {
                saveVendorcompliance("R", null)

            }
        }
    }

    private fun isValid(): Boolean {
        if (TextUtils.isEmpty(edtUserName.text.toString())) {
            this.findViewById<View>(android.R.id.content)
                .snack(resources.getString(R.string.enter_initials)) {}
            return false
        }
        return true
    }

    private fun saveVendorcompliance(actionType: String, acceptedBy: String?) {
        CoroutineScope(Dispatchers.IO).launch {
            LoadingDialog.show(this@CodeofConductActivity)
            val call = RetrofitBase.getClient().create(APIList::class.java)
                .saveCompliance(
                    Pref.getValue(this@CodeofConductActivity, Pref.AUTH_TOKEN, "")!!,
                    Pref.getValue(this@CodeofConductActivity, Pref.PHONE_NUMBER, "")!!,
                    CommonUtils.getDeviceUUID(this@CodeofConductActivity),
                    actionType,
                    acceptedBy
                )
            response.postValue(call.body())
        }
        response.let {
            it?.observe(this, androidx.lifecycle.Observer {
                LoadingDialog.dismissDialog()
                if (it.status.equals(APIStatus.ok, true)) {
                    var intent: Intent
                    intent =
                        Intent(this@CodeofConductActivity, BottomNavigationActivity::class.java)
                    startActivity(intent)
                } else if (it.status.equals(APIStatus.error)) {
                    //error in api
                } else if (it.status.equals(APIStatus.unauth, true)) {
                    toastShort(it.errorInfo.get(0).errorMessage)

                    var intent = Intent(this@CodeofConductActivity, PasscodeActivity::class.java)
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(intent)
                }
            })
            if (it == null) {
                LoadingDialog.dismissDialog()
                CommonUtils.showOkDialog(
                    this@CodeofConductActivity,
                    getString(R.string.please_try_again),
                    DialogInterface.OnClickListener { _, _ ->


                    },
                    getString(R.string.ok)
                )

            }
        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_conduct)
        intent.getIntExtra(Const.btnCount, 0).let {
            when (it) {
                3 -> {
                    btnAccept.makeVisible()
                    btnReject.makeVisible()
                    btnnRemind.makeVisible()
                    linearBtn.weightSum = 3F
                }
                2 -> {
                    btnAccept.makeVisible()
                    btnReject.makeVisible()
                    btnnRemind.makeGone()
                    linearBtn.weightSum = 2F
                }
            }
        }

        txtTitle.makeVisible()
        viewLine.makeVisible()
        txtTitle.setText(getString(R.string.coc))
        LoadingDialog.show(this)
        webView.getSettings().setLoadWithOverviewMode(true)
        webView.getSettings().setUseWideViewPort(true)
        webView.getSettings().setJavaScriptEnabled(true)
        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT)
        if (!CommonUtils.isNetworkAvailable(this)) { // loading offline
            webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK)
        }
//        webView.loadUrl("https://docs.google.com/viewer?"+"url=https://training.exatechpgh.com/Content/Docs/CodeOfConduct.pdf")
        webView.loadUrl("http://docs.google.com/gview?embedded=true&url=" + BuildConfig.COC_URL)
        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                LoadingDialog.dismissDialog()
            }

            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                view?.let {
                    if (request != null && request.url != null)
                        it.loadUrl(request.url.toString())
                }

                return true
            }
        }
        btnAccept.setOnClickListener(this)
        btnReject.setOnClickListener(this)
        btnnRemind.setOnClickListener(this)
    }


}