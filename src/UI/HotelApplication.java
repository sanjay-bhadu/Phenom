package UI;

public class HotelApplication {
    public static void main(String[] args) {
        try{
        MainMenu mainMenu=new MainMenu();
        mainMenu.startActions();}
        catch (Exception e)
        {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
