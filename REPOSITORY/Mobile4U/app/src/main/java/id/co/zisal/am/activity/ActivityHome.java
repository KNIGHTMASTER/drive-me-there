package id.co.zisal.am.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import org.parceler.Parcels;

import br.liveo.Model.HelpLiveo;
import br.liveo.interfaces.OnPrepareOptionsMenuLiveo;
import id.co.zisal.am.R;
import id.co.zisal.am.fragment.about.FragmentAbout;
import id.co.zisal.am.fragment.nearestworkshop.FragmentNearestWorkshop;
import id.co.zisal.am.fragment.personalinfo.FragmentPersonalInfo;
import id.co.zisal.am_common.constant.ApplicationConstant.LogTag;
import id.co.zisal.am_common.constant.ApplicationConstant.TransferKeys;
import id.co.zisal.am_component.ui.activity.impl.HomeBaseActivity;
import id.co.zisal.am_component.ui.fragment.impl.MainFragment;
import id.co.zisal.am_component.ui.handler.logut.ALogoutHandler;
import id.co.zisal.am_rest.dto.app.UserLogin;

/**
 * Created on 9/29/2015 : 12:33 AM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ActivityHome extends HomeBaseActivity {

    ALogoutHandler logoutHandler;

    @Override
    protected void onResume() {
        super.onResume();
        logoutHandler.detectLoginStatus();
    }

    @Override
    public void onInt(Bundle bundle) {
        logoutHandler = new ALogoutHandler() {
            @Override
            public Context getContext() {
                return ActivityHome.this;
            }

            @Override
            public Class getLoginClass() {
                return ActivitySplashScreen.class;
            }
        };

        UserLogin userLogin = Parcels.unwrap(
                getIntent().getParcelableExtra(TransferKeys.USER_LOGIN)
        );
        Log.i(LogTag.AM_INFO, "Success Login " + userLogin.toString());

        if(userLogin != null){
            if(userLogin.getUserName() != null){
                this.userName.setText(userLogin.getUserName());
            }
            if(userLogin.getUserCode() != null){
                this.userEmail.setText(userLogin.getUserCode());
            }
        }

        this.userPhoto.setImageResource(id.co.zisal.am_component.R.mipmap.ic_no_user);
        this.userBackground.setImageResource(id.co.zisal.am_component.R.drawable.ic_user_background_first);

        mHelpLiveo = new HelpLiveo();
        mHelpLiveo.add(getString(id.co.zisal.am_component.R.string.personal_info), id.co.zisal.am_component.R.drawable.ic_account_18dp);
        mHelpLiveo.add(getString(R.string.menu_nearest_workshop), R.drawable.ic_receipt_black_18dp);
        mHelpLiveo.add(getString(R.string.menu_tracking_location), R.drawable.ic_play_shopping_bag_black_18dp);
        mHelpLiveo.add(getString(id.co.zisal.am_component.R.string.about), id.co.zisal.am_component.R.drawable.ic_info_18dp);

        with(this)
                .startingPosition(0)
                .addAllHelpItem(mHelpLiveo.getHelp())
                .footerItem(id.co.zisal.am_component.R.string.log_out, id.co.zisal.am_component.R.drawable.ic_exit_to_app_18dp)
                .setOnClickUser(onClickPhoto)
                .setOnPrepareOptionsMenu(onPrepare)
                .setOnClickFooter(onClickFooter)
                .build();
    }

    @Override
    public void onItemClick(int position) {
        Fragment mFragment;
        FragmentManager mFragmentManager = getSupportFragmentManager();

        switch (position){
            case 0:
                mFragment = new FragmentPersonalInfo();
                break;
            case 1:
                mFragment = new FragmentNearestWorkshop();
                break;
            case 2:
                mFragment = new FragmentAbout();
                break;
            case 3:
                mFragment = new FragmentAbout();
                break;

            default:
                mFragment = MainFragment.newInstance(mHelpLiveo.get(position).getName());
                break;
        }

        if (mFragment != null){
            mFragmentManager.beginTransaction().replace(id.co.zisal.am_component.R.id.container, mFragment).commit();
        }

        setElevationToolBar(position != 2 ? 15 : 0);
    }

    private OnPrepareOptionsMenuLiveo onPrepare = new OnPrepareOptionsMenuLiveo() {
        @Override
        public void onPrepareOptionsMenu(Menu menu, int position, boolean visible) {
            Log.i(LogTag.AM_INFO, "On prepare option :menu "+menu.toString()+" pos "+position+" visible "+visible);
        }
    };

    private View.OnClickListener onClickPhoto = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            closeDrawer();
        }
    };

    private View.OnClickListener onClickFooter = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.i(LogTag.AM_INFO, "Click footer");
            closeDrawer();
            logoutHandler.doLogout();
        }
    };
}
