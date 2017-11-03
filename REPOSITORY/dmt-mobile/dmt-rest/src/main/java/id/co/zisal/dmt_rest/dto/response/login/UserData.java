package id.co.zisal.dmt_rest.dto.response.login;

import com.google.gson.annotations.SerializedName;
import id.co.zisal.dmt_common.constant.ApplicationConstant;

import org.parceler.Parcel;
/**
 * Created on 10/2/2015 : 3:26 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Parcel
public class UserData {

    @SerializedName(ApplicationConstant.Rest.DTO.Response.Login.UserData.ID)
    public String id;

    @SerializedName(ApplicationConstant.Rest.DTO.Response.Login.UserData.USER_NAME)
    public String userName;

    @SerializedName(ApplicationConstant.Rest.DTO.Response.Login.UserData.ENABLED)
    public int enabled;

    @SerializedName(ApplicationConstant.Rest.DTO.Response.Login.UserData.EXPIRED_DATE)
    public String expiredDate;

    @SerializedName(ApplicationConstant.Rest.DTO.Response.Login.UserData.NON_LOCKED)
    public String nonLocked;

    @SerializedName(ApplicationConstant.Rest.DTO.Response.Login.UserData.AUTH)
    public String auth;

    @SerializedName(ApplicationConstant.Rest.DTO.Response.Login.UserData.STATUS)
    public int status;

    @SerializedName(ApplicationConstant.Rest.DTO.Response.Login.UserData.REMARKS)
    public String remarks;

    @SerializedName(ApplicationConstant.Rest.DTO.Response.Login.UserData.ROLE_DATA)
    public RoleData roleData;

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
                ", userCode='" + userName + '\'' +
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
