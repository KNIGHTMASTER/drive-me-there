package id.co.zisal.dmt_component.ui.handler.login;


import android.app.Dialog;
import android.content.Context;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.widget.Toast;

import id.co.zisal.dmt_common.constant.ApplicationConstant;
import id.co.zisal.dmt_common.constant.ApplicationConstant.LogTag;
import id.co.zisal.dmt_common.constant.ApplicationConstant.Rest.DTO.Request.Login;
import id.co.zisal.dmt_common.constant.ApplicationConstant.TransferKeys;
import id.co.zisal.dmt_common.constant.GeneralConstant;
import id.co.zisal.dmt_common.constant.GeneralConstant.BinaryValue;
import id.co.zisal.dmt_common.util.GeneralValidation;
import id.co.zisal.dmt_component.R;
import id.co.zisal.dmt_component.ui.activity.impl.NavigatorActivity;
import id.co.zisal.dmt_dao.DAOComponent;
import id.co.zisal.dmt_dao.DAOModule;
import id.co.zisal.dmt_dao.DaggerDAOComponent;
import id.co.zisal.dmt_dao.impl.DAOUser;
import id.co.zisal.dmt_model.ModelUser;
import id.co.zisal.dmt_rest.bgp.base.DialogGenericPost;
import id.co.zisal.dmt_rest.bgp.impl.BGPLogin;
import id.co.zisal.dmt_rest.bgp.impl.BGPLogin2;
import id.co.zisal.dmt_rest.dto.app.DTOUserLogin;
import id.co.zisal.dmt_rest.dto.request.login.DTORequestLogin;
import id.co.zisal.dmt_rest.dto.request.login.DTORequestLogin2;
import id.co.zisal.dmt_rest.dto.response.DTOBaseResponse;
import id.co.zisal.dmt_rest.post.IGenericPost;

import org.parceler.Parcels;

import id.co.zisal.dmt_rest.util.DMTHUDProgressDialog;
import id.co.zisal.dmt_util.network.DaggerNetworkComponent;
import id.co.zisal.dmt_util.network.NetworkComponent;
import id.co.zisal.dmt_util.network.NetworkConnectivity;
import id.co.zisal.dmt_util.network.NetworkModule;
import retrofit.RetrofitError;

/**
 * Created on 9/30/2015 : 5:42 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <RESPONSE>
 */
public abstract class ALoginHandler<RESPONSE> implements ILoginHandler, IGenericPost<RESPONSE> {

    private String userName;
    private String password;
    private ModelUser modelUser;
    private IGenericPost iGenericPost;
    private GeneralValidation generalValidation;

    DAOComponent daoComponent;
    DAOUser daoUser;
    NetworkComponent networkComponent;
    NetworkConnectivity networkConnectivity;

    protected ALoginHandler() {
        generalValidation = new GeneralValidation();
        daoComponent = DaggerDAOComponent.builder().dAOModule(new DAOModule(getContext())).build();
        networkComponent = DaggerNetworkComponent.builder().networkModule(new NetworkModule(getContext())).build();
        daoUser = daoComponent.provideDAOUser();
        networkConnectivity = networkComponent.provideNetworkConnectivity();
    }

