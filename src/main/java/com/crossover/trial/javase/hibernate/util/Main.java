package com.crossover.trial.javase.hibernate.util;
import java.util.List;

import com.crossover.trial.javase.dao.BackendAPIsDAO;
import com.crossover.trial.javase.entities.Customer;
 
 
public class Main {
	
    public static void main(String[] args) {
         
         
        // Read
        System.out.println("******* READ *******");
        List<Customer> list = new BackendAPIsDAO().list(Customer.class);
        System.out.println("Total list: " + list.size());
         
         
     /*   // Write
        System.out.println("******* WRITE *******");
        Customer empl = new Customer("Jack", "Bauer", new Date(System.currentTimeMillis()), "911");
        empl = save(empl);
        empl = read(empl.getId());
        System.out.printf("%d %s %s \n", empl.getId(), empl.getFirstname(), empl.getLastname());
         
         
         
        // Update
        System.out.println("******* UPDATE *******");
        Customer empl2 = read(1l); // read Customer with id 1
        System.out.println("Name Before Update:" + empl2.getFirstname());
        empl2.setFirstname("James");
        update(empl2);  // save the updated Customer details
         
        empl2 = read(1l); // read again Customer with id 1
        System.out.println("Name Aftere Update:" + empl2.getFirstname());
         
         
        // Delete
        System.out.println("******* DELETE *******");
        delete(empl); 
        Customer empl3 = read(empl.getId());
        System.out.println("Object:" + empl3);*/
    }
     
     
 
     
}