package id.co.zisal.am;

import android.content.Context;

import id.co.zisal.am_component.app.base.AAMApplication;

/**
 * Created on 9/28/2015 : 7:50 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class AMApplication extends AAMApplication {

    @Override
    public Context getContext() {
        return getApplicationContext();
    }
}
