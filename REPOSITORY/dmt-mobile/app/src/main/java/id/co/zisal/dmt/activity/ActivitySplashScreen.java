package id.co.zisal.dmt.activity;

import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.Bind;
import id.co.zisal.dmt_common.constant.ApplicationConstant;
import id.co.zisal.dmt_component.ui.activity.impl.ABaseSplashScreenActivity;

import id.co.zisal.dmt.R;

public class ActivitySplashScreen extends ABaseSplashScreenActivity {

    @Bind(R.id.imgSplashScreen)
    ImageView imgTicketing;

    @Bind(R.id.linearBackground)
    LinearLayout linearBackground;


    @Override
    public Class getLoginActivity() {
        return ActivityLogin.class;
    }

    @Override
    public Class getHomeActivity() {
        return ActivityStartMap.class;
    }

    @Override
    public long getDelayTime() {
        return ApplicationConstant.ViewController.SPLASH_SCREEN_DELAY_TIME;
    }

    @Override
    public int getViewLayoutId() {
        return R.layout.activity_splash_screen;
    }

    @Override
    public ImageView getSplashIcon() {
        return imgTicketing;
    }

    @Override
    public LinearLayout getLinearBackground() {
        return linearBackground;
    }
}
