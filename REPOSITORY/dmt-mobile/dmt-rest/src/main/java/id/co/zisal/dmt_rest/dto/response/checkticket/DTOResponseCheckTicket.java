package id.co.zisal.dmt_rest.dto.response.checkticket;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.math.BigDecimal;
import java.util.ArrayList;

import id.co.zisal.dmt_common.constant.ApplicationConstant.Rest.DTO.Response.CheckTicket;
import id.co.zisal.dmt_rest.dto.response.DTOBaseResponse;

/**
 * Created on 12/14/2015 : 3:22 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Parcel
public class DTOResponseCheckTicket extends DTOBaseResponse {

    @SerializedName(CheckTicket.ORIGINATION)
    String origination;

    @SerializedName(CheckTicket.DESTINATION)
    String destination;

    @SerializedName(CheckTicket.DEPARTURE_DATE)
    String departureDate;

    @SerializedName(CheckTicket.TRAIN_NUMBER)
    String trainNumber;

    @SerializedName(CheckTicket.PASSENGER_NUMBER)
    ArrayList<Integer> passengerNumber;

    @SerializedName(CheckTicket.PASSENGER_NAME)
    ArrayList<String> passengerName;

    @SerializedName(CheckTicket.SEAT)
    ArrayList<ArrayList<String>> seat;

    @SerializedName(CheckTicket.NORMAL_SALES)
    BigDecimal normalSales;

    @SerializedName(CheckTicket.EXTRA_FEE)
    BigDecimal extraFee;

    @SerializedName(CheckTicket.BOOK_BALANCE)
    BigDecimal bookBalance;

    public String getOrigination() {
        return origination;
    }

    public void setOrigination(String origination) {
        this.origination = origination;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public ArrayList<Integer> getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(ArrayList<Integer> passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public ArrayList<String> getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(ArrayList<String> passengerName) {
        this.passengerName = passengerName;
    }

    public ArrayList<ArrayList<String>> getSeat() {
        return seat;
    }

    public void setSeat(ArrayList<ArrayList<String>> seat) {
        this.seat = seat;
    }

    public BigDecimal getNormalSales() {
        return normalSales;
    }

    public void setNormalSales(BigDecimal normalSales) {
        this.normalSales = normalSales;
    }

    public BigDecimal getExtraFee() {
        return extraFee;
    }

    public void setExtraFee(BigDecimal extraFee) {
        this.extraFee = extraFee;
    }

    public BigDecimal getBookBalance() {
        return bookBalance;
    }

    public void setBookBalance(BigDecimal bookBalance) {
        this.bookBalance = bookBalance;
    }

    @Override
    public String toString() {
        return "DTOCheckTicket{" +
                "origination='" + origination + '\'' +
                ", destination='" + destination + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", trainNumber='" + trainNumber + '\'' +
                ", passengerNumber=" + passengerNumber +
                ", passengerName=" + passengerName +
                ", seat=" + seat +
                ", normalSales=" + normalSales +
                ", extraFee=" + extraFee +
                ", bookBalance=" + bookBalance +
                '}';
    }
}
