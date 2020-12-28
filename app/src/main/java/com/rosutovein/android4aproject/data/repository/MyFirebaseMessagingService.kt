package com.rosutovein.android4aproject.data.repository

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.rosutovein.android4aproject.R
import com.rosutovein.android4aproject.presentation.main.SplashActivity

class MyFirebaseMessagingService : FirebaseMessagingService() {

    private val CANAL = "MyNotifCanal"

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        super.onMessageReceived(remoteMessage)
        val myMessage: String? = remoteMessage?.getNotification()?.getBody()
        Log.d("FirebaseMessage", "Vous venez de recevoir une notification : " + myMessage)

        //Action
        //Rediriger vers SplashActivity
        val intent = Intent(getApplicationContext(), SplashActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        //Créer une notification
        val notificationBuilder = NotificationCompat.Builder(this, CANAL)
        notificationBuilder.setContentTitle("Ma super notif !")
        notificationBuilder.setContentText(myMessage)

        //Ajouter l'action
        notificationBuilder.setContentIntent(pendingIntent)

        //Une icone
        notificationBuilder.setSmallIcon(R.drawable.logo)

        //Envoyer la notification
        val notificationManager: NotificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channelId = getString(R.string.notification_channel_id)
            val channelTitle = getString(R.string.notification_channel_title)
            val channelDescription = getString(R.string.notification_channel_desc)
            val channel = NotificationChannel(channelId, channelTitle, NotificationManager.IMPORTANCE_DEFAULT)
            channel.setDescription(channelDescription)
            notificationManager.createNotificationChannel(channel)
            notificationBuilder.setChannelId(channelId)
        }
        notificationManager.notify(1, notificationBuilder.build())
    }
}