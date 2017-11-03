package id.co.zisal.dmt_dao;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import id.co.zisal.dmt_dao.impl.DAOCustomer;
import id.co.zisal.dmt_dao.impl.DAODynamicConfiguration;
import id.co.zisal.dmt_dao.impl.DAOUser;

/**
 * <p>
 *     Module for DAO Dependency Injection
 * </p>
 * Created on 2/8/2016 : 10:41 AM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Module
public class DAOModule {

    private final Context context;

    public DAOModule(Context p_Context) {
        this.context = p_Context;
    }

    @Singleton
    @Provides
    DAOHelper provideDAOHelper(){
        return new DAOHelper(context);
    }

    @Singleton
    @Provides
    DAOUser provideDAOUser(){
        return new DAOUser(context);
    }

    @Singleton
    @Provides
    DAODynamicConfiguration provideDAODynamicConfiguration(){
        return new DAODynamicConfiguration(context);
    }

    @Singleton
    @Provides
    DAOCustomer provideDAOCustomer(){
        return new DAOCustomer(context);
    }

}
