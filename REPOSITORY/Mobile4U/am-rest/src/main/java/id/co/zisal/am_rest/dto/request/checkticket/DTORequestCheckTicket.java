package id.co.zisal.am_rest.dto.request.checkticket;

import org.parceler.Parcel;

import id.co.zisal.am_rest.dto.request.DTOBaseRequest;

/**
 * Created on 12/14/2015 : 4:29 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Parcel
public class DTORequestCheckTicket extends DTOBaseRequest {

    private String bookingCode;

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    @Override
    public String toString() {
        return "DTORequestCheckTicket{" +
                "bookingCode='" + bookingCode + '\'' +
                '}';
    }
}
