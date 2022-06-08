package model;

import java.util.regex.Pattern;

public class Customer {
    private String FirstName;
    private String LastName;
    private String Email;
    public Customer(String FirstName,String LastName,String Email){

            String EmailRegex="^(.+)@(.+).com$";
            Pattern pattern=Pattern.compile(EmailRegex);
            while(!pattern.matcher(Email).matches()){
                throw new RuntimeException("This is invalid Email Input");
            }
        this.Email=Email;
        this.FirstName=FirstName;
        this.LastName=LastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString(){
        return "FirstName: "+getFirstName()+" LastName: "+getLastName()+" Email: "+getEmail();
    }
}
