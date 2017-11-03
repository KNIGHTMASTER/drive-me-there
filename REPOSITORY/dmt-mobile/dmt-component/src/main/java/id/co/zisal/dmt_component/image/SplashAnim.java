package id.co.zisal.dmt_component.image;

import android.content.Intent;
import android.view.animation.Animation;


import id.co.zisal.dmt_common.component.IDMTComponent;

/**
 * Created on 10/8/2015 : 2:01 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class SplashAnim implements Animation.AnimationListener, IDMTComponent<SplashAnimParameter> {

    private SplashAnimParameter splashAnimParameter;

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        getParameter().getImageView().startAnimation(getParameter().getAnimationFadeOut());
        getParameter().getActivity().finish();
        Intent i = new Intent(getParameter().getActivity(),getParameter().getLoginClass());
        getParameter().getActivity().startActivity(i);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    @Override
    public void setParameter(SplashAnimParameter p_Param) {
        this.splashAnimParameter = p_Param;
    }

    @Override
    public SplashAnimParameter getParameter() {
        return splashAnimParameter;
    }
}
