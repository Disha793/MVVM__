package com.radian.myradianvaluations.view.fragment

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.analytics.FirebaseAnalytics
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.extensions.snackAction
import com.radian.myradianvaluations.extensions.toastShort
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.view.activity.BottomNavigationActivity
import com.radian.myradianvaluations.view.activity.PasscodeActivity
import com.radian.myradianvaluations.viewmodel.SettingsViewModel
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import kotlinx.android.synthetic.main.fragment_settings.view.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class SettingsFragment : Fragment(), View.OnClickListener {
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    val firebaseParams = Bundle()
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
                //Disha: For next release
//                saveNotiStatus()

            }
        }
    }


    var postParam = HashMap<String, String?>()
    val classTag = this.javaClass.name
    private lateinit var settingsViewModel: SettingsViewModel
    internal lateinit var view: View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_settings, container, false)
        settingsViewModel =
            ViewModelProvider(context as BottomNavigationActivity).get(SettingsViewModel::class.java)
        settingsViewModel.init(context as BottomNavigationActivity)
        view.cardChangeAccessCde.setOnClickListener {
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
        setToolbar()
        //Disha: For next release
//        getNotificatnStatus()
        view.switchNoti.setOnClickListener(this)

        return view
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

    private fun setToolbar() {
        (context as BottomNavigationActivity).layout_toolbar.visibility = View.VISIBLE
        (context as BottomNavigationActivity).txtTitle.text =
            resources.getString(R.string.settingsTitle)
        (context as BottomNavigationActivity).imgBack.visibility = View.VISIBLE
        (context as BottomNavigationActivity).txtClear.visibility = View.GONE
        (context as BottomNavigationActivity).bottomNavigationView.visibility = View.GONE

    }

  private  fun getNotificatnStatus() {
        LoadingDialog.show(context as BottomNavigationActivity)
        settingsViewModel.getNotiStatus().let {
            it?.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                LoadingDialog.dismissDialog()
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
            if (it == null) {
                LoadingDialog.dismissDialog()
                CommonUtils.showOkDialog(
                    context!!,
                    getString(R.string.please_try_again),
                    DialogInterface.OnClickListener { _, _ ->
                        getNotificatnStatus()

                    },
                    getString(R.string.ok)
                )
            }
        }

    }

  private  fun saveNotiStatus() {
        LoadingDialog.show(context as BottomNavigationActivity)
        settingsViewModel.saveNotiStatus().let {
            it?.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                LoadingDialog.dismissDialog()
                if (it.status.equals(APIStatus.ok, true)) {
                   view.snackAction(  view,
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
            if (it == null) {
                LoadingDialog.dismissDialog()
                CommonUtils.showOkDialog(
                    context!!,
                    getString(R.string.please_try_again),
                    DialogInterface.OnClickListener { _, _ ->
                        saveNotiStatus()

                    },
                    getString(R.string.ok)
                )
            }
        }

    }
}