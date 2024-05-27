package org.example.Controller;

import org.example.Entity.Account;
import org.example.Entity.Adresse;
import org.example.Entity.Agency;
import org.example.Repository.AgencyRepository;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class AgencyIhm {

    private Scanner scanner;
    private AgencyRepository agencyRepository;
    public AgencyIhm(EntityManager em, Scanner scanner) {
        this.scanner = scanner;
        agencyRepository= new AgencyRepository(em);
    }
    public void start(){
        int entry ;

        while (true){
            System.out.println("--- Agency ---");
            System.out.println("1/ Create Agency");
            System.out.println("2/ Edit Agency");
            System.out.println("3/ Delete Agency");
            System.out.println("4/ find by id Agency");
            System.out.println("5/ find all Agency");
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
        System.out.println("Product Address :");
        String address = scanner.nextLine();


        Agency agency = Agency.builder().adresse(Adresse.builder().adresse(address).build()).build();
        agencyRepository.save(agency);
    }

    private void edit (){

    }

    private void delete (){

    }

    private Agency findById (){
        System.out.println("Agency id");
        int id = scanner.nextInt();
        scanner.nextLine();

        return (Agency) agencyRepository.findById(id);

    }

    private void showById (){
        System.out.println("-- Show By id Account --");
        Agency agency = findById();

        if(agency != null){
            System.out.println(" account : "+ agency);
        }else{
            System.out.println("no product found");
        }
    }

    private void showAll () {

    }
}
