package UI;

public class HotelApplication {
    public static void main(String[] args) {
        try {
            MainMenu.startActions();
        }
        catch (Exception e)
        {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
