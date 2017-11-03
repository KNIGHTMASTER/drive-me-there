package com.zisal.am.repo;

import com.zisal.am.entity.SecUserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Ladies Man on 1/8/2016.
 */
public interface IRepoSecUser extends PagingAndSortingRepository<SecUserEntity, BigInteger>{

    @Query("select a from SecUserEntity a where a.userName = ?1 and a.password = ?2")
    List<SecUserEntity> doLogin(String p_UserName, String p_Password);

}
