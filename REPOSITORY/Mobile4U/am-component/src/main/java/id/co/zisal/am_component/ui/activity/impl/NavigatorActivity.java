package id.co.zisal.am_component.ui.activity.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;

import id.co.zisal.am_common.component.ITicketingComponent;
import id.co.zisal.am_component.ui.activity.INavigationActivity;

import java.io.Serializable;

/**
 * Created on 10/2/2015 : 3:04 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class NavigatorActivity implements INavigationActivity, ITicketingComponent<Context> {

    private Context context;

    @Override
    public void gotoNextActivity(Class clazz, String extraKey, String extraContent) {
        Intent intent = new Intent( getParameter(), clazz );
        intent.putExtra(extraKey, extraContent);
        getParameter().startActivity(intent);
    }

    @Override
    public void gotoNextActivity(Class clazz, String extraKey, Serializable extraContent) {
        Intent intent = new Intent( getParameter(), clazz );
        intent.putExtra(extraKey, extraContent);
        getParameter().startActivity(intent);
    }

    @Override
    public void gotoNextActivity(Class clazz, String extraKey, Parcelable extraContent) {
        Intent intent = new Intent( getParameter(), clazz );
        intent.putExtra(extraKey, extraContent);
        getParameter().startActivity(intent);
    }

    @Override
    public void goToMainView(String extraKey, String extraContent) {
        /*Not Defined yet*/
    }

    @Override
    public void exitApplication() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        getParameter().startActivity(intent);
    }


    @Override
    public void setParameter(Context _param) {
        this.context = _param;
    }

    @Override
    public Context getParameter() {
        return context;
    }
}
