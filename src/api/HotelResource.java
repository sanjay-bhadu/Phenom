package api;

import Service.CustomerService;
import Service.ReservationService;
import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.Collection;
import java.util.Date;

public class HotelResource {
    CustomerService customerService;
    ReservationService reservationService;
    public Customer getCustomer(String Email){
        Customer customer= customerService.getCustomer(Email);
        return customer;
    }
    public void createACustomer(String FirstName,String LastName,String Email)
    {
        customerService.addCustomer(FirstName,LastName,Email);
    }
    public IRoom getRoom(String RoomNumber)
    {
        return reservationService.getARoom(RoomNumber);
    }
    public Reservation bookARoom(String Email, String RoomNumber, Date checkInDate,Date checkOutDate){
        return null;
    }
    public Collection<Reservation> getCustomerReservation(String Email)
    {
        return null;
    }
    public Collection<IRoom> findARoom(Date checkInDate,Date checkOutDate){
        return reservationService.FindRoom(checkInDate,checkOutDate);
    }


}
