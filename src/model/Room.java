package model;

public class Room implements IRoom{
    private final String RoomNumber;
    private  Double RoomPrice;
    private final roomType RoomType;
    public Room(String RoomNumber,Double RoomPrice,roomType RoomType)
    {

        this.RoomType=RoomType;
        this.RoomNumber=RoomNumber;
        this.RoomPrice=RoomPrice;
    }
    @Override
    public String getRoomNumber() {
        return RoomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return RoomPrice;
    }
    public void setRoomPrice(Double roomPrice) {
        RoomPrice = roomPrice;
    }
    @Override
    public roomType getRoomType() {
        return RoomType;
    }
    @Override
    public boolean isFree(){
        return true;
    }
    @Override
    public String toString(){
        return "RoomNumber :"+ RoomNumber+" RoomPrice: "+RoomPrice+" RoomType: "+RoomType;
    }
}
