package Service;

import model.Customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class CustomerService {
    Collection<Customer> customer=new HashSet<Customer>();
    public void addCustomer(String FirstName,String LastName,String Email){
        Customer temp=new Customer(FirstName,LastName,Email);
        customer.add(temp);

    }
    public Customer getCustomer(String Email){
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
