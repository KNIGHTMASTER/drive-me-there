package id.co.zisal.dmt_rest.dto.request.register;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.math.BigInteger;

/**
 * Created on 4/6/2016 : 12:04 AM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Parcel
public class DTORequestRegister {

    @SerializedName("Username")
    String userName;

    @SerializedName("Password")
    String password;

    @SerializedName("Email")
    String email;

    @SerializedName("UserTypeId")
    int userType;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "DTORequestRegister{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                ", email='" + email + '\'' +
                '}';
    }
}
