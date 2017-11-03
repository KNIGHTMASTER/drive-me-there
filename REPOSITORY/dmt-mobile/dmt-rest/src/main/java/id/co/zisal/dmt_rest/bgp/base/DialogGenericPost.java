package id.co.zisal.dmt_rest.bgp.base;

import android.app.Dialog;
import android.util.Log;

import id.co.zisal.dmt_common.constant.ApplicationConstant;
import id.co.zisal.dmt_rest.post.IGenericPost;

import retrofit.RetrofitError;

/**
 * Created on 10/16/2015 : 3:20 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DialogGenericPost implements IGenericPost {

    private Dialog dialog;

    public DialogGenericPost(Dialog p_Dialog) {
        this.dialog = p_Dialog;
    }

    @Override
    public void onPostSuccess(Object p_Response) {
        Log.i(ApplicationConstant.LogTag.DMT_INFO, "Closing Dialog");
        closeDialog();
    }

    @Override
    public void onPostFailure(RetrofitError p_RetrofitError) {
        closeDialog();
    }

    private void closeDialog(){
        if(dialog != null){
            dialog.dismiss();
            dialog = null;
        }
    }
}
