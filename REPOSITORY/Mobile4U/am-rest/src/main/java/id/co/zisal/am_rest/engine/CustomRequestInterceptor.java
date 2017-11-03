package id.co.zisal.am_rest.engine;

import id.co.zisal.am_common.constant.ApplicationConstant;
import id.co.zisal.am_common.constant.GeneralConstant;

import retrofit.RequestInterceptor;

/**
 * Created on 5/26/2015 : 10:39 AM.
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class CustomRequestInterceptor implements RequestInterceptor {

    private String chipperAuth;

    public CustomRequestInterceptor(String chipperAuth) {
        this.chipperAuth = chipperAuth;
    }

    @Override
    public void intercept(RequestFacade request) {
        request.addHeader(
                ApplicationConstant.Rest.ACCEPT,
                ApplicationConstant.Rest.APPLICATION_JSON
        );
        request.addHeader(
                ApplicationConstant.Rest.AUTHORIZATION,
                ApplicationConstant.Rest.BASIC.
                        concat(GeneralConstant.Punctuation.SPACE).
                        concat(chipperAuth)
        );
        request.addHeader(
                ApplicationConstant.Rest.CONTENT_TYPE,
                ApplicationConstant.Rest.APPLICATION_JSON
        );
    }
}
