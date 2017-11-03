package com.zisal.am.service;

import com.zisal.am.entity.LocationEntity;
import com.zisal.am.repo.IRepoLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Ladies Man on 11/29/2015.
 */
@Service
public class ServiceLocationImpl implements IServiceLocation {

    @Autowired
    IRepoLocation iRepoLocation;

    @Override
    public List<LocationEntity> loadAllLocation(BigInteger p_UserId) {
        return iRepoLocation.loadAllLocation(p_UserId);
    }
}
