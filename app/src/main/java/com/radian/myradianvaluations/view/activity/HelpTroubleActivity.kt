package com.radian.myradianvaluations.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.constants.Const

import com.radian.myradianvaluations.utils.LoadingDialog

import com.radian.myradianvaluations.viewmodel.HelpTroubleViewModel
import kotlinx.android.synthetic.main.activity_orginfo.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class HelpTroubleActivity : AppCompatActivity() {

    lateinit var helpTroubleModel: HelpTroubleViewModel
    private var webUrl = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orginfo)
        helpTroubleModel = ViewModelProvider(this).get(HelpTroubleViewModel::class.java)
        helpTroubleModel.init(this)
        imgBack.visibility = View.VISIBLE
        txtTitle.visibility = View.VISIBLE
        txtTitle.setTextColor(ContextCompat.getColor(this, android.R.color.white))
        if (intent != null && intent.getStringExtra(Const.scrTag) != null) {
            intent.getStringExtra(Const.scrTag)?.let {
                if (it == Const.scrDrawerTag) {
                    txtTitle.text = getString(R.string.gethelpTitle)
                }
            }
        } else {
            txtTitle.text = getString(R.string.support)
        }
        //Disha: For next release
        helpTroubleModel.getHelpTroubleData()
        observeData()


        txtHere.setOnClickListener {
            val intent = Intent(this@HelpTroubleActivity, WebviewActivity::class.java)
            intent.putExtra("webUrl", webUrl)
            intent.putExtra(Const.scrTag, Const.scrOrgInfo)
            startActivity(intent)
        }
        imgBack.setOnClickListener { onBackPressed() }
    }

    private fun observeData() {
        helpTroubleModel.helpTroubleResponse.observe(this, Observer {
            if (it.status.equals(APIStatus.ok, true)) {
                txt_phone_number.text = it.data.contactDetail?.contactNumber
                txt_working_days.text = it.data.contactDetail?.workingDays
                txt_working_timing.text = it.data.contactDetail?.workingTime
                txt_email.text = it.data.contactDetail?.email
                it.data.contactDetail?.joinUsURL?.let {
                    webUrl = it
                }
            }
        })
    }

    fun getInfo() {
        LoadingDialog.show(this)
        helpTroubleModel.getInfo()?.observe(this, Observer {
            LoadingDialog.dismissDialog()
            if (it.status.equals(APIStatus.ok, true)) {
                txt_phone_number.text = it.data.contactDetail?.contactNumber
                txt_working_days.text = it.data.contactDetail?.workingDays
                txt_working_timing.text = it.data.contactDetail?.workingTime
                txt_email.text = it.data.contactDetail?.email
                webUrl = it.data.contactDetail!!.joinUsURL
            }

        })
    }
}