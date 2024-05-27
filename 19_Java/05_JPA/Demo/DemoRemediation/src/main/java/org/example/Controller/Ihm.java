package org.example.Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Ihm {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Demo_Jpa");
    private EntityManager em = emf.createEntityManager();
    private Scanner sc ;

    private AgencyIhm agencyIhm;
    private AccountIhm accountIhm;
    private CustomerIhm customerIhm;


    public Ihm() {
        sc = new Scanner(System.in);
        accountIhm = new AccountIhm(em,sc);
        agencyIhm= new AgencyIhm(em,sc);
        customerIhm = new CustomerIhm(em,sc);

    }

    public void start (){
        int entry ;
        while (true){
            System.out.println("--- Product Application ---");
            System.out.println("1/ Account");
            System.out.println("2/ Agency");
            System.out.println("3/ Customer");
            entry = sc.nextInt();
            sc.nextLine();

            switch (entry){
                case 1:
                    accountIhm.start();
                    break;
                case 2 :
                    agencyIhm.start();
                    break;
                case 3:
                    customerIhm.start();
                    break;
                default:
                    return;
            }
        }

    }
}
