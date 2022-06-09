package api;

import Service.CustomerService;
import Service.ReservationService;
import model.Customer;
import model.IRoom;

import java.util.Collection;
import java.util.List;


public class AdminResource {

   //GET CUSTOMER.
    static public Customer getCustomer(String Email){
        return CustomerService.getCustomer(Email);
    }

   // ADD ROOM
    static public void addRoom(List<IRoom> room) {
        for (IRoom r : room){
            ReservationService.addRoom(r);
    }
    }

      //GET ALL ROOMS
    static public Collection<IRoom> getAllRoom(){
        return ReservationService.getRooms();
    }

     //GET ALL CUSTOMERS
    static public Collection<Customer> getAllCustomers(){
        return CustomerService.getAllCustomers();
    }

    //DISPLAY ALL RESERVATIONS;
    static public void DisplayAllReservation(){
        ReservationService.printAllReservation();
    }


}
