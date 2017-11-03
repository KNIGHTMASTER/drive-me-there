package com.zisal.am.repo;

import com.zisal.am.entity.LocationEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Ladies Man on 11/29/2015.
 */
public interface IRepoLocation extends PagingAndSortingRepository<LocationEntity, BigInteger> {

    @Query("select a from LocationEntity a where a.userId = ?1")
    List<LocationEntity> loadAllLocation(BigInteger p_UserId);
}
