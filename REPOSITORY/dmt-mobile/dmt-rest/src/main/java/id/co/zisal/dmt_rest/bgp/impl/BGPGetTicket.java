package id.co.zisal.dmt_rest.bgp.impl;

import id.co.zisal.dmt_rest.bgp.base.ABGP;
import id.co.zisal.dmt_rest.callback.GenericCallBack;
import id.co.zisal.dmt_rest.dto.request.getticket.DTORequestGetTicket;
import id.co.zisal.dmt_rest.endpoints.EPGetTicket;
import id.co.zisal.dmt_rest.post.IGenericPost;
import retrofit.Callback;

/**
 * Created on 10/1/2015 : 4:56 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class BGPGetTicket extends ABGP{

    public BGPGetTicket(IGenericPost iGenericPost) {
        super(iGenericPost);
    }

    @Override
    protected Object doInBackground(Object[] p_MultipleParams) {
        EPGetTicket epGetTicket = (EPGetTicket) restGenerator.createService(getEPClass());
        epGetTicket.checkTicket(
                getDTORequestGetTicket().getRqid(),
                getDTORequestGetTicket().getApp(),
                getDTORequestGetTicket().getAction(),
                getDTORequestGetTicket().getBookingCode(),
                getCallBack()
        );
        return null;
    }

    public abstract DTORequestGetTicket getDTORequestGetTicket();

    @Override
    public Callback getCallBack() {
        return new GenericCallBack(iGenericPost, null);
    }

    @Override
    public Class getEPClass() {
        return EPGetTicket.class;
    }
}
