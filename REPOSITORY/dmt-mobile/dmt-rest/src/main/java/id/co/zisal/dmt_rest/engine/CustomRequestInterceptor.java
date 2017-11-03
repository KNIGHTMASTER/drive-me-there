package id.co.zisal.dmt_rest.engine;

import id.co.zisal.dmt_common.constant.ApplicationConstant.Rest;
import id.co.zisal.dmt_common.constant.GeneralConstant.Punctuation;
import retrofit.RequestInterceptor;

/**
 * <p>
 *     This is a customized {@link RequestInterceptor}
 *     capable to make authentication with inserting <b>Header</b> into <b>HTTP</b> request
 *     whether it is :
 *     <ol>
 *         <li><code>BasicAuth</code></li>
 *         <li><code>OAuth</code></li>
 *         <li><code>OAuth 2.0</code></li>
 *     </ol>
 * </p>
 *
 * @see retrofit.RequestInterceptor
 *
 * Created on 5/26/2015 : 10:39 AM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class CustomRequestInterceptor implements RequestInterceptor {

    private String chipperAuth;

    public CustomRequestInterceptor(String p_ChipperAuth) {
        this.chipperAuth = p_ChipperAuth;
    }

    /**
     * <p>
     *     Just change the <code>Header</code> below to use any of authentication type
     * </p>
     *
     * @param p_RequestFacade the requested HTTP
     */
    @Override
    public void intercept(RequestFacade p_RequestFacade) {
        p_RequestFacade.addHeader(
                Rest.ACCEPT,
                Rest.APPLICATION_JSON
        );
        p_RequestFacade.addHeader(
                Rest.AUTHORIZATION,
                Rest.BASIC.
                        concat(Punctuation.SPACE).
                        concat(chipperAuth)
        );
        p_RequestFacade.addHeader(
                Rest.CONTENT_TYPE,
                Rest.APPLICATION_JSON
        );
    }
}
