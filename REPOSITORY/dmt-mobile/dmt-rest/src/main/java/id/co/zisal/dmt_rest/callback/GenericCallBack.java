package id.co.zisal.dmt_rest.callback;

import android.app.Dialog;

import id.co.zisal.dmt_common.constant.ApplicationConstant.Rest.Status;
import id.co.zisal.dmt_rest.post.IGenericPost;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created on 10/2/2015 : 10:28 AM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <RESULT>
 */
public class GenericCallBack<RESULT> implements Callback<RESULT>{

    private IGenericPost iGenericPost;

    private Dialog dialog;

    public GenericCallBack(IGenericPost p_IGenericPost, Dialog p_Dialog) {
        this.iGenericPost = p_IGenericPost;
        if (p_Dialog != null){
            this.dialog = p_Dialog;
        }
    }

    @Override
    public void success(RESULT p_Result, Response p_Response) {
        if(p_Response.getStatus() == Status.SUCCESS){
            dismissDialog();
            iGenericPost.onPostSuccess(p_Result);
        }
    }

    @Override
    public void failure(RetrofitError p_RetrofitError) {
        dismissDialog();
        iGenericPost.onPostFailure(p_RetrofitError);
    }

    private void dismissDialog(){
        if ((dialog != null)){
            dialog.dismiss();
        }
    }

}
