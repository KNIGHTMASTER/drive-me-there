package id.co.zisal.dmt_component.app.preference;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import id.co.zisal.dmt_common.constant.ApplicationConstant;
import id.co.zisal.dmt_common.constant.GeneralConstant;

/**
 * <p>
 *     Global <code>SharedPreference</code> for Application
 * </p>
 *
 * Created on 9/29/2015 : 9:06 AM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DMTPreference {

    private Activity activity;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public DMTPreference(Activity p_Activity){
        this.activity = p_Activity;
        sharedPreferences = p_Activity.getSharedPreferences(
                ApplicationConstant.TransferKeys.TRIPOIN_PREFERENCE,
                Context.MODE_PRIVATE
        );
        editor = sharedPreferences.edit();
    }

    public void setUserName(String p_UserName){
        editor.putString(ApplicationConstant.TransferKeys.USER_LOGIN, p_UserName);
        editor.commit();
    }

    public String getUserName(){
        return sharedPreferences.getString(
                ApplicationConstant.TransferKeys.USER_LOGIN,
                GeneralConstant.Punctuation.EMPTY
        );
    }

    public void clear(){
        editor.clear();
        editor.commit();
    }

}
