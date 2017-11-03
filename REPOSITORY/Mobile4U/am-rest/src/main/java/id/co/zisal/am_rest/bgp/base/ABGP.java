package id.co.zisal.am_rest.bgp.base;

import android.app.Dialog;
import android.os.AsyncTask;
import android.util.Log;

import id.co.zisal.am_common.constant.ApplicationConstant;
import id.co.zisal.am_common.constant.GeneralConstant;
import id.co.zisal.am_dao.impl.DAOUser;
import id.co.zisal.am_model.ModelUser;
import id.co.zisal.am_rest.R;
import id.co.zisal.am_rest.bgp.IBGP;
import id.co.zisal.am_rest.engine.RestGenerator;
import id.co.zisal.am_rest.engine.RestParameter;
import id.co.zisal.am_rest.post.IGenericPost;

/**
 * Created on 10/1/2015 : 4:59 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class ABGP extends AsyncTask implements IBGP {

    protected RestGenerator restGenerator;
    protected IGenericPost iGenericPost;
    protected RestParameter restParameter;
    protected Dialog dialog;

    public ABGP(IGenericPost iGenericPost) {
        this. restGenerator = new RestGenerator();
        this.iGenericPost = iGenericPost;

        initRestParameter();
        restGenerator.setParameter(restParameter);
    }

    private void initRestParameter(){
        DAOUser daoUser = new DAOUser(getContext());
        ModelUser modelUser;
        try{
            modelUser = (ModelUser)daoUser.getAllData().get(0);
            if(modelUser.getChipperAuth() == null){
                daoUser.updateEntity(initBaseUser(modelUser));
            }
            this.restParameter = initBasicRestParameter(modelUser);
        } catch (Exception e){
            modelUser = new ModelUser();
            daoUser.insertEntity(initBaseUser(modelUser));
        }
    }

    private ModelUser initBaseUser(ModelUser modelUser){
        modelUser.setIsActive(GeneralConstant.BinaryValue.ZERO);
        modelUser.setLoginStatus(GeneralConstant.BinaryValue.ZERO);
        modelUser.setUserName(ApplicationConstant.Database.INIT_USER);
        modelUser.setChipperAuth(GeneralConstant.Punctuation.EMPTY, GeneralConstant.Punctuation.EMPTY);
        return modelUser;
    }

    private RestParameter initBasicRestParameter(ModelUser modelUser) {
        RestParameter result = new RestParameter();
        result.setContext(getContext());
        if(modelUser.getChipperAuth() == null){
            result.setChipperAuth(GeneralConstant.Punctuation.EMPTY);
        }else{
            result.setChipperAuth(modelUser.getChipperAuth());
        }
        return result;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if(dialog != null){
            dialog.show();
        }else if(dialog == null){
            if(getProgressDialog() != null){
                dialog = getProgressDialog();
                dialog.dismiss();
                dialog.show();
            }
        }
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        Log.i(
                ApplicationConstant.LogTag.AM_INFO,
                getContext().getResources().getString(R.string.post_execute_bgp).concat(getEPClass().getSimpleName())
        );
        if(dialog != null){
            dialog.dismiss();
        }
    }
}
