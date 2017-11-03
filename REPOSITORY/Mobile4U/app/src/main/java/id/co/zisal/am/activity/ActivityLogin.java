package id.co.zisal.am.activity;

import android.content.Context;
import android.widget.EditText;

import id.co.zisal.am_common.constant.GeneralConstant;
import id.co.zisal.am_component.ui.activity.base.ABaseActivity;
import id.co.zisal.am_component.ui.activity.impl.NavigatorActivity;
import id.co.zisal.am_component.ui.handler.login.ALoginHandler;

import butterknife.InjectView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import id.co.zisal.am.R;

/**
 * Created on 9/30/2015 : 5:42 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ActivityLogin extends ABaseActivity{

    @InjectView(R.id.txt_username)
    EditText txtUserName;

    @InjectView(R.id.txt_password)
    EditText txtPassword;


    private ALoginHandler loginHandler;

    @Override
    public void initWidget() {
        loginHandler = new ALoginHandler() {
            @Override
            public Context getContext() {
                return ActivityLogin.this;
            }

            @Override
            public EditText getTxtUserName() {
                return txtUserName;
            }

            @Override
            public EditText getTxtPassword() {
                return txtPassword;
            }

            @Override
            public Class getSuccessClass() {
                return ActivityHome.class;
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
    }

    @OnClick(R.id.lblLearnAbout)
    public void learnTsm(){
        NavigatorActivity navigatorActivity = new NavigatorActivity();
        navigatorActivity.setParameter(this);
        navigatorActivity.gotoNextActivity(
                ActivityIntroTicketing.class,
                GeneralConstant.Punctuation.EMPTY,
                GeneralConstant.Punctuation.EMPTY
        );
    }

}