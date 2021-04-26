package com.radian.myradianvaluations.view.fragment

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.text.Spanned
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.radian.myradianvaluations.BuildConfig
import com.radian.myradianvaluations.DashboardResponseNew
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.ManageOrderResponse
import com.radian.myradianvaluations.adapter.HomeAdapter
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.extensions.*
import com.radian.myradianvaluations.interfaces.HomeItemClickListener
import com.radian.myradianvaluations.utils.*
import com.radian.myradianvaluations.view.activity.BottomNavigationActivity
import com.radian.myradianvaluations.view.activity.PasscodeActivity
import com.radian.myradianvaluations.view.activity.WebviewActivity
import com.radian.myradianvaluations.viewmodel.DashboardViewModel
import com.radian.myradianvaluations.viewmodel.DashboardViewModelFactory

import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.dialog_app_update.view.*
import kotlinx.android.synthetic.main.fragment_dashboard_new.view.*
import kotlinx.android.synthetic.main.fragment_order_appointment.view.*
import kotlinx.android.synthetic.main.toolbar_dashboard.view.*
import org.greenrobot.eventbus.EventBus
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class DashboardFragment : Fragment(), View.OnClickListener {
    internal lateinit var view: View
    lateinit internal var updatedialogView: View
    var dashboardList = ArrayList<DashboardResponseNew.Data.DashboardTileList>()
    private val itemId = ArrayList<Int>()
    private var organizationIds = ArrayList<Int>()
    private val classTag = this.javaClass.canonicalName
    private lateinit var rejectnoteList: Array<String?>
    private val postParam = HashMap<String, Any?>()
    private var orderDetail = ManageOrderResponse.Data.OrderDetail()
    private var upcomingItemId = 0
    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var factory: DashboardViewModelFactory
    internal lateinit var context: Context

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_dashboard_new, container, false)
        initViewModel()
        observeDashboardData()
        dashboardItemClick()
        view.layoutCovid.setOnClickListener(this)
        view.linearUpcoming.setOnClickListener(this)
        return view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //Disha: For next release
        getDashboardData()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context
    }

    private fun initViewModel() {
        factory = DashboardViewModelFactory(context!!)
        dashboardViewModel = ViewModelProvider(this, factory).get(DashboardViewModel::class.java)
    }

    private fun dashboardItemClick() {
        view.recyclerview.adapter =
            HomeAdapter(context, dashboardList, object : HomeItemClickListener {
                override fun homeItemClicked(position: Int, abbr: String, actionType: String) {
                    if (actionType == Const.actionView) {
                        when (abbr) {
                            DashboardAbbr.newOrder -> {
                                (context as BottomNavigationActivity).pushFragment(
                                    NewOrderDetailFragment.newInstance(dashboardList.get(position).itemId!!),
                                    true
                                )
                            }
                            DashboardAbbr.revision -> {
                                (context as BottomNavigationActivity).pushFragment(
                                    OrderRevisionRequestFragment.newInstance(
                                        dashboardList.get(
                                            position
                                        ).itemId!!
                                    ),
                                    true
                                )
                            }
                            DashboardAbbr.document -> {
                                try {
                                    val url =
                                        BuildConfig.HOST + "mobile/Dashboard/GetDownloadDocument?DocId=" + dashboardList.get(
                                            position
                                        ).documentId + "&Name=" + dashboardList[position].documentname + "&UserId=" + dashboardList.get(
                                            position
                                        ).userId
                                    val browserIntent = Intent(Intent.ACTION_VIEW)
                                    browserIntent.setDataAndType(Uri.parse(url), "application/pdf")
                                    context!!.startActivity(browserIntent)
                                } catch (e: java.lang.Exception) {
                                    LogUtils.logE(classTag, e)
                                }
//                                val url =
//                                    BuildConfig.HOST + "mobile/Dashboard/GetDownloadDocument?DocId=" + dashboardList.get(
//                                        position
//                                    ).documentId + "&Name=" + dashboardList[position].documentname + "&UserId=" + dashboardList.get(
//                                        position
//                                    ).userId
//                                val intent = Intent(context, WebviewActivity::class.java)
//                                intent.putExtra("webUrl", url)
//                                intent.putExtra(Const.scrTag, Const.scrViewPdf)
//                                startActivity(intent)

                            }
                            DashboardAbbr.inspection -> {
                                //markInspectionComplete(position)
                            }

                        }

                    } else if (actionType == Const.actionRead) {
                        when (abbr) {
                            DashboardAbbr.newOrder -> {
                                if (dashboardList.get(position).isAssigned == 1) {
                                    declineOrder(position)
                                } else {
                                    view.snack(
                                        getString(R.string.decline_restrictn_msg)
                                    ) {}
                                }
                            }
                            DashboardAbbr.revision -> {
                                markAsReadRevisionReq(position)
                            }
                            DashboardAbbr.inspection -> {
                                notCompleteInspection(position)
                            }
                            DashboardAbbr.document -> {
                                markAsReadDoc(position)
                            }
                        }
                    }
                }
            })
    }

    private fun observeDashboardData() {
        dashboardViewModel.dashboardData.observeOnce(
            viewLifecycleOwner,
            androidx.lifecycle.Observer {
                if (it.status.equals(APIStatus.ok, true)) {
                    if (it.data != null && it.data.isUpdateAndroid) {
                        callWhatsNewAPI()
                    } else {
                        dashboardList.clear()
                        if (it.data != null) {
                            EventBus.getDefault()
                                .post(EventBusMessage(it.data.notificatnCount!!))
                            if (context != null)
                                Pref.setValue(
                                    context,
                                    Pref.REWARDS_POINTS,
                                    it.data.rewardsPonits
                                )
                            it.data.name?.let {
                                view.txtUser.text = "Hello " + it
                            }
                            it.data.profilePicStatus?.let { it1 ->
                                if (it1.equals("Y", true)) {
                                    LogUtils.logD(classTag+" profile url",BuildConfig.HOST +it.data.profileImageUrl)
                                    Picasso.with(activity)
                                        .load(BuildConfig.HOST +it.data.profileImageUrl).placeholder(R.drawable.profile_placeholder)
                                        .into(view.imgUser)
                                }
                            }
//                                t.data.upcomingAppointment?.let {
//                                    upcomingItemId =
//                                        t.data.upcomingAppointment.itemId?.let { it.toInt() }!!
//                                    setUpcomingInfo(t.data.upcomingAppointment)
//                                }

                            it.data?.dashboardTileList?.let {
                                if (it.isEmpty()) {
                                    view.txtNoData.makeVisible()
                                    view.txtNoDataDetail.makeVisible()
                                } else {
                                    view.txtNoData.makeGone()
                                    view.txtNoDataDetail.makeGone()
                                    dashboardList.addAll(it)
                                }
                            }
                            setUnreadDot(it.data)
                            view.recyclerview.adapter?.notifyDataSetChanged()
                        }

                    }

                } else if (it.status.equals(APIStatus.unauth, true)) {
                    context.toastShort(it.errorInfo.get(0).errorMessage)

                    var intent = Intent(context, PasscodeActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
            })
        dashboardViewModel.whatsNewResponse.observeOnce(
            viewLifecycleOwner,
            androidx.lifecycle.Observer {
                showAppUpdateDialog(it.data.whatsnew)
            })
        dashboardViewModel.docMarkReadResponse.observeOnce(
            viewLifecycleOwner,
            androidx.lifecycle.Observer {
                if (it.status.equals(APIStatus.ok, true)) {
                    getDashboardData()
                } else if (it.status.equals(APIStatus.unauth, true)) {
                    context.toastShort(it.errorInfo.get(0).errorMessage)
                    var intent = Intent(context!!, PasscodeActivity::class.java)
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(intent)
                }
            })
        dashboardViewModel.rejectOrderResponse.observeOnce(
            viewLifecycleOwner,
            androidx.lifecycle.Observer {
                if (it.status.equals(APIStatus.unauth, true)) {
                    context.toastShort(it.errorInfo.get(0).errorMessage)
                    var intent = Intent(context!!, PasscodeActivity::class.java)
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(intent)
                }
                if (it.status.equals(APIStatus.ok, true)) {
                    getDashboardData()
                }
            })
        dashboardViewModel.revisionMarkReadResponse.observeOnce(
            viewLifecycleOwner,
            androidx.lifecycle.Observer {
                if (it.status == APIStatus.ok) {
                    getDashboardData()

                } else if (it.status.equals(APIStatus.unauth, true)) {
                    context.toastShort(it.errorInfo.get(0).errorMessage)
                    var intent = Intent(context!!, PasscodeActivity::class.java)
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(intent)
                }
            })
        dashboardViewModel.manageOrderResponse.observeOnce(
            viewLifecycleOwner,
            androidx.lifecycle.Observer {
                if (it.status == APIStatus.ok) {
                    orderDetail = it.data.orderDetail
                    (context as BottomNavigationActivity).pushFragment(
                        OrderAppointmentFragment.newInstance(
                            orderDetail
                        ), true
                    )
                } else if (it.status.equals(APIStatus.unauth, true)) {
                    context.toastShort(it.errorInfo.get(0).errorMessage)
                    var intent = Intent(context!!, PasscodeActivity::class.java)
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(intent)
                }

            })
        dashboardViewModel.appointmentResponse.observeOnce(
            viewLifecycleOwner,
            androidx.lifecycle.Observer {
                if (it.status == APIStatus.ok) {
                    getDashboardData()

                } else if (it.status.equals(APIStatus.unauth, true)) {
                    context.toastShort(it.errorInfo.get(0).errorMessage)
                    var intent = Intent(context!!, PasscodeActivity::class.java)
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(intent)
                }
            })
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.layoutCovid -> {
                val intent = Intent(context, WebviewActivity::class.java)
                intent.putExtra(Const.scrTag, Const.scrCovidTag)
                startActivity(intent)
            }
            R.id.linearUpcoming -> {

            }
        }
    }

    private fun getDashboardData() {
        val postParam = HashMap<String, Any?>()
        postParam.put("PhoneNumber", Pref.getValue(context!!, Pref.PHONE_NUMBER, "")!!)
        postParam.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
        postParam.put("MobileUserId", Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0)!!)
        postParam.put("LoginId", "")
        postParam.put("OrganizationIds", Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0)!!)
        postParam.put("AndroidAppversion", CommonUtils.getAppVersion(context!!))
        postParam.put("iOSAppversion", "")

        dashboardViewModel.getDashboardData(postParam)
    }

    private fun setUpcomingInfo(upcomingAppointment: DashboardResponseNew.Data.UpcomingAppointmnt) {
    }

    override fun onResume() {
        super.onResume()
    }

    private fun setUnreadDot(data: DashboardResponseNew.Data) {

        data.orderCount?.let {
            if (it > 0) {
                (context as BottomNavigationActivity).bottomview?.let { it1 ->
                    (context as BottomNavigationActivity).showBadge(
                        context,
                        it1, R.id.action_orders
                    )
                }
            } else {
                (context as BottomNavigationActivity).bottomview?.let {
                    (context as BottomNavigationActivity).removeBadge(it, R.id.action_orders)
                }
            }
        }
        data.newOrderCount?.let {

            if (it > 0) {
                (context as BottomNavigationActivity).bottomview?.let { it1 ->
                    (context as BottomNavigationActivity).showBadge(
                        context,
                        it1, R.id.action_new
                    )
                }
            } else {
                (context as BottomNavigationActivity).bottomview?.let {
                    (context as BottomNavigationActivity).removeBadge(it, R.id.action_new)
                }
            }
        }


    }

    private fun callWhatsNewAPI() {
        val postParam = HashMap<String, Any?>()
        postParam.put("PhoneNumber", Pref.getValue(context!!, Pref.PHONE_NUMBER, ""))
        postParam.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
        postParam.put("MobileUserId", Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0))

        dashboardViewModel.getWhatsNewAPI(postParam)

    }


    private fun showAppUpdateDialog(whatsnew: String) {

        updatedialogView = LayoutInflater.from(context).inflate(R.layout.dialog_app_update, null)
        val builder =
            AlertDialog.Builder(context, R.style.FullScreenDialogTheme)

        builder.setView(updatedialogView)

        val dialog = Dialog(context!!, R.style.FullScreenDialogTheme)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(updatedialogView)
        val lp = dialog.getWindow()!!.getAttributes()
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.MATCH_PARENT
        dialog.getWindow()!!.setAttributes(lp)
        dialog.setCancelable(false)
        dialog.show()
        val sp: Spanned =
            Html.fromHtml(whatsnew)
//updatedialogView.txtDetails.setText(Html.fromHtml("<ul><li>Maintain a healthy weight</li><li>Be physically active</li><li>Follow healthy diet plan</li><li>Reduce sodium In your Diet</li><li>Take prescribed drug as directed</li><li>Total intake of salt in a day is 2.5 gms which can vary up to 5 gms depending on Blood pressure measurement</li></ul>",HtmlCompat.FROM_HTML_MODE_LEGACY))
        updatedialogView.txtDetails.setText(sp)
        updatedialogView.btnAppUpdate.setOnClickListener {
            try {
                val viewIntent =
                    Intent(
                        "android.intent.action.VIEW",
                        Uri.parse("https://play.google.com/store/apps/details?id=com.radian.vendorbridge")
                    )
                startActivity(viewIntent)
            } catch (e: Exception) {
                LogUtils.logE("IntentPlaystore", e)
            }
        }

    }

    private fun declineOrder(position: Int) {
        val postParams = HashMap<String, Any?>()
        postParams.put("PhoneNumber", Pref.getValue(context!!, Pref.PHONE_NUMBER, ""))
        postParams.put("MobileUserId", Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0))
        postParams.put("OrganizationIds", Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0))
        postParams.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
        postParams.put("ItemIds", dashboardList[position].itemId)
        postParams.put("ItemNotes", "")
        postParams.put("ActionType", "R")
        dashboardViewModel.rejectOrder(postParams)
    }

    private fun markAsReadDoc(position: Int) {
        val postParam = HashMap<String, Any?>()
        postParam.put("PhoneNumber", Pref.getValue(context!!, Pref.PHONE_NUMBER, ""))
        postParam.put("MobileUserId", Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0).toString())
        postParam.put("DocumentIds", dashboardList[position].documentId)
        postParam.put("UserIds", dashboardList[position].userId)
        postParam.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
        postParam.put("OrganizationIds", Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0).toString())
        dashboardViewModel.markAsReadDoc(postParam)

    }

    private fun markInspectionComplete(position: Int) {
        var postParams = java.util.HashMap<String, Any?>()
        postParams.put("PhoneNumber", Pref.getValue(context!!, Pref.PHONE_NUMBER, ""))
        postParams.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
        postParams.put("MobileUserId", Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0))
        postParams.put("OrganizationIds", Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0))
        postParams.put("AppointmentDate", view.edtDateTime.text.toString())
        postParams.put("Notes", view.edtNote.text.toString())
        postParams.put("ItemId", orderDetail.itemId)
        postParams.put("ActionType", "")
        postParams.put("TimeZone", TimeZone.getDefault().id)
        dashboardViewModel.addAppointment(postParams)

    }

    private fun notCompleteInspection(position: Int) {
        val itemId = dashboardList.get(position).itemId!!
        val postParam = HashMap<String, Any?>()
        postParam.put("PhoneNumber", Pref.getValue(context!!, Pref.PHONE_NUMBER, "")!!)
        postParam.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
        postParam.put("MobileUserId", Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0)!!)
        postParam.put("OrganizationIds", Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0)!!)
        postParam.put("Itemid", itemId)
        dashboardViewModel.getOrderDetail(postParam)
    }

    private fun markAsReadRevisionReq(position: Int) {
        val postParam = HashMap<String, Any?>()
        postParam.put("PhoneNumber", Pref.getValue(context!!, Pref.PHONE_NUMBER, ""))
        postParam.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
        postParam.put("MobileUserId", Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0))
        postParam.put("OrganizationIds", Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0))
        postParam.put("ActionType", "R")
        postParam.put("Itemid", dashboardList[position].itemId)
        dashboardViewModel.markAsReadRevision(postParam)
    }
}