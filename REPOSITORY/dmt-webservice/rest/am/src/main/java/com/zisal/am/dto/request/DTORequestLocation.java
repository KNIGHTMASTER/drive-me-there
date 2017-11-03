package com.zisal.am.dto.request;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * Created by Ladies Man on 11/29/2015.
 */
public class DTORequestLocation implements Serializable{
    private BigInteger userId;

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "DTORequestLocation{" +
                "userId='" + userId + '\'' +
                '}';
    }
}
