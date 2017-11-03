package id.co.zisal.am_rest.endpoints;

import id.co.zisal.am_common.constant.ApplicationConstant;

import id.co.zisal.am_rest.dto.request.login.DTORequestLogin;
import id.co.zisal.am_rest.dto.response.DTOBaseResponse;
import id.co.zisal.am_rest.dto.response.login.DTOResponseLogin;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created on 6/1/2015 : 11:44 AM.
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface EPLogin {

    @POST(ApplicationConstant.Rest.EndPoints.LOGIN)
    void login(@Body DTORequestLogin dtoRequestLogin, Callback<DTOBaseResponse> dtoBaseResponseCallback);
}
