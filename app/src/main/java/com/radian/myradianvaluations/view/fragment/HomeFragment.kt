package com.radian.myradianvaluations.view.fragment

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.google.firebase.analytics.FirebaseAnalytics
import com.radian.myradianvaluations.BuildConfig
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.extensions.makeGone
import com.radian.myradianvaluations.extensions.makeVisible
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.EventBusMessage
import com.radian.myradianvaluations.utils.Pref
import com.radian.myradianvaluations.view.activity.BottomNavigationActivity
import com.radian.myradianvaluations.view.activity.HelpTroubleActivity
import com.radian.myradianvaluations.view.activity.PasscodeActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import kotlinx.android.synthetic.main.dashbard_sidemenu.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.toolbar_dashboard.view.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class HomeFragment : Fragment(), View.OnClickListener {
    internal lateinit var view: View
    internal lateinit var firebaseAnalytics: FirebaseAnalytics
    private val firebaseParams = Bundle()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_home, container, false)
        (context as BottomNavigationActivity).layout_toolbar.makeGone()
        (context as BottomNavigationActivity).bottomNavigationView.makeVisible()
        if (Pref.getValue(context!!, Pref.PROFILE_PIC_STATUS, "").equals("Y", true)) {
            loadProfileImage()
        }
        pushFragment(DashboardFragment(), false)
        view.imgUser.setOnClickListener(this)
        view.imgMessage.setOnClickListener(this)
        view.imgDrawer.setOnClickListener(this)
        view.linearOut.setOnClickListener(this)
        view.linearDocument.setOnClickListener(this)
        view.linearAbout.setOnClickListener(this)
        view.linearGetHelp.setOnClickListener(this)
        view.linearSetting.setOnClickListener(this)
        view.linearSignout.setOnClickListener(this)
        return view
    }

    private fun loadProfileImage() {
        Handler(Looper.getMainLooper()).post {
            if (!TextUtils.isEmpty(Pref.getValue(context!!, Pref.PROFILE_URI, ""))) {

                Picasso.with(context)
                    .load(BuildConfig.HOST + Pref.getValue(context!!, Pref.PROFILE_URI, ""))
                    .placeholder(
                        ContextCompat.getDrawable(
                            context!!,
                            R.drawable.profile_placeholder
                        )
                    ).into(view.imgUser)

            }

        }

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.imgUser -> {
                view.toolbarDashboard.makeGone()
                (context as BottomNavigationActivity).layout_toolbar.makeGone()
                (context as BottomNavigationActivity).pushFragment(ProfileFragment(), true)
                (context as BottomNavigationActivity).bottomNavigationView.makeGone()
            }
            R.id.imgMessage -> {
                (context as BottomNavigationActivity).pushFragment(MessageListFragment(), true)
            }
            R.id.imgDrawer -> {
                view.drawer_layout.openDrawer(GravityCompat.END)
            }
            R.id.linearOut -> {
                view.drawer_layout.closeDrawer(GravityCompat.END)
                (context as BottomNavigationActivity).pushFragment(OutofOfficeFragment(), true)
            }
            R.id.linearSignout -> {
                firebaseParams.clear()
                firebaseParams.putString("signout_tapped", "signout")
                CommonUtils.addParamstoFirebaseEvent(
                    firebaseAnalytics,
                    "Dashboard_launched",
                    firebaseParams
                )
                signoutDialogue()
                view.drawer_layout.closeDrawer(GravityCompat.END)
            }
            R.id.linearDocument -> {
                firebaseParams.clear()
                firebaseParams.putString(Const.methodInvoked, "organizationsTappedFromMenu")
                CommonUtils.addParamstoFirebaseEvent(
                    firebaseAnalytics,
                    Const.methodInvoked,
                    firebaseParams
                )
                (context as BottomNavigationActivity).pushFragment(DocumentFragment(), true)
                view.drawer_layout.closeDrawer(GravityCompat.END)
            }
            R.id.linearAbout -> {
                firebaseParams.clear()
                firebaseParams.putString(Const.methodInvoked, "aboutUsTappedFromMenu")
                CommonUtils.addParamstoFirebaseEvent(
                    firebaseAnalytics,
                    Const.methodInvoked,
                    firebaseParams
                )
                (context as BottomNavigationActivity).pushFragment(AboutusFragment(), true)
                view.drawer_layout.closeDrawer(GravityCompat.END)
            }
            R.id.linearSetting -> {
                firebaseParams.clear()
                firebaseParams.putString(Const.methodInvoked, "settingsTappedFromMenu")
                CommonUtils.addParamstoFirebaseEvent(
                    firebaseAnalytics,
                    Const.methodInvoked,
                    firebaseParams
                )
                (context as BottomNavigationActivity).pushFragment(SettingsFragment(), true)
                view.drawer_layout.closeDrawer(GravityCompat.END)
            }
            R.id.linearGetHelp -> {
                firebaseParams.clear()
                firebaseParams.putString(Const.methodInvoked, "getHelpTappedFromMenu")
                CommonUtils.addParamstoFirebaseEvent(
                    firebaseAnalytics,
                    Const.methodInvoked,
                    firebaseParams
                )
                val intent = Intent(context!!, HelpTroubleActivity::class.java)
                intent.putExtra(Const.scrTag, Const.scrDrawerTag)
                startActivity(intent)
                view.drawer_layout.closeDrawer(GravityCompat.END)
            }
        }
    }

    override fun onStart() {
        super.onStart()
          EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: EventBusMessage?) {

        if (event!!.count == 0)
            view.imgNotiDot.visibility = View.GONE
        else
            view.imgNotiDot.visibility = View.VISIBLE
    }
    private fun signoutDialogue() {
        //changed position of positive , negative button due to client requirement
        CommonUtils.showDialog(
            context!!,
            getString(R.string.signOut),
            DialogInterface.OnClickListener { _, _ ->
                firebaseParams.clear()
                firebaseParams.putString(Const.methodInvoked, "signOutTapped")
                CommonUtils.addParamstoFirebaseEvent(
                    firebaseAnalytics,
                    Const.methodInvoked,
                    firebaseParams
                )

                val intent = Intent(context!!, PasscodeActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)

            },
            DialogInterface.OnCancelListener {

            },


            getString(R.string.btnSignOut),
            getString(R.string.btncancel)
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        firebaseAnalytics = FirebaseAnalytics.getInstance(context!!)
    }

    fun pushFragment(fragment: Fragment, isBackStack: Boolean) {
        val fm = (context as BottomNavigationActivity).supportFragmentManager
        val fragmentTransaction = fm.beginTransaction()
        fragmentTransaction.replace(
            view.mainLayout1.id,
            fragment,
            fragment.javaClass.simpleName
        )
        if (isBackStack) {
            fragmentTransaction.addToBackStack(fragment.javaClass.simpleName)
        }
        fragmentTransaction.commit()
    }
}