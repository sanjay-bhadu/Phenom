package Service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.*;

public class ReservationService  {
     static Collection<IRoom> rooms=new ArrayList<>();

     static Collection<Reservation> reservations=new ArrayList<>();

    static public Collection<IRoom> getRooms() {
        Collection<IRoom> allrooms=new HashSet<>();
        for(Reservation r: reservations)
        {
            allrooms.add(r.getRoom());
        }
        allrooms.addAll(rooms);
        return allrooms;
    }



    static public  void addRoom(IRoom room){
        rooms.add(room);
        System.out.println(room);

    }


    static public IRoom getARoom(String RoomId)
    {
        for(IRoom t: rooms)
        {
            if(t.getRoomNumber().equals(RoomId))
                return t;
        }
        return null;
    }


   static public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
            Reservation res=new Reservation();
            //use iterator for removing reserved room.
       // i used iterator but ittelij idea suggested the functional programming.
       rooms.removeIf(r -> r.equals(room));
            res.setRoom(room);
            res.setCustomer(customer);
            res.setCheckInDate(checkInDate);
            res.setCheckOutDate(checkOutDate);
            reservations.add(res);
            return res;
    }


    public static Collection<IRoom> FindRoom(Date checkInDate, Date checkOutDate){
        Collection<IRoom> available=new HashSet<>();
        if(!reservations.isEmpty()) {
            for (Reservation r : reservations) {
                if (r != null) {
                    int temp = r.getCheckOutDate().compareTo(checkInDate);
                    int temp2=r.getCheckInDate().compareTo(checkOutDate);
                    if (temp < 0 && temp2 < 0) {
                        available.add(r.getRoom());
                    }
                }
            }
        }
        available.addAll(rooms);
        return available;
    }


    public static Collection<Reservation> getReservation(Customer customer){
        Collection<Reservation> res=new ArrayList<>();
        for(Reservation temp: reservations)
        {
            if(temp.getCustomer()==customer){
                res.add(temp);
            }
        }
        return res;
    }


    public static void printAllReservation() {
        if(reservations.isEmpty())
            System.out.println("Currently No Reservations");
        else {
            for (Reservation r : reservations) {
                System.out.println(r);
            }
        }
    }
}
