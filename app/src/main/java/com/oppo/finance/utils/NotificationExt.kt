package com.oppo.finance.utils

import android.R
import android.annotation.TargetApi
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.BitmapFactory
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.oppo.finance.App
import com.oppo.finance.ui.main.MainActivity
import java.lang.reflect.Constructor


/** Components of a notification are :-
 *  Small Icon
 *  App Name (Given by System)
 *  Timestamp
 *  Large Icon
 *  Content Title
 *  Content Text
 */

@TargetApi(Build.VERSION_CODES.O)
@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
fun showNotification(context: Context, data: NotificationData) {
    val intent = Intent(context, data.activity as Class<*>)
    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK

    val notificationChannel = NotificationChannel(
        NOTIFICATION_CHANNEL_ID,
        NOTIFICATION_CHANNEL_NAME,
        NotificationManager.IMPORTANCE_DEFAULT
    )

    val pendingIntent: PendingIntent? =
        PendingIntent.getActivity(context, 1, intent, 0)

    val notification: NotificationCompat.Builder? =
        NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
            .setContentText(data.content)
            .setContentTitle(data.title)
            .setContentIntent(pendingIntent)
            .setChannelId(NOTIFICATION_CHANNEL_ID)
            .setStyle(data.style)
            .setSmallIcon(data.icon)

    if (data.style != null)
        notification!!.setStyle(data.style)

    val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    notificationManager.createNotificationChannel(notificationChannel)
    notificationManager.notify(data.id, notification!!.build())
}

/**
 * Notification big text Style
 */
fun bigTextStyle(bigText: String): NotificationCompat.Style {
    return NotificationCompat.BigTextStyle()
        .bigText(bigText)
}


/**
 * Notification big Picture Style
 */
fun bigPictureStyle(context: Context, image: Int): NotificationCompat.Style {
    return NotificationCompat.BigPictureStyle()
        .bigPicture(BitmapFactory.decodeResource(context.resources, image))
}

data class NotificationData(
    val id: Int,
    val title: String,
    val content: String,
    val icon: Int = R.mipmap.sym_def_app_icon,
    val activity: Any = MainActivity::class.java,
    val style: NotificationCompat.Style? = null
)
//fun main() {
//    showNotification(
//        context = App.context,
//        data = NotificationData(
//            id = 0,
//            title = "Header Notification ",
//            content = "Content of the notification",
//            style = null
//        )
//    )
//}