package id.co.zisal.dmt.dto;

import org.parceler.Parcel;

/**
 * Created on 12/15/2015 : 7:21 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Parcel
public class DTOPassengerTicket {

    String bookingCode;
    String className;
    String subClassName;
    String vehicleCode;
    String vehicleName;
    String promoCode;
    String promoName;
    String passengerId;
    String passengerTitle;
    String passengerFirstName;
    String passengerLastName;
    String passengerBirthDate;
    String passengerPhoneNumber;
    String seatId;
    String ticketPrice;

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSubClassName() {
        return subClassName;
    }

    public void setSubClassName(String subClassName) {
        this.subClassName = subClassName;
    }

    public String getVehicleCode() {
        return vehicleCode;
    }

    public void setVehicleCode(String vehicleCode) {
        this.vehicleCode = vehicleCode;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public String getPromoName() {
        return promoName;
    }

    public void setPromoName(String promoName) {
        this.promoName = promoName;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public String getPassengerTitle() {
        return passengerTitle;
    }

    public void setPassengerTitle(String passengerTitle) {
        this.passengerTitle = passengerTitle;
    }

    public String getPassengerFirstName() {
        return passengerFirstName;
    }

    public void setPassengerFirstName(String passengerFirstName) {
        this.passengerFirstName = passengerFirstName;
    }

    public String getPassengerLastName() {
        return passengerLastName;
    }

    public void setPassengerLastName(String passengerLastName) {
        this.passengerLastName = passengerLastName;
    }

    public String getPassengerBirthDate() {
        return passengerBirthDate;
    }

    public void setPassengerBirthDate(String passengerBirthDate) {
        this.passengerBirthDate = passengerBirthDate;
    }

    public String getPassengerPhoneNumber() {
        return passengerPhoneNumber;
    }

    public void setPassengerPhoneNumber(String passengerPhoneNumber) {
        this.passengerPhoneNumber = passengerPhoneNumber;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "DTOPassengerTicket{" +
                "bookingCode='" + bookingCode + '\'' +
                ", className='" + className + '\'' +
                ", subClassName='" + subClassName + '\'' +
                ", vehicleCode='" + vehicleCode + '\'' +
                ", vehicleName='" + vehicleName + '\'' +
                ", promoCode='" + promoCode + '\'' +
                ", promoName='" + promoName + '\'' +
                ", passengerId='" + passengerId + '\'' +
                ", passengerTitle='" + passengerTitle + '\'' +
                ", passengerFirstName='" + passengerFirstName + '\'' +
                ", passengerLastName='" + passengerLastName + '\'' +
                ", passengerBirthDate='" + passengerBirthDate + '\'' +
                ", passengerPhoneNumber='" + passengerPhoneNumber + '\'' +
                ", seatId='" + seatId + '\'' +
                ", ticketPrice='" + ticketPrice + '\'' +
                '}';
    }
}
