package UI;

import api.HotelResource;
import model.IRoom;
import model.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

public class MainMenu {
    public MainMenu(){
        System.out.println("Welcome to the Hotel Reservation Application");
        System.out.println();
        System.out.println("--------------------------------------------");
        System.out.println("1. Find and reserve a room");
        System.out.println("2. See my reservations");
        System.out.println("3. Create an account");
        System.out.println("4. Admin Menu");
        System.out.println("5. Exit");
        System.out.println();
        System.out.println("-------------------------------------------");
    }
    public void startActions(){
        System.out.println("Enter Your choice");
        Scanner scan=new Scanner(System.in);
        String action1 =scan.nextLine();
        HotelResource hotelResource = new HotelResource();
        switch (action1) {
            case "1": {
                System.out.println("Please Enter checkIN date in dd/mm/yy");
                Date checkIn;
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                String date=scan.nextLine();
                try {
                    checkIn=format.parse(date);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                Date checkOut;
                System.out.println("Enter the checkout Date");
                date=scan.nextLine();
                try {
                    checkOut=format.parse(date);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                Collection<IRoom> availableRoom=hotelResource.findARoom(checkIn,checkOut);
                for(IRoom r: availableRoom)
                {
                    System.out.println(r);
                }
                String roomid=scan.nextLine();
                hotelResource.getRoom(roomid);
                System.out.println("Do you any account with us");
                System.out.println("Press y for yes and n for no");
                String response=scan.nextLine();
                while(!response.equals("y") || !response.equals("n"))
                {
                    if(response.equals("y") || response.equals("n"))
                        break;
                    System.out.println("Invalid Input!!!.... Enter again");
                    response=scan.nextLine();
                }

                String Email;
                if(response=="y")
                {
                    System.out.println("please enter Email id");
                    Email=scan.nextLine();
                }
                else{
                    System.out.println("Enter your first Name");
                    String FirstName = scan.nextLine();
                    System.out.println("Please Enter your Last Name");
                    String LastName = scan.nextLine();
                    System.out.println("Please Enter your Email: name@domain.com");
                    Email = scan.nextLine();
                    hotelResource.createACustomer(FirstName, LastName, Email);
                }
                Reservation reservation=hotelResource.bookARoom(Email,roomid,checkIn,checkOut);
                System.out.println(reservation);

                MainMenu menu=new MainMenu();
                menu.startActions();
            }
            case "2": {
                System.out.println("Please Enter your Email");
                String email=scan.nextLine();
                hotelResource.getCustomerReservation(email);
                MainMenu menu=new MainMenu();
                menu.startActions();
                break;
            }
            case "3": {
                    System.out.println("Please Enter your First Name");
                    String FirstName = scan.nextLine();
                    System.out.println("Please Enter your Last Name");
                    String LastName = scan.nextLine();
                    System.out.println("Please Enter your Email: name@domain.com");
                    String Email = scan.nextLine();
                    hotelResource.createACustomer(FirstName, LastName, Email);

                break;
            }
            case "4": {
                AdminMenu adminMenu=new AdminMenu();
                adminMenu.startAdmin();
                break;
            }

            case "5": {
                System.exit(0);
            }
        }
    }

}