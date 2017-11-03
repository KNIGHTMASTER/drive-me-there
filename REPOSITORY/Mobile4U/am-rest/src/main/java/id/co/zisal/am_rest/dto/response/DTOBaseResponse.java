package id.co.zisal.am_rest.dto.response;

import com.google.gson.annotations.SerializedName;
import id.co.zisal.am_common.constant.ApplicationConstant;

/**
 * Created on 9/26/2015 : 6:27 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DTOBaseResponse {

    @SerializedName(ApplicationConstant.Rest.DTO.Response.Base.RESPONSE_CODE)
    int responseCode;

    @SerializedName(ApplicationConstant.Rest.DTO.Response.Base.RESPONSE_MESSAGE)
    String responseMessage;

    @SerializedName(ApplicationConstant.Rest.DTO.Response.Base.RESPONSE_DESCRIPTION)
    private String responseDescription;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    @Override
    public String toString() {
        return "DTOBaseResponse{" +
                "responseCode=" + responseCode +
                ", responseMessage='" + responseMessage + '\'' +
                ", responseDescription='" + responseDescription + '\'' +
                '}';
    }
}
