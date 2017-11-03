package id.co.zisal.dmt_component.ui.fragment.impl;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import id.co.zisal.dmt_common.constant.ApplicationConstant;
import id.co.zisal.dmt_component.ui.fragment.INavigationFragment;

import id.co.zisal.dmt_component.R;

/**
 * Created on 10/11/2015 : 4:08 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class NavigatorFragment implements INavigationFragment {

    protected FragmentManager mFragmentManager;

    public NavigatorFragment() {
        mFragmentManager = getFragmentActivity().getSupportFragmentManager();
    }

    @Override
    public void gotoNextFragment(int p_ContainerId, Fragment p_FragmentView) {
        mFragmentManager.beginTransaction().replace(p_ContainerId, p_FragmentView).commit();
    }

    @Override
    public void gotoPreviousFragment(int p_ContainerId, Fragment p_FragmentView) {
        mFragmentManager.beginTransaction().replace(p_ContainerId, p_FragmentView).commit();
    }

    @Override
    public void goToMainView(String p_ExtraKey, String p_ExtraContent) {
        Log.i(ApplicationConstant.LogTag.DMT_INFO, "Not implemented yet");
    }

    @Override
    public void exitApplication() {
        Log.i(ApplicationConstant.LogTag.DMT_INFO, "Not implemented yet");
    }

    @Override
    public void goToLoginView(Class p_LoginViewClass, String p_ExtraKey, String p_ExtraContent) {
        Intent intent = new Intent( getFragmentActivity(), p_LoginViewClass);
        intent.putExtra(p_ExtraKey, p_ExtraContent);
        getFragmentActivity().startActivity(intent);
    }

    public abstract FragmentActivity getFragmentActivity();
}
