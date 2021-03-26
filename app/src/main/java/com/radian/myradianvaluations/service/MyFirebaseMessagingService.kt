package com.radian.myradianvaluations.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.TaskStackBuilder
import androidx.core.content.ContextCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.utils.Pref
import com.radian.myradianvaluations.view.activity.SplashActivity
import org.json.JSONObject
import java.util.*

class MyFirebaseMessagingService : FirebaseMessagingService() {
    private lateinit var notificationManager: NotificationManager
    private val ADMIN_CHANNEL_ID = "Radian" + System.currentTimeMillis()
    override fun onNewToken(p0: String) {
        super.onNewToken(p0)
        Pref.setValue(applicationContext, Pref.FCM_TOKEN, p0)
        Log.d("FCM Token", p0)

    }
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        if (remoteMessage.data != null) {
            Log.e("remotemessage.data", remoteMessage.data.toString())

            showNotificationData(remoteMessage.data)
        }


    }
    private fun showNotificationData(
        data: Map<String, String>
    ) {
        val jsonObject = JSONObject(data)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            setupNotificationChannels()
        }
        val notificationId = Random().nextInt(60000)
        val resultIntent = Intent(this, SplashActivity::class.java)
        resultIntent.putExtra("data", jsonObject.toString())


        val resultPendingIntent: PendingIntent? = TaskStackBuilder.create(this).run {
            // Add the intent, which inflates the back stack
            addNextIntentWithParentStack(resultIntent)
            // Get the PendingIntent containing the entire back stack
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }
        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(this, ADMIN_CHANNEL_ID)
            //a resource for your custom small icon
            .setSmallIcon(getNotificationIcon()) //a resource for your custom small icon
            .setColor(ContextCompat.getColor(applicationContext, R.color.colorPrimary))
            .setContentTitle(data!!.get("title")) //the "title" value you sent in your notification
            .setContentText(data.get("body")) //dittos
            .setAutoCancel(true)  //dismisses the notification on click
            .setSound(defaultSoundUri)
            .setContentIntent(resultPendingIntent)
            .setColor(resources.getColor(R.color.colorPrimary))
//            .setNumber(data!!.get("badge")!!.toInt())


        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.notify(
            notificationId /* ID of notification */,
            notificationBuilder.build()
        )
    }
    private fun getNotificationIcon(): Int {
        val useWhiteIcon = Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
        return if (useWhiteIcon) R.mipmap.ic_stat_ic_launcher else R.mipmap.ic_launcher
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private fun setupNotificationChannels() {
        val adminChannelName = "Radian"
        val adminChannelDescription = "Radian"
        val adminChannel: NotificationChannel
        adminChannel = NotificationChannel(
            ADMIN_CHANNEL_ID,
            adminChannelName,
            NotificationManager.IMPORTANCE_HIGH
        )
        adminChannel.description = adminChannelDescription
        adminChannel.enableLights(true)
        adminChannel.lightColor = getColor(R.color.colorPrimary)
        adminChannel.enableVibration(true)
        adminChannel.setShowBadge(true)

        adminChannel.canShowBadge()
        notificationManager.createNotificationChannel(adminChannel)
    }
}






