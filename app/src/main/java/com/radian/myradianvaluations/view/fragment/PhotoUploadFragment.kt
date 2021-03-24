package com.radian.myradianvaluations

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
import com.radian.myradianvaluations.extensions.makeGone
import com.radian.myradianvaluations.extensions.makeVisible
import com.radian.myradianvaluations.view.activity.BottomNavigationActivity
import com.radian.myradianvaluations.view.fragment.AllAndSubPhotosFragment
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import kotlinx.android.synthetic.main.fragment_document.view.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class PhotoUploadFragment : Fragment(), TabLayout.OnTabSelectedListener {
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
        (context as BottomNavigationActivity).layout_toolbar.makeVisible()
        (context as BottomNavigationActivity).txtTitle.makeVisible()
        (context as BottomNavigationActivity).txtTitle.setText(resources.getString(R.string.photoUploadTitle))
        (context as BottomNavigationActivity).bottomNavigationView.makeGone()
        (context as BottomNavigationActivity).imgBack.makeVisible()
        (context as BottomNavigationActivity).txtClear.makeGone()
    }

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

    private fun setUpViewPager() {
        view.pager.adapter = pagerAdapter
    }

    inner class Pager(fm: FragmentManager, context: Context) : FragmentPagerAdapter(
        fm,
        FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) {
        val context = context
        override fun getItem(p0: Int): Fragment {
            when (p0) {
                0 -> {
                    return AllAndSubPhotosFragment()
                }
                1 -> {
                    return AllAndSubPhotosFragment()
                }


            }
            return AllAndSubPhotosFragment()
        }


        override fun getCount(): Int {
            return 2
        }

        override fun getItemPosition(
            item
            : Any
        ): Int {
            return PagerAdapter.POSITION_NONE
        }

        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        internal fun getTabView(position: Int): View {
            val tabView = LayoutInflater.from(context).inflate(R.layout.tab_layout, null)
            val tabText = tabView.findViewById(R.id.tabText) as TextView
            val tabIcon = tabView.findViewById(R.id.tabIcon) as ImageView
            tabIcon.makeGone()
            when (position) {
                0 -> {
                    tabText.setText(context.resources.getString(R.string.all_photos))


                }
                1 -> {
                    tabText.setText(context.resources.getString(R.string.sub_photos))

                }


            }


            return tabView
        }


    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        tab?.customView?.findViewById<TextView>(R.id.tabText)
            ?.setTextColor(ContextCompat.getColor(context!!, R.color.colorPrimary))
        tab?.customView?.findViewById<ImageView>(R.id.tabIcon)
            ?.setColorFilter(ContextCompat.getColor(context!!, R.color.colorPrimary))

    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
        //change color and indicator
        tab?.customView?.findViewById<TextView>(R.id.tabText)?.setTextColor(Color.BLACK)
        tab?.customView?.findViewById<ImageView>(R.id.tabIcon)?.setColorFilter(Color.BLACK)

    }

    override fun onTabReselected(tab: TabLayout.Tab?) {

    }
}