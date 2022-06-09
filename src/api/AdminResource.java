package api;

import Service.CustomerService;
import Service.ReservationService;
import model.Customer;
import model.IRoom;

import java.util.Collection;
import java.util.List;

import static api.HotelResource.customerService;
import static api.HotelResource.reservationService;

public class AdminResource {

//Returns the customer Details by giving Email as input.
    static public Customer getCustomer(String Email){
        return customerService.getCustomer(Email);
    }

//Addition of room.
    static public void addRoom(List<IRoom> room) {
        for (IRoom r : room){
            reservationService.addRoom(r);
    }
    }

//for getting all rooms in form of collection;
    static public Collection<IRoom> getAllRoom(){
        return reservationService.getRooms();
    }


    static public Collection<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }


    static public void DisplayAllReservation(){
        reservationService.printAllReservation();
    }


}
