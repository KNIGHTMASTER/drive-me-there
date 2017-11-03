package id.co.zisal.am_rest.dto.response.login;

import com.google.gson.annotations.SerializedName;
import id.co.zisal.am_common.constant.ApplicationConstant;

import org.parceler.Parcel;
/**
 * Created on 10/2/2015 : 3:26 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Parcel
public class UserData {

    @SerializedName(ApplicationConstant.Rest.DTO.Response.Login.UserData.ID)
    private String id;

    @SerializedName(ApplicationConstant.Rest.DTO.Response.Login.UserData.USER_NAME)
    private String userName;

    @SerializedName(ApplicationConstant.Rest.DTO.Response.Login.UserData.ENABLED)
    private int enabled;

    @SerializedName(ApplicationConstant.Rest.DTO.Response.Login.UserData.EXPIRED_DATE)
    private String expiredDate;

    @SerializedName(ApplicationConstant.Rest.DTO.Response.Login.UserData.NON_LOCKED)
    private String nonLocked;

    @SerializedName(ApplicationConstant.Rest.DTO.Response.Login.UserData.AUTH)
    private String auth;

    @SerializedName(ApplicationConstant.Rest.DTO.Response.Login.UserData.STATUS)
    private int status;

    @SerializedName(ApplicationConstant.Rest.DTO.Response.Login.UserData.REMARKS)
    private String remarks;

    @SerializedName(ApplicationConstant.Rest.DTO.Response.Login.UserData.ROLE_DATA)
    private RoleData roleData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getNonLocked() {
        return nonLocked;
    }

    public void setNonLocked(String nonLocked) {
        this.nonLocked = nonLocked;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public RoleData getRoleData() {
        return roleData;
    }

    public void setRoleData(RoleData roleData) {
        this.roleData = roleData;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", enabled=" + enabled +
                ", expiredDate='" + expiredDate + '\'' +
                ", nonLocked='" + nonLocked + '\'' +
                ", auth='" + auth + '\'' +
                ", status=" + status +
                ", remarks='" + remarks + '\'' +
                ", roleData=" + roleData +
                '}';
    }
}
