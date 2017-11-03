package id.co.zisal.dmt_component.ui.fragment.impl;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import id.co.zisal.dmt_common.constant.ApplicationConstant;
import id.co.zisal.dmt_component.ComponentConstant;
import id.co.zisal.dmt_component.app.base.ADMTApplication;
import id.co.zisal.dmt_component.ui.IComponentInjector;
import id.co.zisal.dmt_component.ui.fragment.INavigationDrawerFragment;

import java.util.List;

import butterknife.ButterKnife;
import id.co.zisal.dmt_dao.DAOComponent;
import id.co.zisal.dmt_util.network.NetworkComponent;

/**
 * Created on 4/25/2015 : 11:20 PM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class ABaseFragment extends Fragment implements INavigationDrawerFragment, IComponentInjector {

    protected Typeface typeface;
    protected List<TextView> textViews;
    protected List<Button> buttons;
    protected List<EditText> editTexts;
    protected View rootView = null;
    protected NavigatorFragment navigatorFragment;

    protected NetworkComponent networkComponent;
    protected DAOComponent daoComponent;

    protected ABaseFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        try{
            rootView = inflater.inflate( getViewLayoutId(), container, false );
        }catch ( Exception e ){
            if ( container != null ){
                container.removeView( rootView );
            }
            try{
                rootView = inflater.inflate(getViewLayoutId(), container, false);
            }catch (InflateException ie){
                e.printStackTrace();
            }
        }
        getActivity().setTitle(getFragmentTitle());
        ButterKnife.bind(this, rootView);

        networkComponent = ((ADMTApplication)getActivity().getApplication()).getNetworkComponent();
        injectNetworkComponent(networkComponent);
        daoComponent = ((ADMTApplication)getActivity().getApplication()).getDaoComponent();
        injectDAOComponent(daoComponent);

        navigatorFragment = new NavigatorFragment() {
            @Override
            public FragmentActivity getFragmentActivity() {
                return getActivity();
            }
        };

        initializeFragment();

        rootView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT ));
        return rootView;
    }

    @Override
    public void injectDAOComponent(DAOComponent p_DAOComponent) {}

    @Override
    public void injectNetworkComponent(NetworkComponent p_NetworkComponent) {}

    @Override
    public void onStart() {
        super.onStart();
        onLowMemory();
    }

    protected void initializeFragment(){
        try{
            initWidget();
        }catch ( Exception e ){
            e.printStackTrace();
        }

        try {
            typeface = Typeface.createFromAsset(getActivity().getAssets(), initAssetName()[0]);
            if( getTextViews() != null )
                assignContentTypeFace( getTextViews() );

            typeface = Typeface.createFromAsset(getActivity().getAssets(), initAssetName()[1]);
            if( getEditTexts() != null )
                assignEditTextTypeFace(getEditTexts());

            typeface = Typeface.createFromAsset(getActivity().getAssets(), initAssetName()[2]);
            if( getButtons() != null )
                assignButtonTypeFace( getButtons() );
        }catch (Exception e){
            Log.w(ApplicationConstant.LogTag.DMT_WARNING, "No TypeFace Assignment found");
        }

        //release unused objects
        textViews = null;
        editTexts = null;
        buttons = null;
    }

    private void assignEditTextTypeFace(List<EditText> p_EditTexts){
        for(EditText editText: p_EditTexts){
            editText.setTypeface(typeface);
        }
    }

    private void assignContentTypeFace(List<TextView> p_TextViews){
        for ( TextView tv: p_TextViews ){
            tv.setTypeface(typeface);
        }
    }

    private void assignButtonTypeFace(List<Button> p_Buttons){
        for ( Button button : p_Buttons ){
            button.setTypeface(typeface);
        }
    }
    /**
     * Initiate asset names ( font ) which will be used in that activity or Fragment
     * @return String[]
     */
    public String[] initAssetName() {
        return new String[]{
                ComponentConstant.fonts.ROBOT_LIGHT,
                ComponentConstant.fonts.ROBOT_LIGHT_ITALIC,
                ComponentConstant.fonts.ROBOT_BOLD
        };
    }

    @Override
    public List<TextView> getTextViews() {
        return null;
    }

    @Override
    public List<EditText> getEditTexts() {
        return null;
    }

    @Override
    public List<Button> getButtons() {
        return null;
    }

    @Override
    public void gotoNextFragment(int p_ContainerId, Fragment p_FragmentView){
        FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();
        mFragmentManager.beginTransaction().replace(p_ContainerId, p_FragmentView).commit();
    }

    @Override
    public void gotoPreviousFragment(int p_ContainerId, Fragment p_FragmentView) {
        FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();
        mFragmentManager.beginTransaction().replace(p_ContainerId, p_FragmentView).commit();
    }

    @Override
    public void goToMainView(String p_ExtraKey, String p_ExtraContent) {
        navigatorFragment.goToMainView(p_ExtraKey, p_ExtraContent);
    }

    @Override
    public void exitApplication() {
        navigatorFragment.exitApplication();
    }

    @Override
    public void goToLoginView(Class p_LoginViewClass, String p_ExtraKey, String p_ExtraContent) {
        navigatorFragment.goToLoginView(p_LoginViewClass, p_ExtraKey, p_ExtraContent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
