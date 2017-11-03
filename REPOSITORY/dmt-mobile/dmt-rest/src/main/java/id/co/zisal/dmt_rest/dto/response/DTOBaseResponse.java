package id.co.zisal.dmt_rest.dto.response;

import com.google.gson.annotations.SerializedName;
import id.co.zisal.dmt_common.constant.ApplicationConstant;

/**
 * Created on 9/26/2015 : 6:27 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DTOBaseResponse {

    @SerializedName(ApplicationConstant.Rest.DTO.Response.Base.RESPONSE_CODE)
    public int responseCode;

    /*@SerializedName(ApplicationConstant.Rest.DTO.Response.Base.RESPONSE_MESSAGE)
    public String responseMessage;

    @SerializedName(ApplicationConstant.Rest.DTO.Response.Base.RESPONSE_DESCRIPTION)
    public String responseDescription;*/

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

/*    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }*/

    @Override
    public String toString() {
        return "DTOBaseResponse{" +
                "responseCode=" + responseCode +
                /*", responseMessage='" + responseMessage + '\'' +
                ", responseDescription='" + responseDescription + '\'' +*/
                '}';
    }
}
