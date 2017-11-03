package com.zisal.am.entity;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * Created by Ladies Man on 1/8/2016.
 */
@Entity
@Table(name = "sec_user", schema = "security")
public class SecUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

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
        return "SecUserEntity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
