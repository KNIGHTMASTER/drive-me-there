package id.co.zisal.dmt_util.network;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * <p>
 *     Injection module for Network checking
 * </p>
 * s
 * Created on 2/8/2016 : 8:52 AM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Module
public class NetworkModule {

    private Context mContext;

    public NetworkModule(Context p_Context) {
        this.mContext = p_Context;
    }

    @Singleton
    @Provides
    NetworkConnectivity provideNetworkConnectivity(){
        return new NetworkConnectivity(mContext);
    }

}
