package com.zisal.am.web.rest;

import com.zisal.am.dto.request.DTORequestLocation;
import com.zisal.am.entity.LocationEntity;
import com.zisal.am.service.IServiceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ladies Man on 11/29/2015.
 */
@RestController
public class RestLocation {

    @Autowired
    IServiceLocation iServiceLocation;

    Logger logger = LoggerFactory.getLogger(RestLocation.class);

    @RequestMapping(value = "/rest/load/location/", method = RequestMethod.POST)
    @ResponseBody
    public List<LocationEntity> loadAllLocation(@RequestBody DTORequestLocation dtoRequestLocation){
        logger.info("INFO", "User Logged in : "+dtoRequestLocation.getUserId());
        return iServiceLocation.loadAllLocation(dtoRequestLocation.getUserId());
    }
}
