package id.co.zisal.dmt_rest.bgp;

import retrofit.Callback;

/**
 *
 * @param <SERVICE> request End Point Class of BGP
 * @param <RESPONSE> request CallBack Class of BGP
 *
 * Created on 10/15/2015 : 10:30 AM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IBGPRest<SERVICE, RESPONSE> {

    Class<SERVICE> getEPClass();

    Callback<RESPONSE> getCallBack();

}
