package id.co.zisal.dmt_rest.endpoints;

import id.co.zisal.dmt_common.constant.ApplicationConstant.Rest.EndPoints;
import id.co.zisal.dmt_rest.dto.response.logout.DTOResponseLogout;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * <p>
 *     Logout End Point
 * </p>
 *
 * Created on 6/1/2015 : 11:44 AM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface EPLogout {

    @GET(EndPoints.LOGOUT)
    void logout(Callback<DTOResponseLogout> p_DtoResponseLogoutCallback);
}
