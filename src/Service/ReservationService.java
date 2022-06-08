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
    protected Collection<IRoom> rooms=new HashSet<IRoom>();

    public Collection<IRoom> getRooms() {
        return rooms;
    }

    protected Collection<Reservation> reservations=new ArrayList<Reservation>();
    public  void addRoom(IRoom room){
        rooms.add(room);

    }
    public IRoom getARoom(String RoomId)
    {
        for(IRoom t: rooms)
        {
            if(t.getRoomNumber().equals(RoomId))
                return t;
        }
        return null;
    }
    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        Collection<IRoom> temp=new HashSet<>();
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
    public Collection<IRoom> FindRoom(Date checkInDate,Date checkOutDate){
        Collection<IRoom> findroom=new HashSet<IRoom>();
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
        for(Reservation temp: reservations)
        {
            if(temp.getCustomer()==customer){
                res.add(temp);
            }
        }
        return res;
    }
    public void printAllReservation() {
        for (Reservation r : reservations) {
            System.out.println(r);
        }
    }
}
