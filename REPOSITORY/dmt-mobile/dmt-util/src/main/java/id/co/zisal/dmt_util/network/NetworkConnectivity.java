package id.co.zisal.dmt_util.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import javax.inject.Inject;

/**
 * <p>
 *     Checking network connectivity
 * </p>
 *
 * Created on 6/22/2015 : 9:34 AM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class NetworkConnectivity {

    private Context context;

    @Inject
    public NetworkConnectivity(Context p_Context) {
        this.context = p_Context;
    }

    /**
     * <p>
     *     Check network connectivity whether device is connected or not
     * </p>
     *
     * @return <code>boolean</code>
     * true if connected to network
     */
    public boolean isConnected(){
        boolean enabled = true;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if ((info == null || !info.isConnected() || !info.isAvailable())){
            enabled = false;
        }
        return enabled;
    }
}
