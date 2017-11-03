package id.co.zisal.am_component.app.base;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

import id.co.zisal.am_common.constant.ApplicationConstant.Database;
import id.co.zisal.am_common.constant.ApplicationConstant.LogTag;
import id.co.zisal.am_common.constant.ApplicationConstant.Rest;

import id.co.zisal.am_common.constant.GeneralConstant.BinaryValue;
import id.co.zisal.am_component.R;
import id.co.zisal.am_component.app.IAMApplication;
import id.co.zisal.am_dao.DAOHelper;
import id.co.zisal.am_dao.impl.DAODynamicConfiguration;
import id.co.zisal.am_dao.impl.DAOUser;
import id.co.zisal.am_model.ModelDynamicConfiguration;
import id.co.zisal.am_model.ModelUser;

/**
 * Created on 9/28/2015 : 7:57 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class AAMApplication extends MultiDexApplication implements IAMApplication {

    private DAOHelper daoHelper;


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(LogTag.AM_INFO, getResources().getString(R.string.base_init));
        initBaseApplicationComponents();
        initDefaultUser();
        Log.i(LogTag.AM_INFO, getResources().getString(R.string.base_start));
    }

    @Override
    public void initBaseApplicationComponents() {
        daoHelper = new DAOHelper(getContext());
        daoHelper.getWritableDatabase();

        DAODynamicConfiguration daoDynamicConfiguration = new DAODynamicConfiguration(this);
        ModelDynamicConfiguration modelDynamicConfiguration;
        try{
            modelDynamicConfiguration = (ModelDynamicConfiguration) daoDynamicConfiguration.getAllData().get(0);
            if(modelDynamicConfiguration.getHost() != null){
                daoDynamicConfiguration.updateEntity(initBaseConfig(modelDynamicConfiguration));
            }
        }catch (Exception e){
            Log.e(LogTag.AM_ERROR, getResources().getString(R.string.dynamic_config_not_found));
            modelDynamicConfiguration = new ModelDynamicConfiguration();
            daoDynamicConfiguration.insertEntity(initBaseConfig(modelDynamicConfiguration));
        }
    }

    private ModelDynamicConfiguration initBaseConfig(ModelDynamicConfiguration modelDynamicConfiguration){
        modelDynamicConfiguration.setHost(Rest.INIT_HOST);
        modelDynamicConfiguration.setPort(Rest.INIT_PORT);
        return modelDynamicConfiguration;
    }

    @Override
    public void initDefaultUser() {
        DAOUser daoUser = new DAOUser(getContext());
        ModelUser modelUser;
        try{
            modelUser = (ModelUser) daoUser.getAllData().get(0);
            if(modelUser.getUserName() == null){
                daoUser.updateEntity(initBaseUser(modelUser));
            }
        }catch (Exception e){
            Log.e(LogTag.AM_ERROR, getResources().getString(R.string.dynamic_config_not_found));
            modelUser = new ModelUser();
            daoUser.insertEntity(initBaseUser(modelUser));
        }
    }

    private ModelUser initBaseUser(ModelUser modelUser){
        modelUser.setIsActive(BinaryValue.ZERO);
        modelUser.setLoginStatus(BinaryValue.ZERO);
        modelUser.setUserName(Database.INIT_USER);
        return modelUser;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        if (daoHelper != null) {
            daoHelper.close();
        }
    }
}
