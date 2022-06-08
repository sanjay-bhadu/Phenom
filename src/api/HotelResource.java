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
    CustomerService customerService=new CustomerService();
    ReservationService reservationService=new ReservationService();
    public Customer getCustomer(String Email){
        String EmailRegex="^(.+)@(.+).com$";
        Pattern pattern=Pattern.compile(EmailRegex);
        while(!pattern.matcher(Email).matches()){
            throw new RuntimeException("This is invalid Email Input");
        }
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
        IRoom room=reservationService.getARoom(RoomNumber);
        Customer customer=getCustomer(Email);
        return reservationService.reserveARoom(customer,room,checkInDate,checkOutDate);

    }
    public Collection<Reservation> getCustomerReservation(String Email)
    {
        Customer customer=customerService.getCustomer(Email);
        return reservationService.getReservation(customer);
    }
    public Collection<IRoom> findARoom(Date checkInDate,Date checkOutDate){
        return reservationService.FindRoom(checkInDate,checkOutDate);
    }


}
