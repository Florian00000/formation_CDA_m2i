package org.example.Controller;

import org.example.Entity.Account;
import org.example.Entity.Agency;
import org.example.Entity.Customer;
import org.example.Repository.AccountRepository;
import org.example.Repository.AgencyRepository;
import org.example.Repository.CustomerRepository;

import javax.persistence.EntityManager;
import java.util.AbstractCollection;
import java.util.List;
import java.util.Scanner;

public class AccountIhm {

    private Scanner scanner;

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;
    private AgencyRepository agencyRepository;

    public AccountIhm(EntityManager em, Scanner scanner) {
        this.scanner = scanner;
        accountRepository = new AccountRepository(em);
        customerRepository = new CustomerRepository(em);
        agencyRepository = new AgencyRepository(em);
    }

    public void start(){
        int entry ;

        while (true){
            System.out.println("--- Account ---");
            System.out.println("1/ Create Account");
            System.out.println("2/ Edit Account");
            System.out.println("3/ Delete Account");
            System.out.println("4/ find by id Account");
            System.out.println("5/ find all Account");
            System.out.println("6/ add customer");
            System.out.println("7/ add agency");

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
                case 6:
                    addCustomer();
                    break;
                case 7:
                    addAgency();
                    break;
                default:
                    return;
            }
        }
    }


    private void add (){
        System.out.println("-- Create Account --");
        System.out.println("Product libelle :");
        String libelle = scanner.nextLine();
        System.out.println("Product Iban :");
        String iban = scanner.nextLine();
        System.out.println("Balance :");
        float balance = scanner.nextFloat();
        scanner.nextLine();

        Account account = Account.builder().libelle(libelle).iban(iban).balance(balance).build();
        accountRepository.save(account);
    }

    private void edit (){

    }

    private void delete (){

    }

    private Account findById (){
        System.out.println("Account id");
        int id = scanner.nextInt();
        scanner.nextLine();

        return (Account) accountRepository.findById(id);

    }

    private void showById (){
        System.out.println("-- Show By id Account --");
        Account account = findById();

        if(account != null){
            System.out.println(" account : "+ account);
        }else{
            System.out.println("no product found");
        }
    }

    private void showAll () {

    }

    private void addCustomer (){
        System.out.println("-- add customer to account --");
        Account account = findById();

        System.out.println("id customer :");
        int id = scanner.nextInt();
        scanner.nextLine();

        Customer customer = customerRepository.findById(id);

        if(account != null && customer != null){
            account.add(customer);
            accountRepository.save(account);
        }else{
            System.out.println("account or customer not found");
        }
    }

    private void addAgency (){
        System.out.println("-- add Agnecy to account --");
        Account account = findById();
        if(account !=null && account.getAgency() == null){
            System.out.println("id Agency :");
            int id = scanner.nextInt();
            scanner.nextLine();

            Agency agency = agencyRepository.findById(id);

            if(agency != null){
                account.setAgency(agency);
                accountRepository.save(account);
            }else{
                System.out.println("account or agency not found");
            }
        }


    }

}
