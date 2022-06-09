package Service;

import model.Customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Pattern;

public class CustomerService {
    static public Collection<Customer> customer=new ArrayList<>();


    static public void addCustomer(String FirstName,String LastName,String Email){
        Customer temp=new Customer(FirstName,LastName,Email);
        customer.add(temp);
        System.out.println(temp);

    }


    static public Customer getCustomer(String Email){
        for(Customer temp: customer)
        {
            if(temp.getEmail().equals(Email)){
                return temp;
            }
        }
        return null;
    }


    static public Collection<Customer> getAllCustomers(){
        return customer;
    }


}
