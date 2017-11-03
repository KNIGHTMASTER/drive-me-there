package id.co.zisal.dmt.activity;

import android.os.Bundle;
import android.widget.Toast;

import com.github.paolorotolo.appintro.AppIntro2;

import id.co.zisal.dmt.R;
import id.co.zisal.dmt.fragment.intro.FragmentIntro1;
import id.co.zisal.dmt.fragment.intro.FragmentIntro2;
import id.co.zisal.dmt.fragment.intro.FragmentIntro3;
import id.co.zisal.dmt_common.constant.GeneralConstant;
import id.co.zisal.dmt_component.ui.activity.impl.NavigatorActivity;

/**
 * Created on 10/13/2015 : 11:06 AM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ActivityIntro extends AppIntro2 {

    @Override
    public void init(Bundle bundle) {
        addSlide(new FragmentIntro1());
        addSlide(new FragmentIntro2());
        addSlide(new FragmentIntro3());

        showDoneButton(true);

        setFadeAnimation();

        setVibrate(true);
        setVibrateIntensity(30);
    }


    @Override
    public void onDonePressed() {
        goToLoginActivity();
    }

    private void goToLoginActivity(){
        NavigatorActivity navigatorActivity = new NavigatorActivity();
        navigatorActivity.setParameter(this);
        navigatorActivity.gotoNextActivity(
                ActivityLogin.class,
                GeneralConstant.Punctuation.EMPTY,
                GeneralConstant.Punctuation.EMPTY
        );
    }
}
