package UI;

import api.HotelResource;
import model.Customer;
import model.IRoom;
import model.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainMenu {
    public static void startActions(){
        boolean loop=true;
        while(loop)
        {
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
        System.out.println("Enter Your choice");
        Scanner scan=new Scanner(System.in);
        String action1 =scan.nextLine();
        switch (action1) {
            case "1": {
                System.out.println("Please Enter checkIN date in dd/mm/yy");
                Date checkIn = null;
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                String date=scan.nextLine();
                try {
                    checkIn=format.parse(date);
                } catch (ParseException e) {
                    System.out.println(e.getLocalizedMessage());
                    System.out.println("please Enter a Valid CheckIn Date");
                }
                Date checkOut;
                System.out.println("Enter the checkout Date");
                date=scan.nextLine();
                try {
                    checkOut=format.parse(date);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                Collection<IRoom> availableRoom= HotelResource.findARoom(checkIn,checkOut);
                while(availableRoom.isEmpty())
                {
                    System.out.println("Sorry At Moment No Rooms are available");
                    System.out.println();
                    System.out.println("Would you like to add reservation for another day");
                    System.out.println("Press y(Yes) and n(N0)");
                    String resp=scan.nextLine();
                    while(!resp.equalsIgnoreCase("y") || !resp.equalsIgnoreCase("n"))
                    {
                        if(resp.equalsIgnoreCase("y") || resp.equalsIgnoreCase("n"))
                            break;
                        System.out.println("Invalid Input!!!.... Enter again");
                        resp=scan.nextLine();
                    }
                    if(resp.equalsIgnoreCase("y"))
                    {
                        System.out.println("Please Enter checkIN date in dd/mm/yy");
                        date=scan.nextLine();
                        try {
                            checkIn=format.parse(date);
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("Enter the checkout Date");
                        date=scan.nextLine();
                        try {
                            checkOut=format.parse(date);
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                        availableRoom= HotelResource.findARoom(checkIn,checkOut);
                    }
                    else{
                        break;
                    }
                }
                for(IRoom r: availableRoom)
                {
                    System.out.println(r);
                }
                String roomid=scan.nextLine();
                IRoom room=HotelResource.getRoom(roomid);
                System.out.println("Do you any account with us");
                System.out.println("Press y for yes and n for no");
                String response=scan.nextLine();
                while(!response.equalsIgnoreCase("y") || !response.equalsIgnoreCase("n"))
                {
                    if(response.equalsIgnoreCase("y") || response.equalsIgnoreCase("n"))
                        break;
                    System.out.println("Invalid Input!!!.... Enter again");
                    response=scan.nextLine();
                }
                String Email;
                if(response.equalsIgnoreCase("y"))
                {
                    System.out.println("Enter your registered Email address");
                    String emailRegex = "^(.+)@(.+).(.+)$";
                    Pattern pattern = Pattern.compile(emailRegex);
                    Email = scan.nextLine();
                    while(!pattern.matcher(Email).matches())
                    {
                        System.out.println("Invalid Input!!!");
                        Email=scan.nextLine();
                    }
                    Customer customer=HotelResource.getCustomer(Email);
                    while(customer==null)
                    {
                        System.out.println("Enter the correct Email id as this is not present in database");
                        emailRegex = "^(.+)@(.+).(.+)$";
                        pattern = Pattern.compile(emailRegex);
                        Email = scan.nextLine();
                        while(!pattern.matcher(Email).matches())
                        {
                            System.out.println("Invalid Input!!!");
                            Email=scan.nextLine();
                        }
                        customer=HotelResource.getCustomer(Email);
                    }
                }
                else{
                    System.out.println("Enter your first Name");
                    String FirstName = scan.nextLine();
                    System.out.println("Please Enter your Last Name");
                    String LastName = scan.nextLine();
                    System.out.println("Please Enter your Email: name@domain.com");
                    String emailRegex = "^(.+)@(.+).(.+)$";
                    Pattern pattern = Pattern.compile(emailRegex);
                    Email = scan.nextLine();
                    while(!pattern.matcher(Email).matches())
                    {
                        System.out.println("Invalid Input!!!");
                        Email=scan.nextLine();
                    }
                    HotelResource.createACustomer(FirstName, LastName, Email);
                }
                Reservation reservation=HotelResource.bookARoom(Email,room,checkIn,checkOut);
                System.out.println(reservation);
                break;
            }
            case "2": {
                System.out.println("Please Enter your Email");
                String email=scan.nextLine();
                Collection<Reservation> res=HotelResource.getCustomerReservation(email);
                for(Reservation r: res)
                    System.out.println(r);

                break;
            }
            case "3": {
                    System.out.println("Please Enter your First Name");
                    String FirstName = scan.nextLine();
                    System.out.println("Please Enter your Last Name");
                    String LastName = scan.nextLine();
                    System.out.println("Please Enter your Email: name@domain.com");
                    String emailRegex = "^(.+)@(.+).(.+)$";
                    Pattern pattern = Pattern.compile(emailRegex);
                    String Email = scan.nextLine();
                    while(!pattern.matcher(Email).matches())
                    {
                        System.out.println("Invalid Input!!!");
                        Email=scan.nextLine();
                    }
                    HotelResource.createACustomer(FirstName, LastName, Email);

                break;
            }
            case "4": {
                AdminMenu.startAdmin();
                break;
            }

            case "5": {
                System.exit(0);
            }
            default:{
                System.out.println("Invalid Input!!! please try again");
                MainMenu.startActions();
                break;
            }
        }
    }
    }

}
