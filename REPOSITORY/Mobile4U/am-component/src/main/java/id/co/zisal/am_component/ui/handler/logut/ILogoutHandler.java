package id.co.zisal.am_component.ui.handler.logut;

import android.content.Context;

/**
 * Created on 10/8/2015 : 10:57 AM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <SPLASH_CLASS>
 */
public interface ILogoutHandler<SPLASH_CLASS> extends ILogout {
    /**
     * Getting context from Login Activity
     * @return Context
     */
    Context getContext();

    Class<SPLASH_CLASS> getLoginClass();
}
