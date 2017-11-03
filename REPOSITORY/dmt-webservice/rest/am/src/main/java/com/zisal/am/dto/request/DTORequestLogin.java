package com.zisal.am.dto.request;

import java.io.Serializable;

/**
 * Created by Ladies Man on 1/8/2016.
 */
public class DTORequestLogin implements Serializable{

    private String userName;

    private String password;

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

    @Override
    public String toString() {
        return "DTORequestLogin{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
