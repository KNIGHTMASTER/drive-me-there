package id.co.zisal.dmt.action.register.impl;


import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import id.co.zisal.dmt.activity.ActivityLogin;
import id.co.zisal.dmt_common.constant.ApplicationConstant;
import id.co.zisal.dmt_component.ui.activity.impl.NavigatorActivity;
import id.co.zisal.dmt_rest.bgp.impl.BGPRegister;
import id.co.zisal.dmt_rest.dto.request.register.DTORequestRegister;
import id.co.zisal.dmt_rest.dto.response.DTOBaseResponse;
import id.co.zisal.dmt_rest.post.IGenericPost;
import id.co.zisal.dmt_rest.util.DMTHUDProgressDialog;
import id.co.zisal.dmt_service.R;
import id.co.zisal.dmt.action.register.IRegister;
import retrofit.RetrofitError;

/**
 * Created on 4/5/2016 : 12:32 AM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class RegisterUser implements IRegister<ParamRegister>, IGenericPost<DTOBaseResponse> {

    private ParamRegister paramRegister;

    @Override
    public void setParam(ParamRegister p_REGISTER_PARAM) {
        this.paramRegister = p_REGISTER_PARAM;
    }

    @Override
    public ParamRegister getParam() {
        return paramRegister;
    }

    @Override
    public void doRegister() {
        new BGPRegister(this) {
            @Override
            public Context getContext() {
                return getParam().getActivity();
            }

            @Override
            public Dialog getProgressDialog() {
                final DMTHUDProgressDialog progressDialog = DMTHUDProgressDialog.show(
                        getParam().getActivity(),
                        getParam().getActivity().getResources().getString(R.string.please_wait),
                        false,
                        null);
                return progressDialog;
            }

            @Override
            public DTORequestRegister getDTORequestRegister() {
                return getParam().getDtoRequestRegister();
            }
        }.execute();
    }

    @Override
    public void onPostSuccess(DTOBaseResponse p_Response) {
        if (p_Response.getResponseCode() == 0){
            Toast.makeText(getParam().getActivity(), "Registration Successful, please verify your email", Toast.LENGTH_SHORT).show();
            Log.i(ApplicationConstant.LogTag.DMT_INFO, "Registration User Done");
            NavigatorActivity navigatorActivity = new NavigatorActivity();
            navigatorActivity.setParameter(getParam().getActivity());
            navigatorActivity.gotoNextActivity(ActivityLogin.class, "", "");
        }else{
            Toast.makeText(getParam().getActivity(), "Registration Error : "+p_Response.getResponseCode(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPostFailure(RetrofitError p_RetrofitError) {
        Log.e(ApplicationConstant.LogTag.DMT_ERROR, "Registration User Failed");
    }
}
