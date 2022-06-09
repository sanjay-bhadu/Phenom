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


    static public Customer getCustomer(String Email){
        String EmailRegex="^(.+)@(.+).com$";
        Pattern pattern=Pattern.compile(EmailRegex);
        while(!pattern.matcher(Email).matches()){
            throw new RuntimeException("This is invalid Email Input");
        }
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


    static public Reservation bookARoom(String Email, String RoomNumber, Date checkInDate,Date checkOutDate){
        IRoom room= ReservationService.getARoom(RoomNumber);
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
