package com.zisal.am.service;


import com.zisal.am.entity.LocationEntity;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Ladies Man on 11/29/2015.
 */
public interface IServiceLocation {

    List<LocationEntity> loadAllLocation(BigInteger p_UserId);
}
