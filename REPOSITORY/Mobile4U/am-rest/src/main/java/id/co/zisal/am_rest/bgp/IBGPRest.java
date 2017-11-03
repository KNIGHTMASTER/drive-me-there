package id.co.zisal.am_rest.bgp;

import retrofit.Callback;

/**
 * Created on 10/15/2015 : 10:30 AM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <SERVICE> request End Point Class of BGP
 * @param <RESPONSE> request CallBack Class of BGP
 */
public interface IBGPRest<SERVICE, RESPONSE> {

    Class<SERVICE> getEPClass();

    Callback<RESPONSE> getCallBack();

}
