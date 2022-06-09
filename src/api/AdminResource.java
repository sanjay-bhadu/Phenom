package api;

import Service.CustomerService;
import Service.ReservationService;
import model.Customer;
import model.IRoom;

import java.util.Collection;
import java.util.List;


public class AdminResource {

//Returns the customer Details by giving Email as input.
    static public Customer getCustomer(String Email){
        return CustomerService.getCustomer(Email);
    }

//Addition of room.
    static public void addRoom(List<IRoom> room) {
        for (IRoom r : room){
            ReservationService.addRoom(r);
    }
    }

//for getting all rooms in form of collection;
    static public Collection<IRoom> getAllRoom(){
        return ReservationService.getRooms();
    }


    static public Collection<Customer> getAllCustomers(){
        return CustomerService.getAllCustomers();
    }


    static public void DisplayAllReservation(){
        ReservationService.printAllReservation();
    }


}
