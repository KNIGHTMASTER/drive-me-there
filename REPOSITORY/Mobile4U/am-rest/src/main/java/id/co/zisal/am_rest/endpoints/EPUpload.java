package id.co.zisal.am_rest.endpoints;

import id.co.zisal.am_common.constant.ApplicationConstant;
import id.co.zisal.am_rest.dto.response.DTOBaseResponse;

import retrofit.Callback;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.mime.TypedFile;

/**
 * Created on 6/1/2015 : 11:44 AM.
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface EPUpload {

    @Multipart
    @POST(ApplicationConstant.Rest.EndPoints.UPLOAD)
    void upload(
            @Part("myfile")TypedFile file,
            @Part("description") String description,
            Callback<DTOBaseResponse> dtoBaseResponseCallback
    );
}
