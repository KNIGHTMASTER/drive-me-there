package id.co.zisal.dmt_rest.bgp.impl;

import id.co.zisal.dmt_rest.bgp.base.ABGP;
import id.co.zisal.dmt_rest.callback.GenericCallBack;
import id.co.zisal.dmt_rest.dto.request.location.DTORequestLocation;
import id.co.zisal.dmt_rest.endpoints.EPLocation;
import id.co.zisal.dmt_rest.post.IGenericPost;
import retrofit.Callback;

/**
 * Created on 10/1/2015 : 4:56 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class BGPLocation extends ABGP {

    public BGPLocation(IGenericPost p_IGenericPost) {
        super(p_IGenericPost);
    }

    @Override
    protected Object doInBackground(Object[] p_MultipleParams) {
        EPLocation epLocation = (EPLocation) restGenerator.createService(getEPClass());
        epLocation.getLocation(getDtoRequestLocation(), getCallBack());
        return null;
    }

    @Override
    public Callback getCallBack() {
        return new GenericCallBack(iGenericPost, null);
    }

    @Override
    public Class getEPClass() {
        return EPLocation.class;
    }

    public abstract DTORequestLocation getDtoRequestLocation();
}
