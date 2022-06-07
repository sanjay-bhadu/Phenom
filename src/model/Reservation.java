package model;

import java.util.Date;

public class Reservation {
    private Customer customer;
    private IRoom room;

    public void setRoom(IRoom room) {
        this.room = room;
    }

    public IRoom getRoom() {
        return room;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    private Date CheckInDate;
    private Date CheckOutDate;

    public Date getCheckInDate() {
        return CheckInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        CheckInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return CheckOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        CheckOutDate = checkOutDate;
    }

    @Override
    public String toString(){
        return "Customer: "+customer+" Room: "+room+" Check-in-Date: "+CheckInDate+" Check-out-Date: "+CheckOutDate;
    }
}
