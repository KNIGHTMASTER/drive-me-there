package id.co.zisal.dmt_component.ui.activity.base;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import id.co.zisal.dmt_common.bus.BusProvider;
import id.co.zisal.dmt_common.constant.ApplicationConstant;
import id.co.zisal.dmt_component.ComponentConstant;

import id.co.zisal.dmt_component.R;
import id.co.zisal.dmt_component.app.base.ADMTApplication;
import id.co.zisal.dmt_component.ui.IComponentInjector;
import id.co.zisal.dmt_component.ui.activity.IActivity;
import id.co.zisal.dmt_component.ui.activity.IOrientationActivity;
import id.co.zisal.dmt_component.ui.activity.ISdkInitializer;
import id.co.zisal.dmt_component.ui.activity.impl.NavigatorActivity;

import java.io.Serializable;
import java.util.List;

import butterknife.ButterKnife;
import id.co.zisal.dmt_dao.DAOComponent;
import id.co.zisal.dmt_util.network.NetworkComponent;

/**
 * Created by Achmad Fauzi on 5/7/2015 : 11:13 AM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class ABaseActivity extends AppCompatActivity implements IActivity, IComponentInjector, ISdkInitializer {

    protected Typeface typeface;
    protected List<TextView> textViews;
    protected List<EditText> editTexts;
    protected List<Button> buttons;
    protected NavigatorActivity navigatorActivity;

    protected NetworkComponent networkComponent;
    protected DAOComponent daoComponent;

    protected IOrientationActivity iOrientationActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupSDK();
        setupOrientation();
        setContentView(getViewLayoutId());
        setupTypeFace();

        ButterKnife.bind(this);

        daoComponent = ((ADMTApplication)getApplication()).getDaoComponent();
        injectDAOComponent(daoComponent);
        Log.i(ApplicationConstant.LogTag.DMT_INFO, "Successful inject ".concat(DAOComponent.class.getName()));

        networkComponent = ((ADMTApplication) getApplication()).getNetworkComponent();
        injectNetworkComponent(networkComponent);
        Log.i(ApplicationConstant.LogTag.DMT_INFO, "Successful inject ".concat(NetworkComponent.class.getName()));

        navigatorActivity = new NavigatorActivity();
        navigatorActivity.setParameter(this);
    }


    @Override
    public void injectDAOComponent(DAOComponent p_DAOComponent) {
        /*Not defined yet*/
    }

    @Override
    public void injectNetworkComponent(NetworkComponent p_NetworkComponent) {
        /*Not defined yet*/
    }

    @Override
    protected void onStart() {
        super.onStart();
        onLowMemory();
        initWidget();
    }

    @Override
    protected void onResume() {
        super.onResume();
        BusProvider.getInstance().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        BusProvider.getInstance().unregister(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        BusProvider.getInstance().unregister(this);
    }

    @Override
    public void gotoNextActivity(Class p_Clazz, String p_ExtraKey, String p_ExtraContent) {
        navigatorActivity.gotoNextActivity(p_Clazz, p_ExtraKey, p_ExtraContent);
    }

    @Override
    public void gotoNextActivity(Class p_Clazz, String p_ExtraKey, Serializable p_ExtraContent) {
        navigatorActivity.gotoNextActivity(p_Clazz, p_ExtraKey, p_ExtraContent);
    }

    @Override
    public void gotoNextActivity(Class p_Clazz, String p_ExtraKey, Parcelable p_ExtraContent) {
        navigatorActivity.gotoNextActivity(p_Clazz, p_ExtraKey, p_ExtraContent);
    }

    @Override
    public void exitApplication() {
        navigatorActivity.exitApplication();
    }


    @Override
    public void setupTypeFace() {
        try{
            typeface = Typeface.createFromAsset( getAssets(), initFontAssets()[0] );
            if(getTextViews().size()>0 || getTextViews() != null){
                assignTextViewTypeFace(getTextViews());
            }
            typeface = Typeface.createFromAsset( getAssets(), initFontAssets()[1] );
            if(getEditTexts().size()>0 || getEditTexts() != null){
                assignEditTextTypeFace(getEditTexts());
            }
            typeface = Typeface.createFromAsset( getAssets(), initFontAssets()[2] );
            if(getButtons().size()>0 || getButtons() != null){
                assignButtonTypeFace(getButtons());
            }
        }catch (Exception e){
            Log.w(ApplicationConstant.LogTag.DMT_WARNING, getResources().getString(R.string.no_type_face));
        }
        //release unused objects
        textViews = null;
        editTexts = null;
        buttons = null;
    }

    public List<TextView> getTextViews(){
        return null;
    }

    public List<EditText> getEditTexts(){
        return null;
    }

    public List<Button> getButtons(){
        return null;
    }

    @Override
    public String[] initFontAssets() {
        return new String[]{
                ComponentConstant.fonts.ROBOT_LIGHT,
                ComponentConstant.fonts.ROBOT_LIGHT_ITALIC,
                ComponentConstant.fonts.ROBOT_BOLD
        };
    }


    private void assignTextViewTypeFace( List<TextView> textViews ){
        for ( TextView tv: textViews ){
            tv.setTypeface(typeface);
        }
    }

    private void assignButtonTypeFace( List<Button> buttons ){
        for( Button button: buttons){
            button.setTypeface(typeface);
        }
    }

    private void assignEditTextTypeFace(List<EditText> editTexts){
        for(EditText editText: editTexts){
            editText.setTypeface(typeface);
        }
    }

    @Override
    public void goToLoginView(Class p_LoginViewClass, String p_ExtraKey, String p_ExtraContent) {
        navigatorActivity.goToLoginView(p_LoginViewClass, p_ExtraKey, p_ExtraContent);
    }

    @Override
    public void goToMainView(String p_ExtraKey, String p_ExtraContent) {
        /*Not defined yet*/
    }

    @Override
    public void hideStatusBar() {
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    @Override
    public void setupOrientation() {
        /*Override in Required Activity*/
    }

    @Override
    public void setupSDK() {
        /*Override in Required Activity*/
    }
}
