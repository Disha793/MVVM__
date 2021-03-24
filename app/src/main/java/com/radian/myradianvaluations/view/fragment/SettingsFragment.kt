package com.radian.myradianvaluations.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.analytics.FirebaseAnalytics
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.extensions.makeGone
import com.radian.myradianvaluations.extensions.makeVisible
import com.radian.myradianvaluations.extensions.snackAction
import com.radian.myradianvaluations.extensions.toastShort
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.Pref
import com.radian.myradianvaluations.view.activity.BottomNavigationActivity
import com.radian.myradianvaluations.view.activity.PasscodeActivity
import com.radian.myradianvaluations.viewmodel.SettingsViewModel
import com.radian.myradianvaluations.viewmodel.SettingsViewModelFactory
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import kotlinx.android.synthetic.main.fragment_settings.view.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class SettingsFragment : Fragment(), View.OnClickListener {
    private lateinit var factory: SettingsViewModelFactory
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    val firebaseParams = Bundle()
    var postParam = HashMap<String, Any?>()
    val classTag = this.javaClass.name
    private lateinit var settingsViewModel: SettingsViewModel
    internal lateinit var view: View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_settings, container, false)
        initViewModel()
        setToolbar()
        getNotificatnStatus()
        observeNotificationData()
        view.switchNoti.setOnClickListener(this)
        view.cardChangeAccessCde.setOnClickListener(this)
        return view
    }

    private fun observeNotificationData() {

        settingsViewModel.notiStatusResponse.observe(viewLifecycleOwner, Observer {
            if (it.status.equals(APIStatus.ok, true)) {
                view.switchNoti.isChecked =
                    it.data?.nSTATUS?.isNotEmpty()!! && it.data?.nSTATUS?.get(0)?.valuCode.equals(
                        "y",
                        true
                    )

            } else if (it.status.equals(APIStatus.unauth, true)) {
                context!!.toastShort(it.errorInfo.get(0).errorMessage)

                var intent = Intent(context!!, PasscodeActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
            }
        })

        settingsViewModel.saveNotiStatusResponse.observe(viewLifecycleOwner, Observer {
            if (it.status.equals(APIStatus.ok, true)) {
                view.snackAction(view,
                    "Notification Updated",
                    "ok",
                    View.OnClickListener { })

            } else if (it.status.equals(APIStatus.unauth, true)) {

                context!!.toastShort(it.errorInfo.get(0).errorMessage)

                var intent = Intent(context!!, PasscodeActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
            }
        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        firebaseAnalytics = FirebaseAnalytics.getInstance(context!!)
        firebaseParams.clear()
        firebaseParams.putString(Const.screenLaunched, "Settings")
        CommonUtils.addParamstoFirebaseEvent(
            firebaseAnalytics,
            Const.screenLaunched,
            firebaseParams
        )
    }

    private fun initViewModel() {
        factory = SettingsViewModelFactory(context!!)
        settingsViewModel = ViewModelProvider(this, factory).get(SettingsViewModel::class.java)
    }

    private fun setToolbar() {
        (context as BottomNavigationActivity).layout_toolbar.makeVisible()
        (context as BottomNavigationActivity).txtTitle.text =
            resources.getString(R.string.settingsTitle)
        (context as BottomNavigationActivity).imgBack.makeVisible()
        (context as BottomNavigationActivity).txtClear.makeGone()
        (context as BottomNavigationActivity).bottomNavigationView.makeGone()

    }

    private fun getNotificatnStatus() {
        postParam.put(
            "PhoneNumber",
            Pref.getValue(context!!, Pref.PHONE_NUMBER, "")!!
        )
        postParam.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
        postParam.put("MobileUserId", Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0).toString()!!)

        settingsViewModel.getNotiStatus(postParam)
    }

    private fun saveNotiStatus() {
        settingsViewModel.saveNotiStatus(postParam)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.imgBack -> {
                (context as BottomNavigationActivity).supportFragmentManager.popBackStack()
            }
            R.id.switchNoti -> {
                if (view.switchNoti.isChecked) {
                    firebaseParams.clear()
                    firebaseParams.putString(Const.methodInvoked, "notificationsSetOn")
                    CommonUtils.addParamstoFirebaseEvent(
                        firebaseAnalytics,
                        Const.methodInvoked,
                        firebaseParams
                    )
                    postParam.put("ActionType", "O")
                    postParam.put("ActionCategory", "10")
                    postParam.put("ActionValue", "Y")

                } else {
                    firebaseParams.clear()
                    firebaseParams.putString(Const.methodInvoked, "notificationsSetOff")
                    CommonUtils.addParamstoFirebaseEvent(
                        firebaseAnalytics,
                        Const.methodInvoked,
                        firebaseParams
                    )
                    postParam.put("ActionType", "N")
                    postParam.put("ActionCategory", "")
                    postParam.put("ActionValue", "N")

                }
                saveNotiStatus()
            }
            R.id.cardChangeAccessCde -> {
                firebaseParams.clear()
                firebaseParams.putString(Const.methodInvoked, "ChangeAccessCodeTapped")
                CommonUtils.addParamstoFirebaseEvent(
                    firebaseAnalytics,
                    Const.methodInvoked,
                    firebaseParams
                )
                startActivity(
                    Intent(context, PasscodeActivity::class.java).putExtra(
                        Const.scrTag,
                        Const.scrSettingsTag
                    )
                )

                activity?.overridePendingTransition(R.anim.slide_up, R.anim.no_change)

            }

        }
    }


}