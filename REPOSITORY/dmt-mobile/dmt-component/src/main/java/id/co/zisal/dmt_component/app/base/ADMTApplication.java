package id.co.zisal.dmt_component.app.base;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

import id.co.zisal.dmt_common.bus.BusComponent;
import id.co.zisal.dmt_common.bus.BusModule;
import id.co.zisal.dmt_common.bus.DaggerBusComponent;
import id.co.zisal.dmt_common.component.IDMTComponent;
import id.co.zisal.dmt_common.constant.ApplicationConstant.Database;
import id.co.zisal.dmt_common.constant.ApplicationConstant.LogTag;
import id.co.zisal.dmt_common.constant.ApplicationConstant.Rest;
import id.co.zisal.dmt_common.constant.GeneralConstant.BinaryValue;
import id.co.zisal.dmt_component.R;
import id.co.zisal.dmt_component.app.IDMTApplication;
import id.co.zisal.dmt_dao.DAOComponent;
import id.co.zisal.dmt_dao.DAOModule;
import id.co.zisal.dmt_dao.DaggerDAOComponent;
import id.co.zisal.dmt_model.ModelDynamicConfiguration;
import id.co.zisal.dmt_model.ModelUser;
import id.co.zisal.dmt_util.network.DaggerNetworkComponent;
import id.co.zisal.dmt_util.network.NetworkComponent;
import id.co.zisal.dmt_util.network.NetworkModule;

/**
 * <p>
 *     Application <code>Context</code> for every derivative Application from this Framework
 * </p>
 *
 * Created on 9/28/2015 : 7:57 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class ADMTApplication extends MultiDexApplication implements IDMTApplication, IDMTComponent<ApplicationParameter> {

    DAOComponent daoComponent;
    NetworkComponent networkComponent;
    BusComponent busComponent;
    ApplicationParameter applicationParameter;

    @Override
    public void setParameter(ApplicationParameter p_Param) {
        this.applicationParameter = p_Param;
    }

    @Override
    protected void attachBaseContext(Context p_BaseContext) {
        super.attachBaseContext(p_BaseContext);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(LogTag.DMT_INFO, getResources().getString(R.string.base_init));
        initBaseApplicationComponents();
        initDefaultUser();
        Log.i(LogTag.DMT_INFO, getResources().getString(R.string.base_start));
    }

    @Override
    public void initBaseApplicationComponents() {
        initInjectionComponent();
        initBasePersistentComponent();
    }

    private void initInjectionComponent(){
        daoComponent = DaggerDAOComponent.builder().dAOModule(new DAOModule(this)).build();
        networkComponent = DaggerNetworkComponent.builder().networkModule(new NetworkModule(getContext())).build();
        busComponent = DaggerBusComponent.builder().busModule(new BusModule()).build();

        daoComponent.inject(getContext());
    }

    private void initBasePersistentComponent(){
        getParameter().getDaoHelper().getWritableDatabase();
        ModelDynamicConfiguration modelDynamicConfiguration;
        try{
            modelDynamicConfiguration = (ModelDynamicConfiguration) getParameter().getDaoDynamicConfiguration().getAllData().get(0);
            if(modelDynamicConfiguration.getHost() != null){
                getParameter().getDaoDynamicConfiguration().updateEntity(initDefaultConfig(modelDynamicConfiguration));
            }
        }catch (Exception e){
            Log.e(LogTag.DMT_ERROR, getResources().getString(R.string.dynamic_config_not_found));
            modelDynamicConfiguration = new ModelDynamicConfiguration();
            getParameter().getDaoDynamicConfiguration().insertEntity(initDefaultConfig(modelDynamicConfiguration));
        }
    }


    private ModelDynamicConfiguration initDefaultConfig(ModelDynamicConfiguration modelDynamicConfiguration){
        modelDynamicConfiguration.setHost(Rest.INIT_HOST);
        modelDynamicConfiguration.setPort(Rest.INIT_PORT);
        return modelDynamicConfiguration;
    }

    @Override
    public void initDefaultUser() {
        ModelUser modelUser;
        try{
            modelUser = (ModelUser) getParameter().getDaoUser().getAllData().get(0);
            if(modelUser.getUserName() == null){
                getParameter().getDaoUser().updateEntity(initBaseUser(modelUser));
            }
        }catch (Exception e){
            Log.e(LogTag.DMT_ERROR, getResources().getString(R.string.dynamic_config_not_found));
            modelUser = new ModelUser();
            getParameter().getDaoUser().insertEntity(initBaseUser(modelUser));
        }
    }

    private ModelUser initBaseUser(ModelUser p_ModelUser){
        p_ModelUser.setIsActive(BinaryValue.ZERO);
        p_ModelUser.setLoginStatus(BinaryValue.ZERO);
        p_ModelUser.setUserName(Database.INIT_USER);
        return p_ModelUser;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        if (getParameter().getDaoHelper() != null) {
            getParameter().getDaoHelper().close();
        }
    }

    @Override
    public ApplicationParameter getParameter() {
        applicationParameter = new ApplicationParameter();
        applicationParameter.setDaoHelper(daoComponent.provideDAOHelper());
        applicationParameter.setDaoUser(daoComponent.provideDAOUser());
        applicationParameter.setDaoDynamicConfiguration(daoComponent.provideDAODynamicConfiguration());
        return applicationParameter;
    }

    public DAOComponent getDaoComponent() {
        return daoComponent;
    }

    public NetworkComponent getNetworkComponent() {
        return networkComponent;
    }

    public BusComponent getBusComponent() {
        return busComponent;
    }
}
