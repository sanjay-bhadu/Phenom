package model;

import jdk.swing.interop.SwingInterOpUtils;

public class Tester {
    public static void main(String[] args) {
        try {
            Customer customer = new Customer("Sanjay", "Bhadu", "bhadusanjay2@gmail.com");
            System.out.println(customer);
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        FreeRoom f=new FreeRoom("101",90.0,roomType.DOUBLE);
        System.out.println(f);
    }
}
