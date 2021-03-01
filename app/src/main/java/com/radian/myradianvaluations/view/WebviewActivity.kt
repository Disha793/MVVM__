package com.radian.myradianvaluations.view

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
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.utils.LogUtils
import com.radian.myradianvaluations.viewmodel.OrgInfoViewModel
import kotlinx.android.synthetic.main.fragment_walkthroughmain.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class WebviewActivity : AppCompatActivity() {
    private var webUrl = ""
    private var timeout = false
    lateinit var orgInfoModel: OrgInfoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_walkthroughmain)
        imgBack.visibility = View.VISIBLE
        viewLine.visibility = View.VISIBLE
        imgBack.setOnClickListener { onBackPressed() }

        intent.getIntExtra(Const.scrTag, 0).let {
            if (it == Const.scrOrgInfo) {
                toolbar.visibility = View.VISIBLE

                intent.getStringExtra("webUrl")?.let {
                    txtTitle.visibility = View.VISIBLE
                    txtTitle.setText(getString(R.string.joinUs))
                    webUrl = it
                    LogUtils.logD("webUrl", webUrl)
                    loadWebUrl()
                }
            } else if (it == Const.scrCovidTag) {
                toolbar.visibility = View.VISIBLE
                txtTitle.visibility = View.VISIBLE
                txtTitle.text = "Radian’s response to COVID 19"
                webUrl = "https://www.radian.com/covid-19/"
                loadWebUrl()
            } else if (it == Const.scrSignUp) {
                toolbar.visibility = View.VISIBLE
                txtTitle.visibility = View.VISIBLE
                txtTitle.text = "Sign up"
                webUrl = "https://falcon.radianvaluations.com/NewVendorProfile"
                loadWebUrl()
            } else {
                toolbar.visibility = View.VISIBLE
                txtTitle.visibility = View.VISIBLE
                txtTitle.text = getString(R.string.forgotPassword)
                orgInfoModel = ViewModelProvider(this).get(OrgInfoViewModel::class.java)
                orgInfoModel.init(this)
                getInfo()
            }
        }


    }

    private fun loadWebUrl() {
        LoadingDialog.show(this)
        webView.getSettings().setLoadWithOverviewMode(true)
        webView.getSettings().setUseWideViewPort(true)
        webView.getSettings().setAppCachePath(this.getCacheDir().getAbsolutePath())
        webView.getSettings().setAppCacheEnabled(true)
        webView.getSettings().setJavaScriptEnabled(true)
        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT)
        if (!CommonUtils.isNetworkAvailable(this)) { // loading offline
            webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK)
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
                        e.printStackTrace()
                    }
                    if (timeout) {
                        LoadingDialog.dismissDialog()
                    }
                }).start()
            }
        }
    }

    private fun getInfo() {
        LoadingDialog.show(this)
        orgInfoModel.getInfo()?.observe(this, Observer {
            LoadingDialog.dismissDialog()
            webUrl = it.data.forgotPasswordURL!!
            LogUtils.logD("webUrl", webUrl)
            loadWebUrl()

        })


    }

}