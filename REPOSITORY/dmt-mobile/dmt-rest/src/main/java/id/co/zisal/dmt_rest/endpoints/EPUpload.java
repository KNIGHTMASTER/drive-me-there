package id.co.zisal.dmt_rest.endpoints;

import id.co.zisal.dmt_common.constant.ApplicationConstant;
import id.co.zisal.dmt_rest.dto.response.DTOBaseResponse;

import retrofit.Callback;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.mime.TypedFile;

/**
 * <p>
 *      Upload End Point
 * </p>
 *
 * Created on 6/1/2015 : 11:44 AM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface EPUpload {

    @Multipart
    @POST(ApplicationConstant.Rest.EndPoints.UPLOAD)
    void upload(
            @Part("myfile")TypedFile p_File,
            @Part("description") String p_Description,
            Callback<DTOBaseResponse> p_DtoBaseResponseCallback
    );
}
