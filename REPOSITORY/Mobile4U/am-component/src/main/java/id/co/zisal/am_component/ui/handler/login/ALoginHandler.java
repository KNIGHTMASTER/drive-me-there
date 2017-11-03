package id.co.zisal.am_component.ui.handler.login;


import android.app.Dialog;
import android.content.Context;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.widget.Toast;

import id.co.zisal.am_common.constant.ApplicationConstant;
import id.co.zisal.am_common.constant.GeneralConstant;
import id.co.zisal.am_common.util.GeneralValidation;
import id.co.zisal.am_component.ui.activity.impl.NavigatorActivity;
import id.co.zisal.am_dao.impl.DAOUser;
import id.co.zisal.am_model.ModelUser;
import id.co.zisal.am_rest.bgp.base.DialogGenericPost;
import id.co.zisal.am_rest.bgp.impl.BGPLogin;
import id.co.zisal.am_rest.dto.app.UserLogin;
import id.co.zisal.am_rest.dto.request.login.DTORequestLogin;
import id.co.zisal.am_rest.dto.response.DTOBaseResponse;
import id.co.zisal.am_rest.dto.response.login.DTOResponseLogin;
import id.co.zisal.am_rest.post.IGenericPost;
import id.co.zisal.am_rest.post.IPostLogin;

import org.parceler.Parcels;

import id.co.zisal.am_component.R;

import id.co.zisal.am_rest.util.TicketingHUDProgressDialog;
import id.co.zisal.am_util.network.NetworkConnectivity;
import retrofit.RetrofitError;

/**
 * Created on 9/30/2015 : 5:42 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <RESPONSE>
 */
public abstract class ALoginHandler<RESPONSE> implements ILoginHandler, IPostLogin<RESPONSE> {

    private String userName;
    private String password;
    private DAOUser daoUser;
    private ModelUser modelUser;
    private IGenericPost iGenericPost;

    protected ALoginHandler() {
    }

