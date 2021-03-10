package com.radian.myradianvaluations.view

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.text.Spanned
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.radian.myradianvaluations.BuildConfig
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.adapter.HomeAdapter
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.interfaces.HomeItemClickListener
import com.radian.myradianvaluations.utils.*
import com.radian.myradianvaluations.viewmodel.DashboardViewModel
import com.radian.vendorbridge.Response.DashboardResponseNew
import com.radian.vendorbridge.Response.ManageOrderResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.dialog_app_update.view.*
import kotlinx.android.synthetic.main.fragment_dashboard_new.view.*
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
    internal lateinit var context: Context
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_dashboard_new, container, false)
        dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)
        dashboardViewModel.init(context)
        dashboardViewModel.dashboardData.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
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
                        it.data.profilePicStatus?.let {it1->
                            if (it1.equals("Y", true)) {
                                Picasso.with(view.imgUser.context)
                                    .load(it.data.profileImageUrl?.let { it })
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
                                view.txtNoData.visibility = View.VISIBLE
                                view.txtNoDataDetail.visibility = View.VISIBLE
                            } else {
                                view.txtNoData.visibility = View.GONE
                                view.txtNoDataDetail.visibility = View.GONE
                                dashboardList.addAll(it)
                            }
                        }
                        setUnreadDot(it.data)
                        view.recyclerview.adapter?.notifyDataSetChanged()
                    }

                }

            } else if (it.status.equals(APIStatus.unauth, true)) {
                Toast.makeText(
                    context,
                    it.errorInfo.get(0).errorMessage,
                    Toast.LENGTH_SHORT
                ).show()
                var intent = Intent(context, PasscodeActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
        })
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
                                    RevisedOrderDetailFragment.newInstance(
                                        dashboardList.get(
                                            position
                                        ).itemId!!
                                    ),
                                    true
                                )
                            }
                            DashboardAbbr.document -> {
                                val url =
                                    BuildConfig.HOST + "mobile/Dashboard/GetDownloadDocument?DocId=" + dashboardList.get(
                                        position
                                    ).documentId + "&Name=" + dashboardList[position].documentname + "&UserId=" + dashboardList.get(
                                        position
                                    ).userId
                                val browserIntent = Intent(Intent.ACTION_VIEW)
                                browserIntent.setDataAndType(Uri.parse(url), "application/pdf")
                                context!!.startActivity(browserIntent)
                            }
                            DashboardAbbr.inspection -> {
                                markInspectionComplete(position)
                            }

                        }

                    } else if (actionType == Const.actionRead) {
                        when (abbr) {
                            DashboardAbbr.newOrder -> {
                                if (dashboardList.get(position).isAssigned == 1) {
                                    declineOrder(position)
                                } else {
                                    CommonUtils.displayMessage(
                                        view,
                                        getString(R.string.decline_restrictn_msg)
                                    )
                                }
                            }
                            DashboardAbbr.revision -> {
                                dismissRevisnReq(position)
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

        view.layoutCovid.setOnClickListener(this)
        view.linearUpcoming.setOnClickListener(this)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getDashboardData()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context
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
//        RetrofitBase.getClient().create(APIList::class.java)
//            .getDashboardData(
//                Pref.getValue(context!!, Pref.AUTH_TOKEN, "")!!,
//                Pref.getValue(context!!, Pref.PHONE_NUMBER, "")!!,
//                CommonUtils.getDeviceUUID(context!!),
//                Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0)!!,
//                "",
//                Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0)!!,
//                CommonUtils.getAppVersion(context!!),
//                null
//            )
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(object : Observer<DashboardResponseNew> {
//                override fun onComplete() {
//                    LoadingDialog.dismissDialog()
//                }
//
//                override fun onNext(t: DashboardResponseNew) {
//                    if (t.status.equals(APIStatus.ok, true)) {
//                        if (t.data != null && t.data.isUpdateAndroid) {
//                            callWhatsNewAPI()
//
//                        } else {
//                            dashboardList.clear()
//                            if (t.data != null) {
//                                EventBus.getDefault()
//                                    .post(EventBusMessage(t.data.notificatnCount!!))
//                                if (context != null)
//                                    Pref.setValue(
//                                        context!!,
//                                        Pref.REWARDS_POINTS,
//                                        t.data.rewardsPonits
//                                    )
//                                t.data.name?.let {
//                                    view.txtUser.text = "Hello " + it
//                                }
//                                t.data.profilePicStatus?.let {
//                                    if (it.equals("Y", true)) {
//                                        Picasso.with(view.imgUser.context)
//                                            .load(t.data.profileImageUrl?.let { it })
//                                            .into(view.imgUser)
//                                    }
//                                }
////                                t.data.upcomingAppointment?.let {
////                                    upcomingItemId =
////                                        t.data.upcomingAppointment.itemId?.let { it.toInt() }!!
////                                    setUpcomingInfo(t.data.upcomingAppointment)
////                                }
//
//                                t.data?.dashboardTileList?.let {
//                                    if (it.isEmpty()) {
//                                        view.txtNoData.visibility = View.VISIBLE
//                                        view.txtNoDataDetail.visibility = View.VISIBLE
//                                    } else {
//                                        view.txtNoData.visibility = View.GONE
//                                        view.txtNoDataDetail.visibility = View.GONE
//                                        dashboardList.addAll(it)
//                                    }
//                                }
//                                setUnreadDot(t.data)
//                                view.recyclerview.adapter?.notifyDataSetChanged()
//                            }
//
//                        }
//
//                    } else if (t.status.equals(APIStatus.unauth, true)) {
//                        Toast.makeText(
//                            context!!,
//                            t.errorInfo.get(0).errorMessage,
//                            Toast.LENGTH_SHORT
//                        ).show()
//                        var intent = Intent(context!!, PasscodeActivity::class.java)
//                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
//                        startActivity(intent)
//                    }
//                }
//
//
//                override fun onSubscribe(d: Disposable) {
//                    Log.e("Subscribe", "")
//                    LoadingDialog.show(context!!)
//                }
//
//                override fun onError(e: Throwable) {
//                    Log.e("Error", e.message!!)
//                    LoadingDialog.dismissDialog()
//                    CommonUtils.showOkDialog(
//                        context!!,
//                        getString(R.string.please_try_again),
//                        DialogInterface.OnClickListener { _, _ ->
//                            getDashboardData()
//
//                        },
//                        getString(R.string.ok)
//                    )
//
//                }
//
//            })
        val postParam = HashMap<String, Any?>()
        postParam.put("PhoneNumber", Pref.getValue(context!!, Pref.PHONE_NUMBER, "")!!)
        postParam.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
        postParam.put("MobileUserId", Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0)!!)
        postParam.put("LoginId", "")
        postParam.put("OrganizationIds", Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0)!!)
        postParam.put("AndroidAppversion",CommonUtils.getAppVersion(context!!))
        postParam.put("iOSAppversion", null)
        val gson = Gson()
        dashboardViewModel.getDashboardData(gson.fromJson(gson.toJson(postParam), JsonObject::class.java))
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
        LoadingDialog.show(context)
        dashboardViewModel.getWhatsNewAPI().let {
            it?.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                LoadingDialog.dismissDialog()
                showAppUpdateDialog(it.data.whatsnew)
            }
            )
            if (it == null) {
                LoadingDialog.dismissDialog()
                CommonUtils.displayMessage(view, getString(R.string.please_try_again))
            }
        }


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


    }

    private fun markAsReadDoc(position: Int) {
        postParam.clear()
        postParam.put("PhoneNumber", Pref.getValue(context!!, Pref.PHONE_NUMBER, ""))
        postParam.put("MobileUserId", Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0).toString())
        postParam.put("DocumentIds", dashboardList.get(position).documentId)
        postParam.put("UserIds", dashboardList.get(position).userId)
        postParam.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
        postParam.put(
            "OrganizationIds",
            Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0).toString()
        )

    }

    private fun markInspectionComplete(position: Int) {
        postParam.clear()
        postParam.put("PhoneNumber", Pref.getValue(context, Pref.PHONE_NUMBER, ""))
        postParam.put("DeviceID", CommonUtils.getDeviceUUID(context))
        postParam.put("MobileUserId", Pref.getValue(context, Pref.MOBILE_USER_ID, 0))
        postParam.put("OrganizationIds", Pref.getValue(context, Pref.ORGANIZATN_ID, 0))
        postParam.put("AppointmentDate", dashboardList.get(position).appointmentDate)
        postParam.put("Notes", "")
        postParam.put("ItemId", dashboardList.get(position).itemId!!)
        postParam.put("ActionType", "C")
        postParam.put("TimeZone", TimeZone.getDefault().id)

    }

    private fun notCompleteInspection(position: Int) {
        val itemId = dashboardList.get(position).itemId!!


    }

    private fun dismissRevisnReq(position: Int) {
        val itemId = dashboardList.get(position).itemId

    }
}