package com.radian.myradianvaluations.view

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.adapter.OrdersAdapter
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.interfaces.OpenOrderClickListener
import com.radian.myradianvaluations.network.APIList
import com.radian.myradianvaluations.network.RetrofitBase
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.utils.LogUtils
import com.radian.myradianvaluations.utils.Pref
import com.radian.vendorbridge.Response.OrderListResponse
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import kotlinx.android.synthetic.main.fragment_orders.view.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class OrdersFragment : Fragment(){
    internal lateinit var view: View
    private val classTag = this::class.java.canonicalName!!
    private val orderList = ArrayList<OrderListResponse.Data.OrderDetail>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_orders, container, false)
        (context as BottomNavigationActivity).bottomNavigationView.visibility = View.VISIBLE

        view.recyclerView.adapter = OrdersAdapter(context!!, object : OpenOrderClickListener {
            override fun onOpenOrderClick(position: Int) {
//                (context as BottomNavigationActivity).pushFragment(
//                    ManageOrderFragment.newInstance(
//                        orderList.get(position).itemId!!
//                    ), true
//                )
            }

        }, orderList)
        showToolbarIcons(getString(R.string.open_orders))

        getOrderList()
        return view
    }

    private fun showToolbarIcons(title: String) {
        (context as BottomNavigationActivity).layout_toolbar.visibility = View.VISIBLE
        (context as BottomNavigationActivity).txtClear.visibility = View.GONE
        (context as BottomNavigationActivity).imgBack.visibility = View.GONE
        (context as BottomNavigationActivity).txtTitle.text = title

    }

    private fun getOrderList() {
        RetrofitBase.getClient().create(APIList::class.java).orderList(
            Pref.getValue(context!!, Pref.AUTH_TOKEN, "")!!,
            Pref.getValue(context!!, Pref.PHONE_NUMBER, "")!!,
            CommonUtils.getDeviceUUID(context!!),
            Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0)!!,
            Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0)!!
        ).subscribeOn(io.reactivex.schedulers.Schedulers.io())

            .observeOn(AndroidSchedulers.mainThread())

            .subscribe(object : Observer<OrderListResponse> {
                override fun onComplete() {
                    LoadingDialog.dismissDialog()
                }

                override fun onSubscribe(d: Disposable) {
                    LoadingDialog.show(context!!)
                }

                override fun onNext(t: OrderListResponse) {
                    if (t.status == APIStatus.ok) {
                        orderList.clear()
                        orderList.addAll(t.data.orderDetails)
                        view.recyclerView.adapter?.notifyDataSetChanged()
                        if(orderList.isEmpty())
                        {
                            view.txtNoOpenOrdr.visibility= View.VISIBLE
                        }
                        else
                        {
                            view.txtNoOpenOrdr.visibility= View.GONE
                        }
                    } else if (t.status.equals(APIStatus.unauth, true)) {
                        Toast.makeText(
                            context!!,
                            t.errorInfo.get(0).errorMessage,
                            Toast.LENGTH_SHORT
                        ).show()
                        var intent = Intent(context!!, PasscodeActivity::class.java)
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        startActivity(intent)
                    }

                }

                override fun onError(e: Throwable) {

                    LogUtils.logE(classTag, e.message!!, e)
                    LoadingDialog.dismissDialog()
                    CommonUtils.showOkDialog(
                        context!!,
                        getString(R.string.please_try_again),
                        DialogInterface.OnClickListener { _, _ ->

                        },
                        getString(R.string.ok)
                    )
                }

            })

    }
}