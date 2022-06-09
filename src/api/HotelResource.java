package api;

import Service.CustomerService;
import Service.ReservationService;
import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.Collection;
import java.util.Date;
import java.util.regex.Pattern;

public class HotelResource {

    //GET CUSTOMER
    static public Customer getCustomer(String Email){
        Customer customer= CustomerService.getCustomer(Email);
        return customer;
    }


    static public void createACustomer(String FirstName,String LastName,String Email)
    {
        CustomerService.addCustomer(FirstName,LastName,Email);
    }


    static public IRoom getRoom(String RoomNumber)
    {
        return ReservationService.getARoom(RoomNumber);
    }


    static public Reservation bookARoom(String Email, IRoom room, Date checkInDate,Date checkOutDate){
        Customer customer=getCustomer(Email);
        return ReservationService.reserveARoom(customer,room,checkInDate,checkOutDate);

    }


    static public Collection<Reservation> getCustomerReservation(String Email)
    {
        Customer customer= CustomerService.getCustomer(Email);
        return ReservationService.getReservation(customer);
    }


    static public Collection<IRoom> findARoom(Date checkInDate,Date checkOutDate){
        return ReservationService.FindRoom(checkInDate,checkOutDate);
    }


}
