package com.radian.myradianvaluations.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.radian.myradianvaluations.constants.Const

class RevisedOrderDetailFragment : Fragment() {
    companion object {
        fun newInstance(itemId: Int): RevisedOrderDetailFragment {
            val args = Bundle()
            args.putInt(Const.itemIdTag, itemId)
            val fragment =
                RevisedOrderDetailFragment()
            fragment.arguments = args
            return fragment
        }
    }
}