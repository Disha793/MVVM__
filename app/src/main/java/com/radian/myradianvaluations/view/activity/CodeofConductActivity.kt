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
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.radian.myradianvaluations.BuildConfig
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.StatusResponse
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.extensions.*
import com.radian.myradianvaluations.network.APIList
import com.radian.myradianvaluations.network.RetrofitBase
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.utils.Pref
import com.radian.myradianvaluations.viewmodel.CodeofConductModelFactory
import com.radian.myradianvaluations.viewmodel.CodeofConductViewModel
import com.radian.myradianvaluations.viewmodel.ManageOrderViewModel
import kotlinx.android.synthetic.main.activity_code_conduct.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CodeofConductActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var codeofConductViewModel: CodeofConductViewModel
    private lateinit var factory: CodeofConductModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_conduct)
        initViewModel()
        getIntentData()
        manageUI()
        observeData()
        btnAccept.setOnClickListener(this)
        btnReject.setOnClickListener(this)
        btnnRemind.setOnClickListener(this)
    }


    private fun initViewModel() {
        factory = CodeofConductModelFactory(this!!)
        codeofConductViewModel =
            ViewModelProvider(this, factory).get(CodeofConductViewModel::class.java)
    }

    private fun getIntentData() {
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
    }

    private fun manageUI() {
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
    }

    private fun observeData() {
        codeofConductViewModel.statusresponse.observeOnce(this, Observer {
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
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btnAccept -> {
                if (isValid()) {
                    saveVendorcompliance("A", edtUserName.text.toString())
                }
            }
            R.id.btnReject -> {
                saveVendorcompliance("D", "")

            }
            R.id.btnnRemind -> {
                saveVendorcompliance("R", "")

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
        val postParam = HashMap<String, Any?>()
        postParam.put("PhoneNumber", Pref.getValue(this, Pref.PHONE_NUMBER, "")!!)
        postParam.put("DeviceID", CommonUtils.getDeviceUUID(this))
        postParam.put("ActionType", actionType)
        postParam.put("AcceptedBy", acceptedBy)
        codeofConductViewModel.saveVendorCompliance(postParam)


    }


}

