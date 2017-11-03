package id.co.zisal.dmt_rest.bgp.impl;

import id.co.zisal.dmt_rest.bgp.base.ABGP;
import id.co.zisal.dmt_rest.callback.GenericCallBack;
import id.co.zisal.dmt_rest.dto.request.checkticket.DTORequestCheckTicket;
import id.co.zisal.dmt_rest.endpoints.EPCheckTicket;
import id.co.zisal.dmt_rest.post.IGenericPost;
import retrofit.Callback;

/**
 * Created on 10/1/2015 : 4:56 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class BGPCheckTicket extends ABGP{

    public BGPCheckTicket(IGenericPost iGenericPost) {
        super(iGenericPost);
    }

    @Override
    protected Object doInBackground(Object[] p_MultipleParams) {
        EPCheckTicket epCheckTicket = (EPCheckTicket) restGenerator.createService(getEPClass());
        epCheckTicket.checkTicket(
                getDTORequestCheckTicket().getRqid(),
                getDTORequestCheckTicket().getApp(),
                getDTORequestCheckTicket().getAction(),
                getDTORequestCheckTicket().getBookingCode(),
                getCallBack()
        );
        return null;
    }

    public abstract DTORequestCheckTicket getDTORequestCheckTicket();

    @Override
    public Callback getCallBack() {
        return new GenericCallBack(iGenericPost, null);
    }

    @Override
    public Class getEPClass() {
        return EPCheckTicket.class;
    }
}
