package com.radian.myradianvaluations.view.fragment

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.analytics.FirebaseAnalytics
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.SearchFilterResponse
import com.radian.myradianvaluations.adapter.MessageListAdapter
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.extensions.toastShort
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.view.activity.BottomNavigationActivity
import com.radian.myradianvaluations.view.activity.PasscodeActivity
import com.radian.myradianvaluations.viewmodel.MessageListViewModel
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import kotlinx.android.synthetic.main.fragment_message_list.view.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class MessageListFragment : Fragment(), View.OnClickListener {
    private var postParam = HashMap<String, Any?>()
    private var countMessageTitle = ""
    lateinit var firebaseAnalytics: FirebaseAnalytics
    private val firebaseParams = Bundle()
    private lateinit var messageListViewModel: MessageListViewModel
    override fun onClick(p0: View?) {
        //onClick event

    }

    internal lateinit var view: View
    private val classTag = this.javaClass.name
    private val messageList = ArrayList<SearchFilterResponse.Data.OrderList.Order>()
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        firebaseAnalytics = FirebaseAnalytics.getInstance(context!!)
        firebaseParams.clear()
        firebaseParams.putString(Const.screenLaunched, "Message")
        CommonUtils.addParamstoFirebaseEvent(
            firebaseAnalytics,
            Const.screenLaunched,
            firebaseParams
        )
        messageList.clear()
        messageListViewModel =
            ViewModelProvider(context as BottomNavigationActivity).get(MessageListViewModel::class.java)
        messageListViewModel.init(context as BottomNavigationActivity)
        view.recyclerview.adapter =
            MessageListAdapter(
                context!!,
                messageList,
                view,
                this@MessageListFragment
            )
        //Disha: For next release
//        if (messageList.isEmpty())
//            getMessageList()

        CommonUtils.hideKeybord(
            (context as BottomNavigationActivity).window.decorView.rootView,
            context!!
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_message_list, container, false)
        (context as BottomNavigationActivity).txtClear.setOnClickListener(this)
        setToolbar()
        return view
    }

    private fun setMessageCount(count: String) {

        if (count.equals("1")) {
            countMessageTitle = "<b>" + count + "</b>" + " Message"
        } else {
            countMessageTitle = "<b>" + count + "</b>" + " Messages"
        }

        view.txtOrderCount.setText(
            HtmlCompat.fromHtml(
                countMessageTitle,
                HtmlCompat.FROM_HTML_MODE_LEGACY
            )
        )
    }

    private fun setToolbar() {
        (context as BottomNavigationActivity).bottomNavigationView.visibility = View.GONE
        (context as BottomNavigationActivity).txtTitle.text = getString(R.string.messages)
        (context as BottomNavigationActivity).txtClear.visibility = View.VISIBLE
        (context as BottomNavigationActivity).layout_toolbar.visibility = View.VISIBLE
        (context as BottomNavigationActivity).imgBack.visibility = View.VISIBLE

    }

    fun getMessageList() {
        LoadingDialog.show(context as BottomNavigationActivity)
        messageListViewModel.getMessageList().let {
            it?.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                LoadingDialog.dismissDialog()
                if (it.status.equals(APIStatus.ok, true)) {
                    messageList.clear()
                    messageList.addAll(it.data.orderList.messageList)
                    view.recyclerview.adapter?.notifyDataSetChanged()
                    setMessageCount(messageList.size.toString())
                    showNoMsg()
                } else if (it.status.equals(APIStatus.unauth, true)) {
                    context!!.toastShort(it.errorInfo.get(0).errorMessage)

                    var intent = Intent(context!!, PasscodeActivity::class.java)
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(intent)
                }
            })
            if (it == null) {
                LoadingDialog.dismissDialog()
                LoadingDialog.dismissDialog()
                CommonUtils.showOkDialog(
                    context!!,
                    getString(R.string.please_try_again),
                    DialogInterface.OnClickListener { _, _ ->
                        getMessageList()

                    },
                    getString(R.string.ok)
                )
            }
        }

    }


    private fun showNoMsg() {
        if (messageList.isEmpty()) {
            view.txtNoMsg.visibility = View.VISIBLE
            (context as BottomNavigationActivity).txtClear.visibility = View.GONE
            view.txtOrderCount.visibility = View.GONE
        } else {
            view.txtNoMsg.visibility = View.GONE
            (context as BottomNavigationActivity).txtClear.visibility = View.VISIBLE
            view.txtOrderCount.visibility = View.VISIBLE


        }
    }


    override fun onResume() {
        super.onResume()
        CommonUtils.hideKeybord(
            (context as BottomNavigationActivity).window.decorView.rootView,
            context!!
        )

    }

}