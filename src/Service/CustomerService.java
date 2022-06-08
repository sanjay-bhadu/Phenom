package Service;

import model.Customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.regex.Pattern;

public class CustomerService {
    Collection<Customer> customer=new HashSet<Customer>();
    public void addCustomer(String FirstName,String LastName,String Email){
        Customer temp=new Customer(FirstName,LastName,Email);
        customer.add(temp);
        System.out.println(temp);

    }
    public Customer getCustomer(String Email){
        String EmailRegex="^(.+)@(.+).com$";
        Pattern pattern=Pattern.compile(EmailRegex);
        while(!pattern.matcher(Email).matches()){
            throw new RuntimeException("This is invalid Email Input");
        }
        for(Customer temp: customer)
        {
            if(temp.getEmail().equals(Email)){
                return temp;
            }
        }
        return null;
    }
    public Collection<Customer> getAllCustomers(){
        return customer;
    }
}