    @Override
    public void doLogin() {
        if(!generalValidation.isEmptyEditText(getTxtUserName())){
            userName = getTxtUserName().getText().toString().trim();
            if (generalValidation.isValidEmail(userName)) {
                if (!generalValidation.isEmptyEditText(getTxtPassword())) {
                    password = getTxtPassword().getText().toString().trim();
                    if (networkConnectivity.isConnected()) {
                        //daoUser = new DAOUser(getContext());
                        try {
                            modelUser = (ModelUser) daoUser.getAllData().get(0);
                            daoUser.updateEntity(initBaseUser(modelUser));
                        } catch (Exception e) {
                            modelUser = new ModelUser();
                            daoUser.insertEntity(initBaseUser(modelUser));
                        }
                        final DMTHUDProgressDialog progressDialog = DMTHUDProgressDialog.show(
                                ALoginHandler.this.getContext(),
                                ALoginHandler.this.getContext().getResources().getString(R.string.login_pd_message),
                                false,
                                null);
                        iGenericPost = new DialogGenericPost(progressDialog);
                        new BGPLogin2(this) {
                            @Override
                            public Context getContext() {
                                return ALoginHandler.this.getContext();
                            }

                            @Override
                            public Dialog getProgressDialog() {
                                return progressDialog;
                            }

                            @Override
                            public DTORequestLogin2 getDTORequestLogin() {
                                DTORequestLogin2 dtoRequestLogin = new DTORequestLogin2();
                                dtoRequestLogin.setEmail(userName);
                                dtoRequestLogin.setPassword(password);
                                return dtoRequestLogin;
                            }
                        }.execute();
                    } else {
                        Toast.makeText(getContext(), R.string.internet_unavailable, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), R.string.password_empty, Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(getContext(), R.string.email_format_not_valid, Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getContext(), R.string.email_empty, Toast.LENGTH_SHORT).show();
        }
        /*byPassLogin();*/
    }

    private ModelUser initBaseUser(ModelUser modelUser){
        modelUser.setUserName(userName);
        modelUser.setChipperAuth(userName, password);
        return modelUser;
    }

    @Override
    public void onChecked(boolean isChecked) {
        if (!isChecked) {
            getTxtPassword().setTransformationMethod(PasswordTransformationMethod.getInstance());
        } else {
            getTxtPassword().setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public void onPostSuccess(RESPONSE p_Response) {
        if(p_Response != null){
            iGenericPost.onPostSuccess(p_Response);
            DTOBaseResponse dtoResponseLogin = (DTOBaseResponse) p_Response;
            Log.i(LogTag.DMT_INFO, dtoResponseLogin.toString());
            if(dtoResponseLogin.getResponseCode() == GeneralConstant.WebServiceCode.SUCCESS){
                modelUser = (ModelUser) daoUser.getAllData().get(0);
                modelUser.setLoginStatus(BinaryValue.ONE);
                modelUser.setUserName(userName);
                modelUser.setChipperAuth(userName, password);
                daoUser.updateEntity(modelUser);

                DTOUserLogin DTOUserLogin = new DTOUserLogin();
                DTOUserLogin.setUserName(modelUser.getUserName());
                DTOUserLogin.setUserCode(modelUser.getUserCode());

                NavigatorActivity navigatorActivity = new NavigatorActivity();
                navigatorActivity.setParameter(getContext());
                navigatorActivity.gotoNextActivity(
                        getSuccessClass(),
                        TransferKeys.USER_LOGIN, Parcels.wrap(DTOUserLogin)
                );
            }
        }
    }

    @Override
    public void onPostFailure(RetrofitError p_RetrofitError) {
        iGenericPost.onPostFailure(p_RetrofitError);
        Log.e(LogTag.DMT_ERROR, p_RetrofitError.getMessage());
        Toast.makeText(getContext(), p_RetrofitError.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }

    private void byPassLogin(){
        DTOUserLogin DTOUserLogin = new DTOUserLogin();
        DTOUserLogin.setUserName(Login.SAMPLE_USER);
        DTOUserLogin.setUserCode(Login.SAMPLE_ROLE);

        //daoUser = new DAOUser(getContext());
        modelUser = (ModelUser) daoUser.getAllData().get(0);
        modelUser.setLoginStatus(GeneralConstant.BinaryValue.ONE);
        modelUser.setUserName(DTOUserLogin.getUserName());
        modelUser.setUserCode(DTOUserLogin.getUserCode());
        daoUser.updateEntity(modelUser);

        NavigatorActivity navigatorActivity = new NavigatorActivity();
        navigatorActivity.setParameter(getContext());
        navigatorActivity.gotoNextActivity(
                getSuccessClass(),
                ApplicationConstant.TransferKeys.USER_LOGIN, Parcels.wrap(DTOUserLogin)
        );
    }
}
