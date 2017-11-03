package id.co.zisal.am_rest.endpoints;

import id.co.zisal.am_common.constant.ApplicationConstant;
import id.co.zisal.am_rest.dto.response.logout.DTOResponseLogout;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created on 6/1/2015 : 11:44 AM.
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface EPLogout {

    @GET(ApplicationConstant.Rest.EndPoints.LOGOUT)
    void logout(Callback<DTOResponseLogout> dtoResponseLogoutCallback);
}
