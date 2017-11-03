package id.co.zisal.dmt_rest.bgp.impl;

import id.co.zisal.dmt_rest.bgp.base.ABGP;
import id.co.zisal.dmt_rest.callback.GenericCallBack;
import id.co.zisal.dmt_rest.dto.request.login.DTORequestLogin;
import id.co.zisal.dmt_rest.dto.request.login.DTORequestLogin2;
import id.co.zisal.dmt_rest.endpoints.EPLogin;
import id.co.zisal.dmt_rest.endpoints.EPLogin2;
import id.co.zisal.dmt_rest.post.IGenericPost;
import retrofit.Callback;

/**
 * Created on 10/1/2015 : 4:56 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class BGPLogin2 extends ABGP{

    public BGPLogin2(IGenericPost p_IGenericPost) {
        super(p_IGenericPost);
    }

    @Override
    protected Object doInBackground(Object[] p_MultipleParams) {
        EPLogin2 epLogin = (EPLogin2) restGenerator.createService(getEPClass());
        epLogin.login(getDTORequestLogin(), getCallBack());
        return null;
    }

    @Override
    public Callback getCallBack() {
        return new GenericCallBack(iGenericPost, null);
    }

    @Override
    public Class getEPClass() {
        return EPLogin.class;
    }

    public abstract DTORequestLogin2 getDTORequestLogin();
}
