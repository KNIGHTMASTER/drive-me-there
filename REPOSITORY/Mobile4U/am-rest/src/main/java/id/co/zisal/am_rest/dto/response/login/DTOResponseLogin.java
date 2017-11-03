package id.co.zisal.am_rest.dto.response.login;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.ArrayList;

import id.co.zisal.am_common.constant.ApplicationConstant;
import id.co.zisal.am_rest.dto.response.DTOBaseResponse;

/**
 * Created on 10/2/2015 : 4:03 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Parcel
public class DTOResponseLogin extends DTOBaseResponse {

    @SerializedName(ApplicationConstant.Rest.DTO.Response.Login.USER_DATAS)

    private ArrayList<UserData> userDatas;

    public ArrayList<UserData> getUserDatas() {
        return userDatas;
    }

    public void setUserDatas(ArrayList<UserData> userDatas) {
        this.userDatas = userDatas;
    }

    @Override
    public String toString() {
        return "DTOResponseLogin{" +
                "userDatas=" + userDatas +
                '}';
    }
}
