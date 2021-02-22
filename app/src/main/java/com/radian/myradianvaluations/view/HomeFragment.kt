package com.radian.myradianvaluations.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.firebase.analytics.FirebaseAnalytics
import com.radian.myradianvaluations.BuildConfig
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.utils.Pref
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.toolbar_dashboard.view.*

class HomeFragment :Fragment(){
    internal lateinit var view: View
    internal lateinit var firebaseAnalytics: FirebaseAnalytics
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_home, container, false)
        (context as BottomNavigationActivity).layout_toolbar.visibility = View.GONE
        (context as BottomNavigationActivity).bottomNavigationView.visibility = View.VISIBLE
        if (Pref.getValue(context!!, Pref.PROFILE_PIC_STATUS, "").equals("Y", true)) {
            loadProfileImage()
        }
        pushFragment(DashboardFragment(), false)
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