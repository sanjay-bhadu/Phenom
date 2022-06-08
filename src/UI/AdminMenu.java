package UI;

import Service.CustomerService;
import api.AdminResource;
import model.Customer;
import model.IRoom;
import model.Room;

import java.util.Collection;
import java.util.Scanner;

public class AdminMenu {
    public AdminMenu(){
        System.out.println("Admin Menu");
        System.out.println();
        System.out.println("--------------------------------");
        System.out.println("1. See all Customers");
        System.out.println("2. See all Rooms");
        System.out.println("3. See all Reservations");
        System.out.println("4. Add a Room");
        System.out.println("5. Back to Main Menu");
        System.out.println();
        System.out.println("--------------------------------");
        System.out.println();
    }
    public void startAdmin(){
        AdminResource adminResource=new AdminResource();
        System.out.println("Enter your Choice");
        Scanner scan=new Scanner(System.in);
        String action=scan.nextLine();
        switch (action) {
            case "1": {
                Collection<Customer> customers=adminResource.getAllCustomers();
                for(Customer customer: customers)
                    System.out.println(customer);
                AdminMenu adminMenu=new AdminMenu();
                adminMenu.startAdmin();
                break;

            }
            case "2": {
                Collection<IRoom> rooms=adminResource.getAllRoom();
                for(IRoom room: rooms)
                    System.out.println(room);
                AdminMenu adminMenu=new AdminMenu();
                adminMenu.startAdmin();
                break;
            }
            case "3": {
                adminResource.DisplayAllReservation();
                AdminMenu adminMenu=new AdminMenu();
                adminMenu.startAdmin();
                break;

            }
            case "4": {

            }

            case "5": {
                MainMenu menu=new MainMenu();
                menu.startActions();
                break;
            }
        }
    }
    
}
