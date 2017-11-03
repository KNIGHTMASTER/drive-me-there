package id.co.zisal.am_component.ui.activity;

import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created on 10/8/2015 : 2:17 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ISplashScreen {

    void startAnimation();

    ImageView getSplashIcon();

    LinearLayout getLinearBackground();
}
