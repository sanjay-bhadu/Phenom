package UI;

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
        System.out.println("Enter your Choice");
        Scanner scan=new Scanner(System.in);
        String action=scan.nextLine();
        switch (action) {
            case "1": {

            }
            case "2": {

            }
            case "3": {

            }
            case "4": {

            }

            case "5": {
                MainMenu menu=new MainMenu();
                menu.startActions();
            }
        }
    }
    
}
