package id.co.zisal.dmt_rest.bgp.impl;

import id.co.zisal.dmt_rest.bgp.base.ABGP;
import id.co.zisal.dmt_rest.callback.GenericCallBack;
import id.co.zisal.dmt_rest.dto.request.register.DTORequestRegister;
import id.co.zisal.dmt_rest.endpoints.EPRegister;
import id.co.zisal.dmt_rest.post.IGenericPost;
import retrofit.Callback;

/**
 * Created on 10/1/2015 : 4:56 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class BGPRegister extends ABGP{

    public BGPRegister(IGenericPost p_IGenericPost) {
        super(p_IGenericPost);
    }

    @Override
    protected Object doInBackground(Object[] p_MultipleParams) {
        EPRegister epRegister = (EPRegister) restGenerator.createService(getEPClass());
        epRegister.register(getDTORequestRegister(), getCallBack());
        return null;
    }

    @Override
    public Callback getCallBack() {
        return new GenericCallBack(iGenericPost, dialog);
    }

    @Override
    public Class getEPClass() {
        return EPRegister.class;
    }

    public abstract DTORequestRegister getDTORequestRegister();
}
