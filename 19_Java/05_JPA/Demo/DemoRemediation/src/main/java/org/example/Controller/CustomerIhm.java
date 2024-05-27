package org.example.Controller;

import org.example.Entity.Adresse;
import org.example.Entity.Agency;
import org.example.Entity.Customer;
import org.example.Repository.CustomerRepository;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class CustomerIhm {

    private Scanner scanner;
    private CustomerRepository customerRepository;

    public CustomerIhm(EntityManager em, Scanner scanner) {
        this.scanner = scanner;
        customerRepository = new CustomerRepository(em);
    }

    public void start(){
        int entry ;

        while (true){
            System.out.println("--- Customer ---");
            System.out.println("1/ Create Customer");
            System.out.println("2/ Edit Customer");
            System.out.println("3/ Delete Customer");
            System.out.println("4/ find by id Customer");
            System.out.println("5/ find all Customer");
            entry = scanner.nextInt();
            scanner.nextLine();
            switch (entry){
                case 1:
                    add();
                    break;
                case 2:
                    edit();
                    break;
                case 3 :
                    delete();
                    break;
                case 4:
                    showById();
                    break;
                case 5 :
                    showAll();
                    break;
                default:
                    return;
            }
        }
    }


    private void add (){
        System.out.println("-- Create Agency --");
        System.out.println("customer name :");
        String firstname = scanner.nextLine();
        System.out.println("customer lastname");
        String lastname = scanner.nextLine();


        Customer customer = Customer.builder().lastname(lastname).firstname(firstname).build();
        customerRepository.save(customer);
    }

    private void edit (){

    }

    private void delete (){

    }

    private Customer findById (){
        System.out.println("Customer id");
        int id = scanner.nextInt();
        scanner.nextLine();

        return customerRepository.findById(id);

    }

    private void showById (){
        System.out.println("-- Show By id Account --");
        Customer customer = findById();

        if(customer != null){
            System.out.println(" Customer : "+ customer);
        }else{
            System.out.println("no product found");
        }
    }

    private void showAll () {

    }
}
