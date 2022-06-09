package Service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.*;

public class ReservationService  {
     static Collection<IRoom> rooms=new ArrayList<>();

     static Collection<Reservation> reservations=new ArrayList<>();

    static public Collection<IRoom> getRooms() {
        return rooms;
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
            rooms.remove(room);
            res.setRoom(room);
            res.setCustomer(customer);
            res.setCheckInDate(checkInDate);
            res.setCheckOutDate(checkOutDate);
            reservations.add(res);
            return res;
    }


    public static Collection<IRoom> FindRoom(Date checkInDate, Date checkOutDate){
        Collection<IRoom> available=new ArrayList<>();
        for(Reservation r: reservations)
        {
            int temp=r.getCheckOutDate().compareTo(checkInDate);
            if(temp<=1)
            {
                available.add(r.getRoom());
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
        for (Reservation r : reservations) {
            System.out.println(r);
        }
    }
}
