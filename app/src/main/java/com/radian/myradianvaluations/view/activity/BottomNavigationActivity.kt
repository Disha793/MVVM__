package com.radian.myradianvaluations.view.activity

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.analytics.FirebaseAnalytics
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.NotiStatusResponse
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.constants.NotificationConstants
import com.radian.myradianvaluations.extensions.toastShort
import com.radian.myradianvaluations.network.APIList
import com.radian.myradianvaluations.network.RetrofitBase
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.utils.LogUtils
import com.radian.myradianvaluations.utils.Pref
import com.radian.myradianvaluations.view.fragment.*
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BottomNavigationActivity : AppCompatActivity(), View.OnClickListener {
    internal var isFromNoti = false
    internal var isFromSeeMore = false
    private val requestCodeLoe = 1001
    val fm = supportFragmentManager
    var bottomview: BottomNavigationView? = null

    //For firebase analytics
    private val firebaseParams = Bundle()
    private var firebaseAnalytics: FirebaseAnalytics = FirebaseAnalytics.getInstance(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        bottomview = bottomNavigationView
        bottomNavigationView.itemIconTintList = null
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_home -> {
                    pushFragment(HomeFragment(), false)
                }
                R.id.action_orders -> {
                    pushFragment(OrdersFragment(), true)
                }
                R.id.action_new -> {
                    pushFragment(NewOrderFragment(), true)
                }
                R.id.action_rewards -> {
                    pushFragment(RewardsFragment(), true)
                }

            }
            return@setOnNavigationItemSelectedListener true
        }
        intent.extras.let {
            if (it?.getString(Const.scrTag) != null) {
                checkIntentData(it)
            } else {
                pushFragment(HomeFragment(), true)

            }

        }
        imgBack.setOnClickListener(this)
    }

    fun pushFragment(fragment: Fragment, isBackStack: Boolean) {
        val fragmentTransaction = fm.beginTransaction()
        fragmentTransaction.replace(mainLayout.id, fragment, fragment.javaClass.getSimpleName())
        if (isBackStack) {
            fragmentTransaction.addToBackStack(fragment.javaClass.simpleName)
        }
        fragmentTransaction.commit()
    }

    private fun clearFragmentBackStack() {

        for (i in 0 until fm.backStackEntryCount - 1) {
            fm.popBackStack()
        }
    }

    private fun checkIntentData(it: Bundle) {
        isFromNoti = true
        updateReadFlag(it.getInt(Const.notificationidTag))


        when (it.getString(Const.scrTag)) {
            NotificationConstants.notiScrAccept -> {
                pushFragment(NewOrderDetailFragment.newInstance(it.getInt(Const.idTag)), false)
            }
            NotificationConstants.notiScrOpenOrder -> {
                pushFragment(
                        ManageOrderFragment.newInstance(
                                (it.getInt(Const.idTag))
                        ), false
                )
            }
            NotificationConstants.notiScrRevisionOrdrDetil -> {
                pushFragment(
                        RevisedOrderDetailFragment.newInstance(it.getInt(Const.idTag)), false
                )
            }
            NotificationConstants.notiScrDocument -> {
                pushFragment(
                        OrderDocumentListFragment.newInstance(it.getInt(Const.idTag)), false
                )
            }
            NotificationConstants.notiScrLoe -> {
                try {
                    val browserIntent = Intent(Intent.ACTION_VIEW)
                    browserIntent.setDataAndType(
                        Uri.parse(it.getString(Const.loeUrlTag)),
                        "application/pdf"
                    )
                    startActivityForResult(browserIntent, requestCodeLoe)
                } catch (e: Exception) {
                    pushFragment(HomeFragment(), true)
                }


            }
            NotificationConstants.notiScrNote -> {
                pushFragment(MessageListFragment(), false)
            }
            NotificationConstants.notiScrLate -> {
                when (it.getInt(NotificationConstants.notiTagOrderCount)) {
                    1 -> {
                        pushFragment(
                                ManageOrderFragment.newInstance(
                                        it.getInt(Const.idTag)
                                ), false
                        )
                    }
                    else -> {
                        pushFragment(OrdersFragment(), false)

                    }

                }
            }
            NotificationConstants.notiScrDue -> {
                when (it.getInt(NotificationConstants.notiTagOrderCount)) {
                    1 -> {
                        pushFragment(
                                ManageOrderFragment.newInstance(
                                        it.getInt(Const.idTag)
                                ), false
                        )
                    }
                    else -> {
                        pushFragment(OrdersFragment(), false)

                    }
                }

            }
            NotificationConstants.notiScrOrderDetail -> {
                pushFragment(
                        ManageOrderFragment.newInstance(
                                it.getInt(Const.idTag)
                        ), false
                )
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == requestCodeLoe) {
            pushFragment(HomeFragment(), true)
        }
    }

    override fun onBackPressed() {
        if (isFromNoti) {
            isFromNoti = false
            pushFragment(HomeFragment(), false)

        } else {
            if (fm.getBackStackEntryCount() <= 1) {
                signoutDialogue()
            } else {

                if (!isFromSeeMore && bottomNavigationView.visibility == View.VISIBLE) {
                    clearFragmentBackStack()
                    bottomNavigationView.selectedItemId = R.id.action_home
                } else {
                    isFromSeeMore = false
                    fm.popBackStack()
                }

            }
        }

    }

    private fun signoutDialogue() {
        //changed position of positive , negative button due to client requirement
        CommonUtils.showDialog(
            this,
            getString(R.string.signOut),
            DialogInterface.OnClickListener { _, _ ->
                firebaseParams.clear()
                firebaseParams.putString(Const.methodInvoked, "signOutTapped")
                CommonUtils.addParamstoFirebaseEvent(
                    firebaseAnalytics,
                    Const.methodInvoked,
                    firebaseParams
                )

                intent = Intent(this, PasscodeActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)

            },
            DialogInterface.OnCancelListener {

            },


            getString(R.string.btnSignOut),
            getString(R.string.btncancel)
        )
    }

    private fun updateReadFlag(notificationId: Int) {
        val responseData = MutableLiveData<NotiStatusResponse>()
        LoadingDialog.show(this)
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitBase.getClient().create(APIList::class.java)
                .updateReadFlag(
                    Pref.getValue(this@BottomNavigationActivity, Pref.AUTH_TOKEN, "")!!,
                    Pref.getValue(this@BottomNavigationActivity, Pref.PHONE_NUMBER, "")!!,
                    CommonUtils.getDeviceUUID(this@BottomNavigationActivity),
                    Pref.getValue(this@BottomNavigationActivity, Pref.MOBILE_USER_ID, 0)!!,
                    notificationId,
                    "Y"
                )
            responseData.postValue(call.body())
        }
        responseData.let {
            it?.observe(this, Observer {
                LoadingDialog.dismissDialog()
                if (it.status.equals(APIStatus.ok, true)) {
                    //Notification read badge updated successfully
                } else if (it.status.equals(APIStatus.unauth, true)) {
                   toastShort( it.errorInfo.get(0).errorMessage)

                    var intent =
                        Intent(this@BottomNavigationActivity, PasscodeActivity::class.java)
                    intent.flags =
                        Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }

            })
        }


    }

    fun showBadge(
        context: Context?,
        bottomNavigationView: BottomNavigationView,
        @IdRes itemId: Int
    ) {
        LogUtils.logD("InSideBottom", "")
        removeBadge(bottomNavigationView, itemId)
        val itemView: BottomNavigationItemView = bottomNavigationView.findViewById(itemId)
        val badge: View = LayoutInflater.from(context)
            .inflate(R.layout.layout_news_badge, bottomNavigationView, false)
        itemView.addView(badge)

    }

    fun removeBadge(
        bottomNavigationView: BottomNavigationView,
        @IdRes itemId: Int
    ) {
        val itemView: BottomNavigationItemView = bottomNavigationView.findViewById(itemId)
        if (itemView.childCount == 3) {
            itemView.removeViewAt(2)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.imgBack -> {
                if (isFromNoti) {
                    isFromNoti = false
                    pushFragment(HomeFragment(), false)
                } else {
                    fm.popBackStack()
                }
            }
        }
    }
}