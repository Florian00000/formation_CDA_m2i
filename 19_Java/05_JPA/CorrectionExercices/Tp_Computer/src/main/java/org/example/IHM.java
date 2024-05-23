package org.example;

import org.example.Entity.Computer;
import org.example.Entity.Identifiant;
import org.example.Entity.OS;
import org.example.Entity.Processor;
import org.example.Repository.ComputerRepository;
import org.example.Repository.OSRepsitory;
import org.example.Repository.ProcessorRepository;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class IHM {
    EntityManagerFactory emf =  Persistence.createEntityManagerFactory("Computer_Jpa");
    EntityManager em = emf.createEntityManager();
    ComputerRepository computerRepository;
    OSRepsitory osRepsitory;

    ProcessorRepository processorRepository;
    Scanner sc ;

    public IHM() {
        computerRepository = new ComputerRepository(em);
        osRepsitory = new OSRepsitory(em);
        processorRepository = new ProcessorRepository(em);
        sc = new Scanner(System.in);
    }

    public void start (){
        while (true){
            System.out.println("Menu : ");
            System.out.println("1/ cree");
            System.out.println("2/ afficher tout");
            System.out.println("3/ afficher par id");
            System.out.println("4/ supprimer");
            System.out.println("5/ editer");
            System.out.println("6/ create os");
            System.out.println("7/ create processor");
            System.out.println("8/ Show OS");
            System.out.println("9: peripheriqueIhm");
            int entry = sc.nextInt();
            sc.nextLine();
            switch (entry){
                case 1:
                    createComputer();
                    break;
                case 2:
                    getAllComputer();
                    break;
                case 3:
                    getComputerById();
                    break;
                case 4:
                    deleteComputer();
                    break;
                case 5:
                    editComputer();
                    break;
                case 6 :
                    createOs();
                    break;
                case 7 :
                    createProcessor();
                    break;
                case 8 :
                    showInfo();
                    break;
                case 9:
                    IhmPeripherique ihmPeripherique = new IhmPeripherique(sc,em);
                    ihmPeripherique.start();
                    break;
                default:
                    return;
            }
        }

    }

    private void createComputer (){

        Identifiant identifiant = Identifiant.builder().iMac("Mon adresse imac").ip("mon adress ip").build();
        Processor processor = em.find(Processor.class,1);
        OS os = em.find(OS.class,1);
        Computer computer = Computer.builder().name("MyComputer").price(1200.50f).identifiant(identifiant).processor(processor).os(os).build();

        computerRepository.save(computer);
    }

    private void getAllComputer (){
        List<Computer> computerList = computerRepository.findAll();

        for (Computer computer : computerList){
            System.out.println(computer);
        }
    }

    private void createOs (){
        OS os = OS.builder().name("Windows").Version("10.12").build();
        osRepsitory.save(os);
    }

    private void createProcessor (){
        Processor processor = Processor.builder().heart(5).thread(8000).generation(7).build();
        processorRepository.save(processor);
    }

    private Computer getComputerById (){
        System.out.println("id computer :");
        int id = sc.nextInt();
        sc.nextLine();

        Computer computer = computerRepository.findById(id);
        if(computer != null){
            System.out.println(computer);
        }else {
            System.out.println("Computer not found");
        }
        return computer;
    }

    private void deleteComputer (){
        Computer computer = getComputerById();
        if(computer != null){
            computerRepository.delete(computer);
        }
    }

    private void editComputer (){
        Computer computer = getComputerById();
        if(computer != null){
            computer.setName("myComputer2");
            computer.setPrice(1000.99f);
            computerRepository.save(computer);
        }

    }

    private void showInfo (){
        OS os = osRepsitory.findById(1);
        System.out.println( "Os found : "+os);
    }
}
