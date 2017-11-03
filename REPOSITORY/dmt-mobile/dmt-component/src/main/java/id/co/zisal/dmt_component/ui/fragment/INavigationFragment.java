package id.co.zisal.dmt_component.ui.fragment;

import android.support.v4.app.Fragment;

import id.co.zisal.dmt_component.ui.activity.INavigation;

/**
 * Created by Achmad Fauzi on 5/7/2015 : 4:55 PM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface INavigationFragment extends INavigation {

    void gotoNextFragment(int containerId, Fragment fragmentView);

    void gotoPreviousFragment(int containerId, Fragment fragmentView);

}
