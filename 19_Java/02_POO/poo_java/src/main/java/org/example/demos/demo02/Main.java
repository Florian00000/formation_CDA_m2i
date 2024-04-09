package org.example.demos.demo02;


public class Main {
    public static void main(String[] args) {

        // Instanciation, appel aux constructeurs pour créer de nouveaux chats
        Chat chat1 = new Chat("Garfield",5, "Angora");
        Chat chat2 = new Chat("Titouan", 12, "Chat de gouttière");
        Chat chat3 = new Chat();

        System.out.println("---------------------------");

        System.out.println("espece : " + Chat.getEspece());
    }
}