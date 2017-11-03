package id.co.zisal.dmt.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import butterknife.Bind;
import butterknife.BindString;
import id.co.zisal.dmt.R;

import id.co.zisal.dmt.fragment.home.FragmentHome;
import id.co.zisal.dmt.fragment.notification.FragmentNotification;
import id.co.zisal.dmt.fragment.profile.FragmentProfile;
import id.co.zisal.dmt.fragment.search.FragmentSearch;
import id.co.zisal.dmt.fragment.upload.FragmentUpload;
import id.co.zisal.dmt_component.ui.activity.base.ABaseActivity;
import id.co.zisal.dmt_component.ui.activity.base.OrientationPortrait;
import id.co.zisal.dmt_component.ui.fragment.impl.NavigatorFragment;

/**
 * Created on 2/21/2016 : 7:55 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ActivityHomeBottomBar extends ABaseActivity implements CompoundButton.OnCheckedChangeListener{

    @Bind(R.id.btHome)  RadioButton btHome;
    @Bind(R.id.btUpload) RadioButton btUpload;
    @Bind(R.id.btSearch)  RadioButton btSearch;
    @Bind(R.id.btNotification) RadioButton btNotification;
    @Bind(R.id.btProfile)  RadioButton btProfile;

    @BindString(R.string.home) String strHome;
    @BindString(R.string.upload) String strUpload;
    @BindString(R.string.search) String strSearch;
    @BindString(R.string.notification) String strNotification;
    @BindString(R.string.profile) String strProfile;

    private Fragment fragmentView = null;
    private NavigatorFragment navigatorFragment;
    private final int containerId = R.id.content_frame;

    @Override
    public void initWidget() {
        navigatorFragment = new NavigatorFragment() {
            @Override
            public FragmentActivity getFragmentActivity() {
                return ActivityHomeBottomBar.this;
            }
        };

        btHome.setChecked(true);
        fragmentView = new FragmentHome();
        navigatorFragment.gotoNextFragment(containerId, fragmentView);


        btHome.setOnCheckedChangeListener(this);
        btUpload.setOnCheckedChangeListener(this);
        btSearch.setOnCheckedChangeListener(this);
        btNotification.setOnCheckedChangeListener( this );
        btProfile.setOnCheckedChangeListener(this);
    }

    @Override
    public void setupOrientation() {
        iOrientationActivity = new OrientationPortrait(this);
    }

    @Override
    public int getViewLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void onCheckedChanged(CompoundButton p_CompoundButton, boolean p_IsChecked) {
        if (p_IsChecked) {
            String textSelector = (String) p_CompoundButton.getText();

            if (textSelector.equals(strHome)) {
                fragmentView = new FragmentHome();
            } else if (textSelector.equals(strUpload)) {
                fragmentView = new FragmentUpload();
            } else if (textSelector.equals(strSearch)) {
                fragmentView = new FragmentSearch();
            } else if (textSelector.equals(strNotification)) {
                fragmentView = new FragmentNotification();
            }else if(textSelector.equals(strProfile)) {
                fragmentView = new FragmentProfile();
            }

            navigatorFragment.gotoNextFragment(containerId, fragmentView);
        }
    }
}
