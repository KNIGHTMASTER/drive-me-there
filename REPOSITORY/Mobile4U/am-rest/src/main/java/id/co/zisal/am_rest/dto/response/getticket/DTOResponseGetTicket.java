package id.co.zisal.am_rest.dto.response.getticket;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.ArrayList;

import id.co.zisal.am_common.constant.ApplicationConstant.Rest.DTO.Response.GetTicket;

/**
 * Created on 12/15/2015 : 4:19 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Parcel
public class DTOResponseGetTicket {

    @SerializedName(GetTicket.DEPARTURE_DATE)
    private String departureDate;

    @SerializedName(GetTicket.ETA)
    private String eta;

    @SerializedName(GetTicket.ARRIVAL_DATE)
    private String arrivalDate;

    @SerializedName(GetTicket.ERROR_CODE)
    private String errorCode;

    @SerializedName(GetTicket.PAYMENT_TYPE)
    private String paymentType;

    @SerializedName(GetTicket.ETD)
    private String etd;

    @SerializedName(GetTicket.CITY_FROM)
    private String cityFrom;

    @SerializedName(GetTicket.RESERVATION_DATE)
    private String reservationDate;

    @SerializedName(GetTicket.ORIGINATION)
    private String origination;

    @SerializedName(GetTicket.TICKETS)
    ArrayList<ArrayList<String>> tickets;

    @SerializedName(GetTicket.PASSENGER_NUMBER)
    Integer passengerNumber;

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getEtd() {
        return etd;
    }

    public void setEtd(String etd) {
        this.etd = etd;
    }

    public String getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getOrigination() {
        return origination;
    }

    public void setOrigination(String origination) {
        this.origination = origination;
    }

    public ArrayList<ArrayList<String>> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<ArrayList<String>> tickets) {
        this.tickets = tickets;
    }

    public Integer getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(Integer passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "DTOResponseGetTicket{" +
                "departureDate='" + departureDate + '\'' +
                ", eta='" + eta + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", etd='" + etd + '\'' +
                ", cityFrom='" + cityFrom + '\'' +
                ", reservationDate='" + reservationDate + '\'' +
                ", origination='" + origination + '\'' +
                ", tickets=" + tickets +
                ", passengerNumber=" + passengerNumber +
                '}';
    }
}
