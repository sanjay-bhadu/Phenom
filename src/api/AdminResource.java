package api;

import Service.CustomerService;
import Service.ReservationService;
import model.Customer;
import model.IRoom;

import java.util.Collection;
import java.util.List;

public class AdminResource {
    CustomerService customerService;

    ReservationService reservationService;

//Returns the customer Details by giving Email as input.
    public Customer getCustomer(String Email){
        return customerService.getCustomer(Email);
    }

//Addition of room.
    public void addRoom(List<IRoom> room) {
        for (IRoom r : room){
            reservationService.addRoom(r);
    }
    }

//for getting all rooms in form of collection;
    public Collection<IRoom> getAllRoom(){
        return reservationService.getRooms();
    }


    public Collection<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }


    public void DisplayAllReservation(){
        reservationService.printAllReservation();
    }


}
