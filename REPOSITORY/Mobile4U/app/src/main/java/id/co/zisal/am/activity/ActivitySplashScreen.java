package id.co.zisal.am.activity;

import android.widget.ImageView;
import android.widget.LinearLayout;

import id.co.zisal.am_component.ui.activity.impl.ABaseSplashScreenActivity;

import butterknife.InjectView;
import id.co.zisal.am.R;

public class ActivitySplashScreen extends ABaseSplashScreenActivity {

    @InjectView(R.id.imgLogo)
    ImageView imgTicketing;

    @InjectView(R.id.linearBackground)
    LinearLayout linearBackground;


    @Override
    public Class getLoginActivity() {
        return ActivityLogin.class;
    }

    @Override
    public Class getHomeActivity() {
        return ActivityHome.class;
    }

    @Override
    public long getDelayTime() {
        return 3000;
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
