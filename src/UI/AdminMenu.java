package UI;

import Service.CustomerService;
import api.AdminResource;
import model.Customer;
import model.IRoom;
import model.Room;
import model.roomType;

import java.util.*;


public class AdminMenu {
    public static void startAdmin() {
        boolean loop = true;
        while (loop) {
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
            System.out.println("Enter your Choice");
            Scanner scan = new Scanner(System.in);
            String action = scan.nextLine();
            switch (action) {


                case "1": {


                    Collection<Customer> customers = new ArrayList<>();
                    customers = AdminResource.getAllCustomers();
                    for (Customer customer : customers)
                        System.out.println(customer);
                    break;

                }
                case "2": {


                    Collection<IRoom> rooms = new ArrayList<IRoom>();
                    rooms = AdminResource.getAllRoom();
                    for (IRoom room : rooms)
                        System.out.println(room);

                    break;


                }
                case "3": {
                    AdminResource.DisplayAllReservation();
                    break;
                }


                case "4": {

                    List<IRoom> rooms = new ArrayList<>();
                    boolean r = true;
                    while (r) {
                        System.out.println("Do you want to add Room.. Press Y(yes) and N(No). ");
                        String response = scan.nextLine();
                        if (response.equalsIgnoreCase("y")) {
                            System.out.println("Enter RoomNumber ");
                            String roomnumber = scan.nextLine();
                            System.out.println("Enter Room Price");
                            Double roomprice;
                            while (!scan.hasNextDouble()) {
                                System.out.println("Invalid Input!!\n Please provide valid input!!");
                                scan.next();
                            }
                            roomprice = scan.nextDouble();
                            roomType roomtype;
                            System.out.println("Select Room type\n 1.Single \n 2.Double");
                            int input;
                            while (!scan.hasNextInt()) {
                                System.out.println("Invalid Input\n Please give Integer Input");
                                scan.next();
                            }
                            input = scan.nextInt();
                            if (input == 1) {
                                roomtype = roomType.SINGLE;
                            } else
                                roomtype = roomType.DOUBLE;
                            IRoom room = new Room(roomnumber, roomprice, roomtype);
                            rooms.add(room);
                            String temp = scan.nextLine();//this is to avoid auto closure.. due to use to scan.nextInt() and scan.nextLine() in row.
                        }
                        else if(response.equalsIgnoreCase("n"))
                        {
                            r=false;
                        }
                        else{

                        }
                        }

                    AdminResource.addRoom(rooms);

                    break;

                }

                case "5": {
                    MainMenu.startActions();
                    break;
                }
                default: {
                    System.out.println("Invlaid Input!!!.. Please Enter Again");
                    AdminMenu.startAdmin();
                    throw new IllegalStateException("Unexpected value: " + action);
                }
            }
        }
    }
    
}
