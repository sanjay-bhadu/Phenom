package Service;

import api.AdminResource;
import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;

import java.net.CookieHandler;
import java.text.CollationElementIterator;
import java.util.*;

public class ReservationService  {
     static Collection<IRoom> rooms=new ArrayList<IRoom>();

     static Collection<Reservation> reservations=new ArrayList<Reservation>();

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
        Collection<IRoom> temp=new ArrayList<>();
        temp=FindRoom(checkInDate,checkOutDate);
        if(temp.isEmpty())
        {
            return null;
        }
        else{
            Reservation res=new Reservation();
            for(IRoom r: temp){
                res.setRoom(r);
                break;
            }
            res.setCustomer(customer);
            res.setCheckInDate(checkInDate);
            res.setCheckOutDate(checkOutDate);
            reservations.add(res);
            return res;
        }
    }


    public static Collection<IRoom> FindRoom(Date checkInDate, Date checkOutDate){
        Collection<IRoom> findroom=new ArrayList<>();
        for(Reservation r: reservations)
        {
            int temp=r.getCheckOutDate().compareTo(checkInDate);
            if(temp<=1)
            {
                findroom.add(r.getRoom());
            }
        }
        return findroom;
    }


    public Collection<Reservation> getReservation(Customer customer){
        Collection<Reservation> res=new ArrayList<Reservation>();
        for(Reservation temp: this.reservations)
        {
            if(temp.getCustomer()==customer){
                res.add(temp);
            }
        }
        return res;
    }


    public void printAllReservation() {
        for (Reservation r : this.reservations) {
            System.out.println(r);
        }
    }
}
