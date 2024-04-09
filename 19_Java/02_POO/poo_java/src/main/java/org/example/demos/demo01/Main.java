package org.example.demos.demo01;

public class Main {
    public static void main(String[] args) {
        UneClasse unObjet = new UneClasse();
        System.out.println(unObjet);

        System.out.println("---------------------------");

        // Instanciation, appel aux constructeurs pour créer de nouveaux chats
        Chat chat1 = new Chat(5, "Angora");
        Chat chat2 = new Chat(12, "Chat de gouttière");
        Chat chat3 = new Chat();

        System.out.println("---------------------------");

        // affichage
        System.out.println(chat1); // appelle la méthode toString implicitement
        System.out.println(chat2);
        System.out.println(chat3.toString()); // pareil que les lignes précédentes

        System.out.println("---------------------------");

        System.out.println(chat1.getNom());
        System.out.println(chat2.getNom());
        System.out.println(chat2.getAge());
        System.out.println(chat2.getRace());

        chat1.miauler();

        System.out.println("---------------------------");

        chat2.setRace("Persan");

        System.out.println("chat2 après changement de race " + chat2.getRace());

    }
}