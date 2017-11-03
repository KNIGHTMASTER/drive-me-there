package id.co.zisal.am_component.app.preference;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import id.co.zisal.am_common.constant.ApplicationConstant;
import id.co.zisal.am_common.constant.GeneralConstant;

/**
 * Created on 9/29/2015 : 9:06 AM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class TicketingPreference {

    private Activity activity;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public TicketingPreference(Activity activity){
        this.activity = activity;
        sharedPreferences = activity.getSharedPreferences(
                ApplicationConstant.TransferKeys.TRIPOIN_PREFERENCE,
                Context.MODE_PRIVATE
        );
        editor = sharedPreferences.edit();
    }

    public void setUserName(String userName){
        editor.putString(ApplicationConstant.TransferKeys.USER_LOGIN, userName);
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
