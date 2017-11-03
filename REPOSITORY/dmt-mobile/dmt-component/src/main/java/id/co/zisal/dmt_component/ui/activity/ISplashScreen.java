package id.co.zisal.dmt_component.ui.activity;

import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * <p>
 *     An <code>interface</code> to handle splash screen
 * </p>
 * Created on 10/8/2015 : 2:17 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ISplashScreen {

    /**
     * <p>
     *     Starting animation from any <code>Activity</code> or <code>Fragment</code>
     * </p>
     */
    void startAnimation();

    /**
     * <p>
     *     Retrieving Splash Icon
     * </p>
     * @return ImageView as Splash Icon
     */
    ImageView getSplashIcon();

    /**
     * <p>
     *     Retrieving Background of Splash Screen
     * </p>
     * @return LinearLayout as Splash Background
     */
    LinearLayout getLinearBackground();
}
