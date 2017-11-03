package id.co.zisal.dmt_rest.dto.request.login;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created on 1/8/2016 : 3:21 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Parcel
public class DTORequestLogin {

    @SerializedName("user_code")
    public String userCode;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @Override
    public String toString() {
        return "DTORequestLogin{" +
                "userCode='" + userCode + '\'' +
                '}';
    }
}
