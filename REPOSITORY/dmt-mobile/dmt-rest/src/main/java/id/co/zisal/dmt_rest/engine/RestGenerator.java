package id.co.zisal.dmt_rest.engine;


import android.content.Context;

import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import id.co.zisal.dmt_common.component.IDMTComponent;

import id.co.zisal.dmt_common.constant.ApplicationConstant;
import id.co.zisal.dmt_dao.DAOComponent;
import id.co.zisal.dmt_dao.DAOModule;
import id.co.zisal.dmt_dao.DaggerDAOComponent;
import id.co.zisal.dmt_dao.impl.DAODynamicConfiguration;
import id.co.zisal.dmt_model.ModelDynamicConfiguration;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * <p>
 *     Generating RestClient for Web Service Communication
 * </p>
 * @param <GENERATOR>
 * Created on 5/24/2015 : 12:21 AM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class RestGenerator<GENERATOR> implements IDMTComponent<RestParameter> {

    public RestAdapter.Builder builder = new RestAdapter.Builder();
    private RestParameter restParameter;

    public GENERATOR createService(Class<GENERATOR> p_ServiceClass) {
        return createService(
                p_ServiceClass,
                getParameter().getChipperAuth(),
                getParameter().getContext()
        );
    }

    public GENERATOR createService(Class<GENERATOR> p_ServiceClass,  String p_ChipperAuth, Context p_Context) {
        DAOComponent daoComponent = DaggerDAOComponent.builder().dAOModule(new DAOModule(p_Context)).build();
        DAODynamicConfiguration daoDynamicConfiguration = daoComponent.provideDAODynamicConfiguration();
        ModelDynamicConfiguration modelDynamicConfiguration = (ModelDynamicConfiguration)
                daoDynamicConfiguration.getAllData().get(0);

        final OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(ApplicationConstant.Rest.READ_TIMEOUT, TimeUnit.SECONDS);
        okHttpClient.setConnectTimeout(ApplicationConstant.Rest.CONNECT_TIMEOUT, TimeUnit.SECONDS);

        builder.setLogLevel(RestAdapter.LogLevel.FULL)
               .setEndpoint(modelDynamicConfiguration.getBasicUrl())
               .setClient(new OkClient(okHttpClient));

        /*if (p_ChipperAuth != null) {
            builder.setRequestInterceptor(new CustomRequestInterceptor(p_ChipperAuth));
        }*/

        RestAdapter adapter = builder.build();
        return adapter.create(p_ServiceClass);
    }

    @Override
    public void setParameter(RestParameter p_Param) {
        this.restParameter = p_Param;
    }

    @Override
    public RestParameter getParameter() {
        return restParameter;
    }
}