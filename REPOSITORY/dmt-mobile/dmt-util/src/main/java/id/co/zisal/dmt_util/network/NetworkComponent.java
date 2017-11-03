package id.co.zisal.dmt_util.network;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;

/**
 * <p>
 *     Injector <code>Class</code> for Network Connectivity
 * </p>
 * Created on 2/8/2016 : 9:04 AM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Singleton
@Component(modules = {NetworkModule.class})
public interface NetworkComponent {

    NetworkConnectivity provideNetworkConnectivity();

    void inject(Context p_Context);
}
