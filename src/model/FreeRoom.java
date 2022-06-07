package model;

public class FreeRoom extends Room{

    public FreeRoom(String RoomNumber, Double RoomPrice, roomType RoomType) {
        super(RoomNumber, RoomPrice, RoomType);
        setRoomPrice(0.0);
    }
    @Override
    public String toString(){
        return "RoomNumber: "+getRoomNumber()+" RoomPrice: "+getRoomPrice()+" RoomType: "+getRoomType();
    }
}
