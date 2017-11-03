package id.co.zisal.dmt_component.ui.activity.base;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import id.co.zisal.dmt_common.constant.ApplicationConstant;
import id.co.zisal.dmt_component.ui.activity.IOrientationActivity;

/**
 * Created on 4/9/2016 : 2:14 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class OrientationPortrait implements IOrientationActivity{

    private AppCompatActivity appCompatActivity;

    public OrientationPortrait(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
        setupOrientation();
    }


    @Override
    public void setupOrientation() {
        appCompatActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Log.i(ApplicationConstant.LogTag.DMT_INFO, "Application Screen is set to ORIENTATION PORTRAIT ");
    }
}
