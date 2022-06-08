package UI;

import api.HotelResource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
                Date CheckOut;
                System.out.println("Enter the checkout Date");
                date=scan.nextLine();
                try {
                    CheckOut=format.parse(date);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

            }
            case "2": {
                System.out.println("Please Enter your Email");
                String email=scan.nextLine();
                hotelResource.getCustomerReservation(email);
                break;
            }
            case "3": {
                System.out.println("Please Enter your First Name");
                String FirstName=scan.nextLine();
                System.out.println("Please Enter your Last Name");
                String LastName=scan.nextLine();
                System.out.println("Please Enter your Email");
                String Email=scan.nextLine();
                hotelResource.createACustomer(FirstName,LastName,Email);
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
