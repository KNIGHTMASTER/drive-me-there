package id.co.zisal.am_model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import id.co.zisal.am_common.constant.ApplicationConstant;
import id.co.zisal.am_common.constant.GeneralConstant;
import id.co.zisal.am_common.util.GeneralConverter;

/**
 * Created by Achmad Fauzi on 6/4/2015 : 9:59 PM.
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@DatabaseTable(tableName = ApplicationConstant.Database.TableUser.TABLE_NAME)
public class ModelUser{

    @DatabaseField(generatedId = true, canBeNull = false, columnName = ApplicationConstant.Database.ID, unique = true)
    private int id;

    @DatabaseField(columnName = ApplicationConstant.Database.TableUser.USER_NAME)
    private String userName;

    @DatabaseField(columnName = ApplicationConstant.Database.TableUser.USER_CODE)
    private String userCode;

    @DatabaseField(columnName = ApplicationConstant.Database.TableUser.LOGIN_STATUS)
    private int loginStatus;

    @DatabaseField(columnName = ApplicationConstant.Database.TableUser.IS_ACTIVE)
    private int isActive;

    @DatabaseField(columnName = ApplicationConstant.Database.TableUser.CHIPPER_AUTH)
    private String chipperAuth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(int loginStatus) {
        this.loginStatus = loginStatus;
    }

    public int getIsActive() {
        return isActive;
    }

    public String getChipperAuth() {
        return chipperAuth;
    }

    public void setChipperAuth(String userName, String password) {
        this.chipperAuth = new GeneralConverter().encodeToBase64(
                userName.concat(GeneralConstant.Punctuation.COLON)
                        .concat(password)
        );
    }

    /**
     * 1 active
     * 0 / null is not active
     * @param isActive int
     */
    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @Override
    public String toString() {
        return "ModelUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userCode='" + userCode + '\'' +
                ", loginStatus=" + loginStatus +
                ", isActive=" + isActive +
                ", chipperAuth='" + chipperAuth + '\'' +
                '}';
    }
}
