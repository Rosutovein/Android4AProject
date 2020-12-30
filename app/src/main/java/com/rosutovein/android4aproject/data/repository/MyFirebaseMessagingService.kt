package com.rosutovein.android4aproject.data.repository

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.media.RingtoneManager
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.rosutovein.android4aproject.R
import com.rosutovein.android4aproject.presentation.main.SplashActivity


class MyFirebaseMessagingService : FirebaseMessagingService() {

    /*private val CANAL = "MyNotifCanal"

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
    }*/

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        if(remoteMessage.getNotification() != null){
            //Reception du message envoyé par Firebase
            val message = remoteMessage.getNotification()!!.getBody()
            Log.e("TAG", message)
            this.sendVisualNotification(message)
        }
    }

    private fun sendVisualNotification(messageBody: String?) {
        //Creation d'un intent qui lancera l'application quand l'utilisateur
        //cliquera sur la notification
        val intent = Intent(this, SplashActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)

        //Création d'un style pour l'affichage de la notification
        val inboxStyle = NotificationCompat.InboxStyle()
        inboxStyle.setBigContentTitle(getString(R.string.notification_title))
        inboxStyle.addLine(messageBody)

        //Création d'un canal
        val channelId = getString(R.string.default_notification_channel_id)

        //Construction d'un objet notification
        val notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.logo)
            .setContentTitle(getString(R.string.app_name))
            .setContentText(getString(R.string.notification_title))
            .setAutoCancel(true)
            .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
            .setContentIntent(pendingIntent)
            .setStyle(inboxStyle)

        //Ajout de la notification dans le notification manager et l'afficher
        val notificationManager = (getSystemService(NOTIFICATION_SERVICE) as NotificationManager)!!
        val NOTIFICATION_ID = 7
        val NOTIFICATION_TAG = "FIREBASE0C"
        notificationManager.notify(NOTIFICATION_TAG, NOTIFICATION_ID, notificationBuilder.build())

    }
}