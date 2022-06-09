package model;

import java.util.regex.Pattern;

public class Customer {
    private final String FirstName;
    private final String LastName;
    private final String Email;
    public Customer(String FirstName,String LastName,String Email){
        this.Email=Email;
        this.FirstName=FirstName;
        this.LastName=LastName;
    }

    public String getEmail() {
        return Email;
    }

    @Override
    public String toString(){
        return "FirstName: "+FirstName+" LastName: "+LastName+" Email: "+Email;
    }
}
