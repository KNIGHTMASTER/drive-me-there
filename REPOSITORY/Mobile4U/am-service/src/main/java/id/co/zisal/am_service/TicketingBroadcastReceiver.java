package id.co.zisal.am_service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

import id.co.zisal.am_common.constant.ApplicationConstant;

/**
 * Created on 9/27/2015 : 6:25 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class TicketingBroadcastReceiver extends WakefulBroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        ComponentName component = new ComponentName(context.getPackageName(), TicketingIntentService.class.getName());
        Log.i(ApplicationConstant.LogTag.AM_INFO, context.getResources().getString(R.string.start_broadcast));

        startWakefulService(context, intent.setComponent(component));
    }
}
