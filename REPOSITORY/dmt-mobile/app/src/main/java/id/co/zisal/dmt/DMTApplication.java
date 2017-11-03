package id.co.zisal.dmt;

import android.content.Context;

import id.co.zisal.dmt_component.app.base.ADMTApplication;

/**
 * <p>
 *     An Application Context
 * </p>
 * Created on 9/28/2015 : 7:50 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DMTApplication extends ADMTApplication {

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

}
