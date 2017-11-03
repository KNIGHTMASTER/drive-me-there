package id.co.zisal.dmt_rest.bgp;

import android.app.Dialog;
import android.content.Context;

import retrofit.Callback;

/**
 *
 * @param <SERVICE> request End Point Class of BGP
 * @param <RESPONSE> request CallBack Class of BGP
 *
 * Created on 10/1/2015 : 10:00 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IBGP<SERVICE, RESPONSE> {

    /**
     * <p>
     *     Retrieve a <code>Context</code> where BGP will be executed
     * </p>
     * @return a <code>Context</code>
     */
    Context getContext();

    /**
     * <p>
     *     End Point Class is usually as an <code>interface</code>
     * </p>
     * @return End Point Class
     */
    Class<SERVICE> getEPClass();

    /**
     * <p>
     *     An object that will bring the Result from Background Process
     * </p>
     * @return Custom CallBack
     */
    Callback<RESPONSE> getCallBack();

    /**
     * <p>
     *     Determine if BGP using Progress Dialog or not
     * </p>
     *
     * @return TRIPOINProgressDialog
     */
    Dialog getProgressDialog();
}