    @Override
    public void doLogin() {
        GeneralValidation generalValidation = new GeneralValidation();
        NetworkConnectivity networkConnectivity = new NetworkConnectivity(getContext());
        if(!generalValidation.isEmptyEditText(getTxtUserName())){
            userName = getTxtUserName().getText().toString().trim();
            if(!generalValidation.isEmptyEditText(getTxtPassword())){
                password = getTxtPassword().getText().toString().trim();
                if(networkConnectivity.isConnected()){
                    daoUser = new DAOUser(getContext());
                    try{
                        modelUser = (ModelUser) daoUser.getAllData().get(0);
                        daoUser.updateEntity(initBaseUser(modelUser));
                    }catch (Exception e){
                        modelUser = new ModelUser();
                        daoUser.insertEntity(initBaseUser(modelUser));
                    }
                    final TicketingHUDProgressDialog ticketingHUDProgressDialog = TicketingHUDProgressDialog.show(
                            ALoginHandler.this.getContext(),
                            ALoginHandler.this.getContext().getResources().getString(R.string.login_pd_message),
                            false,
                            null);
                    iGenericPost = new DialogGenericPost(ticketingHUDProgressDialog);
                    new BGPLogin(this) {
                        @Override
                        public Context getContext() {
                            return ALoginHandler.this.getContext();
                        }

                        @Override
                        public Dialog getProgressDialog() {
                            return ticketingHUDProgressDialog;
                        }

                        @Override
                        public DTORequestLogin getDTORequestLogin() {
                            DTORequestLogin dtoRequestLogin = new DTORequestLogin();
                            dtoRequestLogin.setUserName(userName);
                            dtoRequestLogin.setPassword(password);
                            return dtoRequestLogin;
                        }
                    }.execute();
                }else{
                    Toast.makeText(getContext(), R.string.internet_unavailable, Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(getContext(), R.string.password_empty, Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getContext(), R.string.user_name_empty, Toast.LENGTH_SHORT).show();
        }
        //byPassLogin();
    }

    private ModelUser initBaseUser(ModelUser modelUser){
        modelUser.setUserName(userName);
        modelUser.setChipperAuth(userName, getTxtPassword().getText().toString().trim());
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
    public void onPostSuccess(RESPONSE response) {/*
        if(response != null){
            iGenericPost.onPostSuccess(response);
            DTOResponseLogin dtoResponseLogin = (DTOResponseLogin) response;
            Log.i(ApplicationConstant.LogTag.AM_INFO, dtoResponseLogin.toString());
            if(dtoResponseLogin.getResponseCode() == GeneralConstant.BinaryValue.ZERO){
                modelUser = (ModelUser) daoUser.getAllData().get(0);
                modelUser.setLoginStatus(GeneralConstant.BinaryValue.ONE);
                modelUser.setUserName(dtoResponseLogin.getUserDatas().get(0).getUserName());
                modelUser.setUserCode(dtoResponseLogin.getUserDatas().get(0).getRoleData().getCode());
                daoUser.updateEntity(modelUser);

                UserLogin userLogin = new UserLogin();
                userLogin.setUserName(modelUser.getUserName());
                userLogin.setUserCode(modelUser.getUserCode());

                NavigatorActivity navigatorActivity = new NavigatorActivity();
                navigatorActivity.setParameter(getContext());
                navigatorActivity.gotoNextActivity(
                        getSuccessClass(),
                        ApplicationConstant.TransferKeys.USER_LOGIN, Parcels.wrap(userLogin)
                );
            }
        }*/

        if(response != null){
            iGenericPost.onPostSuccess(response);
            DTOBaseResponse dtoResponseLogin = (DTOBaseResponse) response;
            Log.i(ApplicationConstant.LogTag.AM_INFO, dtoResponseLogin.toString());
            if(dtoResponseLogin.getResponseCode() == GeneralConstant.BinaryValue.ZERO){
                modelUser = (ModelUser) daoUser.getAllData().get(0);
                modelUser.setLoginStatus(GeneralConstant.BinaryValue.ONE);
                modelUser.setUserName(userName);
                modelUser.setUserCode("ADMIN");
                daoUser.updateEntity(modelUser);

                UserLogin userLogin = new UserLogin();
                userLogin.setUserName(modelUser.getUserName());
                userLogin.setUserCode(modelUser.getUserCode());

                NavigatorActivity navigatorActivity = new NavigatorActivity();
                navigatorActivity.setParameter(getContext());
                navigatorActivity.gotoNextActivity(
                        getSuccessClass(),
                        ApplicationConstant.TransferKeys.USER_LOGIN, Parcels.wrap(userLogin)
                );
            }
        }
    }

    @Override
    public void onPostFailure(RetrofitError retrofitError) {
        iGenericPost.onPostFailure(retrofitError);
        Log.e(ApplicationConstant.LogTag.AM_ERROR, retrofitError.getMessage());
        Toast.makeText(getContext(), retrofitError.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }

    private void byPassLogin(){
        UserLogin userLogin = new UserLogin();
        userLogin.setUserName(ApplicationConstant.Rest.DTO.Request.Login.SAMPLE_USER);
        userLogin.setUserCode(ApplicationConstant.Rest.DTO.Request.Login.SAMPLE_ROLE);

        daoUser = new DAOUser(getContext());
        modelUser = (ModelUser) daoUser.getAllData().get(0);
        modelUser.setLoginStatus(GeneralConstant.BinaryValue.ONE);
        modelUser.setUserName(userLogin.getUserName());
        modelUser.setUserCode(userLogin.getUserCode());
        daoUser.updateEntity(modelUser);

        NavigatorActivity navigatorActivity = new NavigatorActivity();
        navigatorActivity.setParameter(getContext());
        navigatorActivity.gotoNextActivity(
                getSuccessClass(),
                ApplicationConstant.TransferKeys.USER_LOGIN, Parcels.wrap(userLogin)
        );
    }
}
