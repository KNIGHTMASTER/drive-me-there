package id.co.zisal.dmt_component.ui.handler.logut;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import id.co.zisal.dmt_common.constant.ApplicationConstant;
import id.co.zisal.dmt_common.constant.GeneralConstant;
import id.co.zisal.dmt_component.R;
import id.co.zisal.dmt_component.ui.fragment.impl.NavigatorFragment;
import id.co.zisal.dmt_dao.DAOComponent;
import id.co.zisal.dmt_dao.DAOModule;
import id.co.zisal.dmt_dao.DaggerDAOComponent;
import id.co.zisal.dmt_dao.impl.DAOUser;
import id.co.zisal.dmt_model.ModelUser;
import id.co.zisal.dmt_rest.bgp.impl.BGPLogout;
import id.co.zisal.dmt_rest.post.IGenericPost;
import id.co.zisal.dmt_rest.util.DMTHUDProgressDialog;
import id.co.zisal.dmt_util.network.DaggerNetworkComponent;
import id.co.zisal.dmt_util.network.NetworkComponent;
import id.co.zisal.dmt_util.network.NetworkConnectivity;
import id.co.zisal.dmt_util.network.NetworkModule;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created on 4/11/2016 : 9:14 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <LOGIN_VIEW>
 */
public class LogoutHandler<LOGIN_VIEW> implements IGenericPost<Response> {

    private DAOUser daoUser;
    private NetworkConnectivity networkConnectivity;
    private NavigatorFragment navigatorFragment;
    private Class<LOGIN_VIEW> loginViewClass;
    private Context context;

    public LogoutHandler(Context p_Context, NavigatorFragment p_NavigatorFragment, Class<LOGIN_VIEW> p_LoginViewClass) {
        this.context = p_Context;
        this.navigatorFragment = p_NavigatorFragment;
        DAOComponent daoComponent= DaggerDAOComponent.builder().dAOModule(new DAOModule(p_Context)).build();
        NetworkComponent networkComponent = DaggerNetworkComponent.builder().networkModule(new NetworkModule(context)).build();
        networkConnectivity = networkComponent.provideNetworkConnectivity();
        daoUser = daoComponent.provideDAOUser();
        this.loginViewClass = p_LoginViewClass;
    }

    public void doLogOut(){
        try {
            if (networkConnectivity.isConnected()){
                Log.i(ApplicationConstant.LogTag.DMT_INFO, "Executing BGP Logout");
                new BGPLogout(this) {
                    @Override
                    public Context getContext() {
                        return context;
                    }

                    @Override
                    public Dialog getProgressDialog() {
                        final DMTHUDProgressDialog tripoinHudProgressDialog = DMTHUDProgressDialog.show(
                                context,
                                GeneralConstant.Punctuation.EMPTY,
                                false,
                                null);
                        return tripoinHudProgressDialog;
                    }
                }.execute();
            }else{
                Toast.makeText(context, R.string.internet_unavailable, Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e){
            Toast.makeText(context, R.string.sign_out_error, Toast.LENGTH_SHORT).show();
            Log.e(ApplicationConstant.LogTag.DMT_ERROR, e.getMessage());
        }
    }


    @Override
    public void onPostSuccess(Response p_Response) {
        Log.i(ApplicationConstant.LogTag.DMT_INFO, "Status : ".concat(String.valueOf(p_Response.getStatus())));
        try {
            ModelUser modelUser = (ModelUser) daoUser.getAllData().get(0);
            modelUser.setLoginStatus(GeneralConstant.BinaryValue.ZERO);
            modelUser.setUserName(GeneralConstant.Punctuation.EMPTY);
            modelUser.setUserCode(GeneralConstant.Punctuation.EMPTY);
            daoUser.updateEntity(modelUser);

            navigatorFragment.goToLoginView(
                    loginViewClass,
                    GeneralConstant.Punctuation.EMPTY,
                    GeneralConstant.Punctuation.EMPTY
            );
        }catch (Exception e){
            Toast.makeText(context, R.string.sign_out_error, Toast.LENGTH_SHORT).show();
            Log.e(ApplicationConstant.LogTag.DMT_ERROR, e.getMessage());
        }
    }

    @Override
    public void onPostFailure(RetrofitError p_RetrofitError) {
        Toast.makeText(context, R.string.sign_out_error, Toast.LENGTH_SHORT).show();
        try {
            Log.e(ApplicationConstant.LogTag.DMT_ERROR, p_RetrofitError.getMessage());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
