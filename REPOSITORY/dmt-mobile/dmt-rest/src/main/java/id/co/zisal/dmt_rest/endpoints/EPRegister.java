package id.co.zisal.dmt_rest.endpoints;

import id.co.zisal.dmt_common.constant.ApplicationConstant.Rest.EndPoints;
import id.co.zisal.dmt_rest.dto.request.login.DTORequestLogin;
import id.co.zisal.dmt_rest.dto.request.register.DTORequestRegister;
import id.co.zisal.dmt_rest.dto.response.DTOBaseResponse;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * <p>
 *     Login Register
 * </p>
 * Created on 6/1/2015 : 11:44 AM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface EPRegister {

    @POST(EndPoints.REGISTER)
    void register(
            @Body DTORequestRegister p_DTORequestRegister,
            Callback<DTOBaseResponse> p_DtoBaseResponseCallback
    );
}
