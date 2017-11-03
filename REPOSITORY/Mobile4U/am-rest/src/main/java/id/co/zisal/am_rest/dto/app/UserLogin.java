package id.co.zisal.am_rest.dto.app;

import org.parceler.Parcel;

/**
 * Created on 10/7/2015 : 11:30 AM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Parcel
public class UserLogin {

    private String userName;
    private String userCode;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "userName='" + userName + '\'' +
                ", userCode='" + userCode + '\'' +
                '}';
    }
}
