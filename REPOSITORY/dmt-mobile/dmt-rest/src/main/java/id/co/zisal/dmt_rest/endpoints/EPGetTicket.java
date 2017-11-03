package id.co.zisal.dmt_rest.endpoints;

import id.co.zisal.dmt_common.constant.ApplicationConstant.Rest.DTO.Response.BaseTicketing;
import id.co.zisal.dmt_common.constant.ApplicationConstant.Rest.EndPoints;
import id.co.zisal.dmt_rest.dto.response.getticket.DTOResponseGetTicket;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created on 6/1/2015 : 11:44 AM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface EPGetTicket {

    @GET(EndPoints.GET_TICKET)
    void checkTicket(
            @Path(BaseTicketing.RQID) String rqid,
            @Path(BaseTicketing.APP) String app,
            @Path(BaseTicketing.ACTION) String action,
            @Path(BaseTicketing.BOOK_CODE) String bookCode,
            Callback<DTOResponseGetTicket> dtoResponseGetTicketCallback
    );
}
