package id.co.zisal.dmt_rest.post;

import retrofit.RetrofitError;

/**
 * Created on 10/1/2015 : 5:01 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <RESPONSE>
 */
public interface IGenericPost<RESPONSE> {

    void onPostSuccess(RESPONSE p_Response);

    void onPostFailure(RetrofitError p_RetrofitError);
}
