package id.co.zisal.am_rest.dto.request;

import com.google.gson.annotations.SerializedName;
import id.co.zisal.am_common.constant.ApplicationConstant;

/**
 * Created on 9/26/2015 : 6:30 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DTOGetConfigs {

    @SerializedName(ApplicationConstant.Rest.DTO.Request.USER_CODE)
    private String user_code;

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }

    @Override
    public String toString() {
        return "DTOGetConfigs{" +
                "user_code='" + user_code + '\'' +
                '}';
    }
}
