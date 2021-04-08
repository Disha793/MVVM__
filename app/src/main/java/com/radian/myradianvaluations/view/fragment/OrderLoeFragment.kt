package com.radian.myradianvaluations.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.extensions.makeGone
import com.radian.myradianvaluations.extensions.makeVisible
import com.radian.myradianvaluations.view.activity.BottomNavigationActivity
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import kotlinx.android.synthetic.main.fragment_order_loe.view.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class OrderLoeFragment : Fragment(), View.OnClickListener {
    internal lateinit var view: View
    private val classTag = this::class.java.canonicalName!!
    private var itemId = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_order_loe, container, false)
        setToolbar()
        arguments?.let {
            itemId = it.getInt(Const.itemIdTag)
        }
        view.btnLOeAccept.setOnClickListener(this)
        view.btnReject.setOnClickListener(this)
        return view
    }

    companion object {
        fun newInstance(itemId: Int): OrderLoeFragment {
            val args = Bundle()
            args.putInt(Const.itemIdTag, itemId)
            val fragment = OrderLoeFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private fun setToolbar() {
        (context as BottomNavigationActivity).layout_toolbar.makeVisible()
        (context as BottomNavigationActivity).bottomNavigationView.makeGone()
        (context as BottomNavigationActivity).txtTitle.text =
            getString(R.string.loe)
        (context as BottomNavigationActivity).imgBack.makeVisible()
        (context as BottomNavigationActivity).txtClear.makeGone()
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btnAccept -> {
                (context as BottomNavigationActivity).pushFragment(
                    NewOrderDetailFragment.newInstance(itemId),
                    true
                )
            }
            R.id.btnReject -> {
                (context as BottomNavigationActivity).onBackPressed()
            }
        }
    }
}