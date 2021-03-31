package com.radian.myradianvaluations.view.activity

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.extensions.makeVisible
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.utils.LogUtils
import com.radian.myradianvaluations.viewmodel.HelpTroubleViewModel
import com.radian.myradianvaluations.viewmodel.HelpViewModelFactory
import kotlinx.android.synthetic.main.fragment_walkthroughmain.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class WebviewActivity : AppCompatActivity() {
    private var webUrl = ""
    private var timeout = false
    lateinit var helpTroubleModel: HelpTroubleViewModel
    private lateinit var factory: HelpViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_walkthroughmain)
        imgBack.makeVisible()
        viewLine.makeVisible()
        imgBack.setOnClickListener { onBackPressed() }
        getIntentData()

    }

    private fun initViewModel() {
        factory = HelpViewModelFactory(this)
        helpTroubleModel = ViewModelProvider(this, factory).get(HelpTroubleViewModel::class.java)
    }

    private fun observeData() {
        helpTroubleModel.helpTroubleResponse.observe(this, Observer {
            webUrl = it.data.forgotPasswordURL!!
            LogUtils.logD("webUrl", webUrl)
            loadWebUrl()
        })
    }

    private fun getIntentData() {
        intent.getIntExtra(Const.scrTag, 0).let {
            if (it == Const.scrOrgInfo) {
                toolbar.makeVisible()
                intent.getStringExtra("webUrl")?.let {
                    txtTitle.makeVisible()
                    txtTitle.setText(getString(R.string.joinUs))
                    webUrl = it
                    LogUtils.logD("webUrl", webUrl)
                    loadWebUrl()
                }
            } else if (it == Const.scrCovidTag) {
                toolbar.makeVisible()
                txtTitle.makeVisible()
                txtTitle.text = getString(R.string.radianResponse)
                webUrl = "https://www.radian.com/covid-19/"
                loadWebUrl()
            } else if (it == Const.scrSignUp) {
                toolbar.makeVisible()
                txtTitle.makeVisible()
                txtTitle.text = getString(R.string.signup)
                webUrl = "https://falcon.radianvaluations.com/NewVendorProfile"
                loadWebUrl()

            }
            else if(it==Const.scrViewPdf)
            {
                intent.getStringExtra("webUrl")?.let {
                    toolbar.makeVisible()
                    txtTitle.makeVisible()
                    txtTitle.setText(getString(R.string.showPdfTitle))
                    webUrl = it
                    LogUtils.logD("webUrl", webUrl)
                    loadWebUrl()
                }
            }
            else {
                toolbar.makeVisible()
                txtTitle.makeVisible()
                txtTitle.text = getString(R.string.forgotPassword)
                initViewModel()
                getInfo()
                observeData()
            }
        }
    }

    private fun loadWebUrl() {
        LoadingDialog.show(this)
        webView.settings.loadWithOverviewMode = true
        webView.settings.useWideViewPort = true
        webView.settings.javaScriptEnabled = true
        webView.settings.cacheMode = WebSettings.LOAD_DEFAULT
        if (!CommonUtils.isNetworkAvailable(this)) { // loading offline
            webView.settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        }
        webView.loadUrl(webUrl)
        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                LoadingDialog.dismissDialog()
                timeout = false
            }

            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {

                return true
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                Thread(Runnable {
                    timeout = true
                    try {
                        Thread.sleep(2000)
                    } catch (e: InterruptedException) {
                        LogUtils.logE("", e)
                    }
                    if (timeout) {
                        LoadingDialog.dismissDialog()
                    }
                }).start()
            }
        }
    }

    private fun getInfo() {
        helpTroubleModel.getHelpTroubleData()
    }

}