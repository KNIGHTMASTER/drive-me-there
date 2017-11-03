package com.zisal.am.service;

import com.zisal.am.entity.SecUserEntity;
import com.zisal.am.repo.IRepoSecUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ladies Man on 1/8/2016.
 */
@Service
public class ServiceLogin implements IServiceLogin{

    @Autowired
    IRepoSecUser iRepoSecUser;

    Logger logger = LoggerFactory.getLogger(ServiceLogin.class);

    @Override
    public int doLogin(String p_UserName, String p_Password) {
        if(p_UserName != null && p_Password != null){
            List<SecUserEntity> secUserEntityList = iRepoSecUser.doLogin(p_UserName, p_Password);
            if(secUserEntityList.size() > 0){
               return 1;
            }else{
                return 0;
            }
        }else{
            logger.info("LOGIN", "User name | Password can not be empty");
            return 0;
        }
    }
}
