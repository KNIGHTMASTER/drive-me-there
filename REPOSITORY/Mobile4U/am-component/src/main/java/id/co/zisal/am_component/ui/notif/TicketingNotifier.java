package id.co.zisal.am_component.ui.notif;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

import id.co.zisal.am_component.R;

/**
 * Created on 9/28/2015 : 9:20 AM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class TicketingNotifier {

    public void generateNotification(Context context, String message, Class contextClass) {
        int icon = R.mipmap.ic_launcher;
        long when = System.currentTimeMillis();

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        String type = null;
        String msg;
        String title;
        String sender;

        if (message != null) {
            String[] psn = message.split("#");
            sender = psn[0];
            type = psn[1];
            title = psn[2];
            msg = psn[3];

            Notification notification = new Notification(icon, message, when);

            if (Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP) {
                notification.color = Color.parseColor("#143a99");
            }

            Intent notificationIntent = new Intent(context, contextClass);
            notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_ONE_SHOT);
            notification.setLatestEventInfo(context, title, msg, pendingIntent);
            notification.flags |= Notification.FLAG_AUTO_CANCEL;

            notification.defaults |= Notification.DEFAULT_SOUND;
            notificationManager.notify((int) System.currentTimeMillis(), notification);
        }
    }
}