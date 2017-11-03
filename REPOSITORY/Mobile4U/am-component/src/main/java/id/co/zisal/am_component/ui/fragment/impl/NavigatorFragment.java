package id.co.zisal.am_component.ui.fragment.impl;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import id.co.zisal.am_common.constant.ApplicationConstant;
import id.co.zisal.am_component.ui.fragment.INavigationFragment;

import id.co.zisal.am_component.R;

/**
 * Created on 10/11/2015 : 4:08 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class NavigatorFragment implements INavigationFragment {

    protected FragmentManager mFragmentManager;

    public NavigatorFragment() {
        mFragmentManager = getFragmentActivity().getSupportFragmentManager();
    }

    @Override
    public void gotoNextFragment(int containerId, Fragment fragmentView) {
        mFragmentManager.beginTransaction().replace(containerId, fragmentView).commit();
    }

    @Override
    public void gotoPreviousFragment(int containerId, Fragment fragmentView) {
        mFragmentManager.beginTransaction().replace(R.id.container, fragmentView).commit();
    }

    @Override
    public void goToMainView(String extraKey, String extraContent) {
        Log.i(ApplicationConstant.LogTag.AM_INFO, "Not implemented yet");
    }

    @Override
    public void exitApplication() {
        Log.i(ApplicationConstant.LogTag.AM_INFO, "Not implemented yet");
    }

    public abstract FragmentActivity getFragmentActivity();
}
