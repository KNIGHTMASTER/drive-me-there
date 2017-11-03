package id.co.zisal.am_rest.bgp;

import android.app.Dialog;
import android.content.Context;

import retrofit.Callback;

/**
 * Created on 10/1/2015 : 10:00 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <SERVICE> request End Point Class of BGP
 * @param <RESPONSE> request CallBack Class of BGP
 */
public interface IBGP<SERVICE, RESPONSE> {

    Context getContext();

    Class<SERVICE> getEPClass();

    Callback<RESPONSE> getCallBack();

    /**
     * Determine if BGP using Progress Dialog or not
     * @return TRIPOINProgressDialog
     */
    Dialog getProgressDialog();
}
