package org.example.demos.demo3Heritage;


public class Main {
    public static void main(String[] args) {
//        Chat chat1 = new Chat("Garfield",5, "Angora");
//        Chat chat2 = new Chat("Titouan", 12, "Chat de gouttière");
//        Chat chat3 = new Chat();
//
//        System.out.println("---------------------------");

//        Animal an = new Animal(5);

//        System.out.println(an);

        Animal chat1 = new Chat();
        chat1.crier();
//        chat.miauler(); // impossible
        chat1.getAge();
//        chat.getRace(); // impossible
//        chat.getNom(); // impossible

        System.out.println("_________________________");

        Felin chat2 = new Chat();
        chat2.crier();
//        chat2.miauler(); // impossible
        chat2.getAge();
//        chat2.getRace(); // impossible
        chat2.getNom();

        System.out.println("_________________________");

        Chat chat3 = new Chat();
        chat3.crier();
        chat3.miauler();
        chat3.getAge();
        chat3.getRace();
        chat3.getNom();

        System.out.println("_________________________");

        Felin[] felinanimalerie = {
                new Chat(),
                new Chat(),
                new Chat("Garfield", 12, "Angora"),
                new Tigre("Tigrou", 15),
                new Tigre("Tigrette", 15),
        };

        for(var fel : felinanimalerie){ // felin
//        for(Felin fel : felinanimalerie){
//        for(Animal fel : felinanimalerie){ // conversion
            System.out.println(fel.getNom());
            fel.crier();
        }

        System.out.println("_________________________");

        Animal[] animalerie = {
                new Chat(),
                new Chat(),
                new Chat("Garfield", 12, "Angora"),
                new Tigre("Tigrou", 15),
                new Tigre("Tigrette", 15),
        };

        for(var an : animalerie){ // Animal
//        for(Felin an : animalerie){ // NE FONCTIONNE PAS CAR UN ANIMAL N'EST PAS FORCEMENT UN FELIN
//        for(Animal an : animalerie){ // Animal
            an.crier();
        }

        System.out.println("_________________________");

        for(Animal an : animalerie) {
            if(an instanceof Chat){
                System.out.println("C'est un Chat !");
                // an.miauler(); // an est de type animal !!!
                Chat varChat = (Chat) an;
                varChat.miauler();
            }
            else{
                System.out.println("Ce n'est pas un Chat !");
            }

            if(an instanceof Chat varChat){
                varChat.miauler();
            }

//            Chat varChat = (Chat) an; // erreur avec les Tigres !!!

            if(an instanceof Object){
                System.out.println("C'est un Objet !");
            }

            var bool = an instanceof Chat varChat;
//            an instanceof Chat varChat; // impossible
        }
    }
}