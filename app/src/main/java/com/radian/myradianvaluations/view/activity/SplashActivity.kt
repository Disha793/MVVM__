package com.radian.myradianvaluations.view.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.radian.myradianvaluations.BuildConfig
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.constants.NotificationConstants
import com.radian.myradianvaluations.utils.Pref
import org.json.JSONObject

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        Handler(Looper.getMainLooper()).postDelayed({
            if (intent.getStringExtra("data") != null) {
                val jsonObject = JSONObject(intent.getStringExtra("data"))
                Log.e("JsonObject at Splash", jsonObject.toString())
                val resultIntent = Intent(this, SplashActivity::class.java)
                resultIntent.putExtra(Const.idTag, jsonObject.getInt(Const.idTag))
                resultIntent.putExtra(
                    Const.notificationidTag,
                    jsonObject.getInt(Const.notificationidTag)
                )
                when (jsonObject.getString(NotificationConstants.notiTagAbbr)) {
                    //Putting screen tag by checking badge of order
                    //In drawer activity through screen tag we will push fragment
                    NotificationConstants.notiAbbrOpenOrder -> {

                        resultIntent.putExtra(Const.scrTag, NotificationConstants.notiScrOpenOrder)

                        startActivity(resultIntent)

                    }
                    NotificationConstants.notiAbbrAcceptOrder -> {
                        resultIntent.putExtra(
                            Const.scrTag,
                            NotificationConstants.notiScrAccept
                        )
                        startActivity(resultIntent)
                    }
                    NotificationConstants.notiAbbrNote -> {
                        resultIntent.putExtra(
                            Const.scrTag,
                            NotificationConstants.notiScrNote
                        )
                        startActivity(resultIntent)
                    }
                    NotificationConstants.notiAbbrREVISION -> {
                        resultIntent.putExtra(
                            Const.scrTag,
                            NotificationConstants.notiScrRevisionOrdrDetil
                        )

                        startActivity(resultIntent)
                    }
                    NotificationConstants.notiAbbrDOCUMENT -> {
                        resultIntent.putExtra(
                            Const.scrTag,
                            NotificationConstants.notiScrDocument
                        )

                        startActivity(resultIntent)
                    }
                    NotificationConstants.notiAbbrLOE -> {
                        val url =
                            BuildConfig.HOST + "mobile/Dashboard/GetDownloadOLEDocument?OrderGenID=" + jsonObject.getString(
                                "orderGenId"
                            ) + "&ItemSrNo=" + jsonObject.getInt("itemSrNo") + "&UserId=" + jsonObject.getInt(
                                "userId"
                            ) + "&ServiceRequestType=" + jsonObject.getInt("serviceRequestType")
                        resultIntent.putExtra(
                            Const.scrTag,
                            NotificationConstants.notiScrLoe
                        )
                        resultIntent.putExtra(Const.loeUrlTag, url)
                        startActivity(resultIntent)
                    }
                    NotificationConstants.notiAbbrLate -> {
                        resultIntent.putExtra(
                            Const.scrTag,
                            NotificationConstants.notiScrLate
                        )
                        resultIntent.putExtra(
                            NotificationConstants.notiTagOrderCount,
                            jsonObject.getInt(NotificationConstants.notiTagOrderCount)
                        )
                        startActivity(resultIntent)
                    }
                    NotificationConstants.notiAbbrDue -> {
                        resultIntent.putExtra(
                            Const.scrTag,
                            NotificationConstants.notiScrDue
                        )
                        resultIntent.putExtra(
                            NotificationConstants.notiTagOrderCount,
                            jsonObject.getInt(NotificationConstants.notiTagOrderCount)
                        )
                        startActivity(resultIntent)

                    }
                    NotificationConstants.notiAbbrScheduled -> {
                        redirectOrderDetail(resultIntent)
                    }
                    NotificationConstants.notiAbbrCompleted -> {
                        redirectOrderDetail(resultIntent)
                    }
                    NotificationConstants.notiAbbrGroup -> {
                        resultIntent.putExtra(
                            Const.scrTag,
                            NotificationConstants.notiScrAccept
                        )
                        startActivity(resultIntent)
                    }


                }

            } else if (!Pref.getValue(this, Pref.IS_FIRST_TIME, false)) {
                startActivity(Intent(this, LoginActivity::class.java))
            } else {

                startActivity(Intent(this, PasscodeActivity::class.java))

               // overridePendingTransition(R.anim.slide_up, R.anim.no_change)
            }

        }, 3000)


    }
    private fun redirectOrderDetail(resultIntent: Intent) {
        resultIntent.putExtra(
            Const.scrTag,
            NotificationConstants.notiScrOrderDetail
        )
        startActivity(resultIntent)
    }
}