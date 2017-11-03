package id.co.zisal.dmt_service.bgp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

import id.co.zisal.dmt_common.constant.ApplicationConstant.LogTag;
import id.co.zisal.dmt_service.R;

/**
 *
 * Created on 9/27/2015 : 6:25 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DMTBroadcastReceiver extends WakefulBroadcastReceiver {

    @Override
    public void onReceive(Context p_Context, Intent p_Intent) {
        ComponentName component = new ComponentName(p_Context.getPackageName(), DMTIntentService.class.getName());
        Log.i(LogTag.DMT_INFO, p_Context.getResources().getString(R.string.start_broadcast));

        startWakefulService(p_Context, p_Intent.setComponent(component));
    }
}
