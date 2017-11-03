package id.co.zisal.dmt_rest.bgp.base;

import android.app.Dialog;
import android.os.AsyncTask;
import android.util.Log;

import id.co.zisal.dmt_common.constant.ApplicationConstant;
import id.co.zisal.dmt_common.constant.GeneralConstant;
import id.co.zisal.dmt_dao.impl.DAOUser;
import id.co.zisal.dmt_model.ModelUser;
import id.co.zisal.dmt_rest.R;
import id.co.zisal.dmt_rest.bgp.IBGP;
import id.co.zisal.dmt_rest.engine.RestGenerator;
import id.co.zisal.dmt_rest.engine.RestParameter;
import id.co.zisal.dmt_rest.post.IGenericPost;

/**
 * Created on 10/1/2015 : 4:59 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class ABGP extends AsyncTask implements IBGP {

    protected RestGenerator restGenerator;
    protected IGenericPost iGenericPost;
    protected RestParameter restParameter;
    protected Dialog dialog;

    public ABGP(IGenericPost p_IGenericPost) {
        this. restGenerator = new RestGenerator();
        this.iGenericPost = p_IGenericPost;

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

    private ModelUser initBaseUser(ModelUser p_ModelUser){
        p_ModelUser.setIsActive(GeneralConstant.BinaryValue.ZERO);
        p_ModelUser.setLoginStatus(GeneralConstant.BinaryValue.ZERO);
        p_ModelUser.setUserName(ApplicationConstant.Database.INIT_USER);
        p_ModelUser.setChipperAuth(GeneralConstant.Punctuation.EMPTY, GeneralConstant.Punctuation.EMPTY);
        return p_ModelUser;
    }

    private RestParameter initBasicRestParameter(ModelUser p_ModelUser) {
        RestParameter result = new RestParameter();
        result.setContext(getContext());
        if(p_ModelUser.getChipperAuth() == null){
            result.setChipperAuth(GeneralConstant.Punctuation.EMPTY);
        }else{
            result.setChipperAuth(p_ModelUser.getChipperAuth());
        }
        return result;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if(dialog != null){
            dialog.show();
            Log.i(ApplicationConstant.LogTag.DMT_INFO, "Dialog Show 1");
        }else {
            if(getProgressDialog() != null){
                dialog = getProgressDialog();
                dialog.show();
                Log.i(ApplicationConstant.LogTag.DMT_INFO, "Dialog Show 2");
            }
        }
    }

    /*@Override
    protected void onPostExecute(Object p_Object) {
        super.onPostExecute(p_Object);
        Log.i(
                ApplicationConstant.LogTag.DMT_INFO,
                getContext().getResources().getString(R.string.post_execute_bgp).concat(getEPClass().getSimpleName())
        );
        if(dialog != null){
            dialog.dismiss();
        }
    }*/
}
