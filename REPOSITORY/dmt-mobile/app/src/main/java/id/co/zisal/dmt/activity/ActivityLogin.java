package id.co.zisal.dmt.activity;

import android.content.Context;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import id.co.zisal.dmt.R;
import id.co.zisal.dmt_common.constant.GeneralConstant;
import id.co.zisal.dmt_component.ui.activity.base.ABaseActivity;
import id.co.zisal.dmt_component.ui.handler.login.ALoginHandler;

/**
 * Created on 9/30/2015 : 5:42 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ActivityLogin extends ABaseActivity{

    @Bind(R.id.txt_email)
    EditText txtEmail;

    @Bind(R.id.txt_password)
    EditText txtPassword;

    private ALoginHandler loginHandler;

    @Override
    public void initWidget() {
        hideStatusBar();
        loginHandler = new ALoginHandler() {
            @Override
            public Context getContext() {
                return ActivityLogin.this;
            }

            @Override
            public EditText getTxtUserName() {
                return txtEmail;
            }

            @Override
            public EditText getTxtPassword() {
                return txtPassword;
            }

            @Override
            public Class getSuccessClass() {
                return ActivityHomeBottomBar.class;
            }
        };
    }

    @Override
    public int getViewLayoutId() {
        return R.layout.activity_login;
    }

    @OnCheckedChanged(R.id.chkShowPassword)
    public void onChecked(boolean isChecked){
        loginHandler.onChecked(isChecked);
    }

    @OnClick(R.id.btLogin)
    public void doLogin(){
        loginHandler.doLogin();
        /*navigatorActivity.gotoNextActivity(
                ActivityCurrentPlacePicker.class,
                GeneralConstant.Punctuation.EMPTY,
                GeneralConstant.Punctuation.EMPTY
        );*/
    }

    @OnClick(R.id.lblLearnAbout)
    public void learnDmt(){
        navigatorActivity.gotoNextActivity(
                ActivityIntro.class,
                GeneralConstant.Punctuation.EMPTY,
                GeneralConstant.Punctuation.EMPTY
        );
    }

    @OnClick(R.id.txtRegister)
    public void doRegister(){
        navigatorActivity.gotoNextActivity(
            ActivityTabRegister.class,
            GeneralConstant.Punctuation.EMPTY,
            GeneralConstant.Punctuation.EMPTY
        );
    }

}