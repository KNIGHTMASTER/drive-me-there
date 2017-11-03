package id.co.zisal.am_rest.engine;


import android.content.Context;

import com.squareup.okhttp.OkHttpClient;
import id.co.zisal.am_common.component.ITicketingComponent;

import id.co.zisal.am_dao.impl.DAODynamicConfiguration;
import id.co.zisal.am_model.ModelDynamicConfiguration;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created on 5/24/2015 : 12:21 AM.
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class RestGenerator<S> implements ITicketingComponent<RestParameter> {

    public RestAdapter.Builder builder = new RestAdapter.Builder();

    private RestParameter restParameter;

    public S createService(Class<S> serviceClass) {
        return createService(
                serviceClass,
                getParameter().getChipperAuth(),
                getParameter().getContext()
        );
    }

    public S createService(Class<S> serviceClass,  String chipperAuth, Context context) {
        ModelDynamicConfiguration modelDynamicConfiguration = (ModelDynamicConfiguration)
                new DAODynamicConfiguration(context).getAllData().get(0);

        builder.setLogLevel(RestAdapter.LogLevel.FULL)
               .setEndpoint(modelDynamicConfiguration.getBasicUrl())
               .setClient(new OkClient(new OkHttpClient()));

        if (chipperAuth != null) {
            builder.setRequestInterceptor(new CustomRequestInterceptor(chipperAuth));
        }

        RestAdapter adapter = builder.build();
        return adapter.create(serviceClass);
    }

    @Override
    public void setParameter(RestParameter _param) {
        this.restParameter = _param;
    }

    @Override
    public RestParameter getParameter() {
        return restParameter;
    }
}