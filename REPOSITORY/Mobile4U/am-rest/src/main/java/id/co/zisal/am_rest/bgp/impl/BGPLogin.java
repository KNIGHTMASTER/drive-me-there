package id.co.zisal.am_rest.bgp.impl;

import id.co.zisal.am_rest.bgp.base.ABGP;
import id.co.zisal.am_rest.callback.GenericCallBack;
import id.co.zisal.am_rest.dto.request.login.DTORequestLogin;
import id.co.zisal.am_rest.endpoints.EPLogin;
import id.co.zisal.am_rest.post.IGenericPost;

import retrofit.Callback;

/**
 * Created on 10/1/2015 : 4:56 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class BGPLogin extends ABGP{

    public BGPLogin(IGenericPost iGenericPost) {
        super(iGenericPost);
    }

    @Override
    protected Object doInBackground(Object[] params) {
        EPLogin epLogin = (EPLogin) restGenerator.createService(getEPClass());
        epLogin.login(getDTORequestLogin(), getCallBack());
        return null;
    }

    @Override
    public Callback getCallBack() {
        return new GenericCallBack(iGenericPost);
    }

    @Override
    public Class getEPClass() {
        return EPLogin.class;
    }

    public abstract DTORequestLogin getDTORequestLogin();
}
