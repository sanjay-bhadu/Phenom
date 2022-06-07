package api;

import com.sun.tools.javac.Main;

import java.util.Scanner;

public class MainMenu {
    static Scanner scan=new Scanner(System.in);
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
        String action =scan.nextLine();
        scan.close();
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

            }
        }
    }

}
