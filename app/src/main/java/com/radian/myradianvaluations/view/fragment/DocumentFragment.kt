package com.radian.myradianvaluations.view.fragment

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.google.android.material.tabs.TabLayout
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.view.activity.BottomNavigationActivity
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import kotlinx.android.synthetic.main.fragment_document.view.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class DocumentFragment:Fragment() ,TabLayout.OnTabSelectedListener{
    private val classTag = this.javaClass.name
    internal lateinit var view: View
    internal lateinit var pagerAdapter: Pager

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_document, container, false)
        pagerAdapter =
            Pager(this.childFragmentManager, context!!)
        setToolbar()
        setUpViewPager()
        setupTabs()

        return view
    }

    private fun setToolbar() {
        (context as BottomNavigationActivity).layout_toolbar.visibility = View.VISIBLE
        (context as BottomNavigationActivity).txtTitle.visibility = View.VISIBLE
        (context as BottomNavigationActivity).txtTitle.setText(resources.getString(R.string.docTitle))
        (context as BottomNavigationActivity).bottomNavigationView.visibility = View.GONE
        (context as BottomNavigationActivity).imgBack.visibility = View.VISIBLE
        (context as BottomNavigationActivity).txtClear.visibility = View.GONE

    }

    private fun setUpViewPager() {
        view.pager.adapter = pagerAdapter


    }

    override fun onTabReselected(p0: TabLayout.Tab?) {
//Reselection of tab
    }

    override fun onTabUnselected(p0: TabLayout.Tab?) {
        //change color and indicator
        p0?.customView?.findViewById<TextView>(R.id.tabText)?.setTextColor(Color.BLACK)
        p0?.customView?.findViewById<ImageView>(R.id.tabIcon)?.setColorFilter(Color.BLACK)
    }

    override fun onTabSelected(p0: TabLayout.Tab?) {
        //change color and indicator
        p0?.customView?.findViewById<TextView>(R.id.tabText)
            ?.setTextColor(ContextCompat.getColor(context!!, R.color.colorPrimary))
        p0?.customView?.findViewById<ImageView>(R.id.tabIcon)
            ?.setColorFilter(ContextCompat.getColor(context!!, R.color.colorPrimary))

    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun setupTabs() {
        view.tabLayout.setupWithViewPager(view.pager)
        view.tabLayout.addOnTabSelectedListener(this)
        for (i in 0 until view.tabLayout.tabCount) {
            val tab = view.tabLayout.getTabAt(i)
            tab?.setCustomView(pagerAdapter.getTabView(i))
        }
        view.tabLayout.getTabAt(view.tabLayout.selectedTabPosition)
            ?.customView?.findViewById<TextView>(R.id.tabText)
            ?.setTextColor(ContextCompat.getColor(context!!, R.color.colorPrimary))
        view.tabLayout.getTabAt(view.tabLayout.selectedTabPosition)
            ?.customView?.findViewById<ImageView>(R.id.tabIcon)
            ?.setColorFilter(ContextCompat.getColor(context!!, R.color.colorPrimary))

    }

    inner class Pager(fm: FragmentManager, context: Context) : FragmentPagerAdapter(fm) {
        val context = context
        override fun getItem(p0: Int): Fragment {
            when (p0) {
                0 -> {
                    return EODocFragment()
                }
                1 -> {
                    return W9DocFragment()
                }
                2 -> {
                    return LicenceFragment()
                }

            }
            return EODocFragment()
        }


        override fun getCount(): Int {
            return 3
        }

        override fun getItemPosition(
            item
            : Any
        ): Int {
            return PagerAdapter.POSITION_NONE
        }

        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        internal fun getTabView(position: Int): View {
            // Given you have a custom layout in `res/layout/custom_tab.fileprovider` with a TextView and ImageView
            val tabView = LayoutInflater.from(context).inflate(R.layout.tab_layout, null)
            val tabText = tabView.findViewById(R.id.tabText) as TextView
            val tabIcon = tabView.findViewById(R.id.tabIcon) as ImageView
            tabIcon.visibility = View.GONE
            when (position) {
                0 -> {
                    tabText.setText(context.resources.getString(R.string.eo))


                }
                1 -> {
                    tabText.setText(context.resources.getString(R.string.w9))


                }
                2 -> {
                    tabText.setText(context.resources.getString(R.string.licence))


                }
            }


            return tabView
        }


    }
}