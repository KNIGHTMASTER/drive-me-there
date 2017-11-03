package id.co.zisal.dmt_rest.dto.request.login;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created on 1/8/2016 : 3:21 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Parcel
public class DTORequestLogin2 {

    @SerializedName("email")
    public String email;

    @SerializedName("password")
    public String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "DTORequestLogin2{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
