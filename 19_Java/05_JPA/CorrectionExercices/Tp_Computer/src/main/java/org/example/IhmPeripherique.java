package org.example;

import org.example.Entity.Computer;
import org.example.Entity.Peripherique;
import org.example.Repository.ComputerRepository;
import org.example.Repository.PeripheriqueRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class IhmPeripherique {

    private Scanner sc ;
    private PeripheriqueRepository peripheriqueRepository;
    private ComputerRepository computerRepository;

    public IhmPeripherique(Scanner sc, EntityManager em) {
        this.sc = sc;
        peripheriqueRepository = new PeripheriqueRepository(em);
        computerRepository = new ComputerRepository(em);
    }

    public void start (){
        while (true){
            System.out.println("Menu : ");
            System.out.println("1/ cree un peripherique");
            System.out.println("2/ afficher tout les peripherique");
            System.out.println("3/ afficher par id un peripherique");
            System.out.println("4/ mettre a jour un peripherique");
            System.out.println("5/ supprimer un peripherique");
            System.out.println("6/ ajouter un computer a un peripherique");
            System.out.println("7/ afficher les peripherique d'un computer");

            int entry = sc.nextInt();
            sc.nextLine();
            switch (entry){
                case 1:
                    createPeripherique();
                    break;
                case 2:
                    showAll();
                    break;
                case 3:
                    showById();
                    break;
                case 4:
                    updatePeripherique();
                    break;
                case 5:
                    removePeripherique();
                    break;
                case 6 :
                    addComputer();
                    break;
                case 7:
                    showPeriphFromComputer();
                    break;
                default:
                    return;
            }
        }
    }

    private void createPeripherique (){
        System.out.println("creation d'un peripherique");
        System.out.println("nom du peripherique :");
        String name = sc.nextLine();
        System.out.println("nombre de ports : ");
        int nbrPorts = sc.nextInt();
        sc.nextLine();

        Peripherique peripherique = Peripherique.builder().nbrPorts(nbrPorts).name(name).build();

        peripheriqueRepository.save(peripherique);
    }

    private void showAll (){
        System.out.println("Afficher tout les peripherique");
        List<Peripherique> peripheriques = peripheriqueRepository.findAll();

        for (Peripherique peripherique : peripheriques){
            System.out.println(peripherique);
        }
    }

    private void showById (){
        System.out.println("afficher un peripherique par id");
        System.out.println("id du peripherique : ");
        int id = sc.nextInt();
        sc.nextLine();

        Peripherique peripherique = peripheriqueRepository.findById(id);
        if(peripherique != null){
            System.out.println(peripherique);
        }else {
            System.out.println("aucun peripherique trouvé");
        }
    }

    private void updatePeripherique (){
        System.out.println("mise a jour d'un peripherique");
        System.out.println("id du peripherique");
        int id = sc.nextInt();
        sc.nextLine();

        Peripherique peripherique = peripheriqueRepository.findById(id);

        if(peripherique != null){
            System.out.println("nom du peripherique : ( " + peripherique.getName() +" )" );
            peripherique.setName(sc.nextLine());
            System.out.println("nombre de ports : ( " + peripherique.getNbrPorts() +" )" );
           peripherique.setNbrPorts(sc.nextInt());
            sc.nextLine();
            peripheriqueRepository.save(peripherique);
        }else{
            System.out.println("aucun peripherique trouvé");
        }
    }

    private void removePeripherique (){
        System.out.println("suppresion d'un peripherique");
        System.out.println("id du peripherique");
        int id = sc.nextInt();
        sc.nextLine();

        Peripherique peripherique = peripheriqueRepository.findById(id);
        if(peripherique != null){
            peripheriqueRepository.delete(peripherique);
        }else{
            System.out.println("aucun peripherique trouvé");
        }
    }

    private void addComputer (){
        System.out.println("ajout d'un computer a un peripherique");
        System.out.println("id du peripherique");
        int idPeripherique = sc.nextInt();
        sc.nextLine();

        System.out.println("id du computer");
        int idComputer = sc.nextInt();
        sc.nextLine();

        Peripherique peripherique = peripheriqueRepository.findById(idPeripherique);
        Computer computer = computerRepository.findById(idComputer);

        peripherique.add(computer);

        peripheriqueRepository.save(peripherique);
    }

    private void showPeriphFromComputer (){
        System.out.println("afficher les peripherique d'un computer");
        System.out.println("id du Computer");
        int idComputer = sc.nextInt();
        sc.nextLine();

        Computer computer = computerRepository.findById(idComputer);

        if(computer != null){
            System.out.println(computer.getPeripheriques().toString());
        }else{

            System.out.println("aucun computer trouvé");
        }
    }


}
