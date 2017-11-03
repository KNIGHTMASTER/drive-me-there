package id.co.zisal.am_component.image;

import android.app.Activity;
import android.view.animation.Animation;
import android.widget.ImageView;

/**
 * Created on 10/8/2015 : 2:02 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <LOGIN_CLASS>
 */
public class SplashAnimParameter<LOGIN_CLASS> {
    private Activity activity;
    private ImageView imageView;
    private Animation animationFadeOut;
    private Class<LOGIN_CLASS> loginClass;

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public Animation getAnimationFadeOut() {
        return animationFadeOut;
    }

    public void setAnimationFadeOut(Animation animationFadeOut) {
        this.animationFadeOut = animationFadeOut;
    }

    public Class<LOGIN_CLASS> getLoginClass() {
        return loginClass;
    }

    public void setLoginClass(Class<LOGIN_CLASS> loginClass) {
        this.loginClass = loginClass;
    }
}
