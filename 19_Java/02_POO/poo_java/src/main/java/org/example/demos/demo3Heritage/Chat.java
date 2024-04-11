package org.example.demos.demo3Heritage;

public class Chat extends Felin{
    private String race; // ici seuls les chats auront une Race

    private static int nbChats = 0;

    public Chat(){
        this("Chat par défaut", 5, "Tigre");
        // nbChats++; // /!\ celà augmentera 2 fois le compteur
    }

    public Chat(String nom, int age, String race) {
        super(nom, age);
        // this.nom = nom; // accessible car protected
        //super.setAge(age); // celui du félin
        // this.setAge(age); // celui du chat si on le redéfinit
        this.race = race;
        nbChats++;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    @Override
    public void crier() {
        super.crier();
        this.miauler();
    }

    public void miauler(){
        System.out.println("Le chat " + this.nom + " Miaule !");
    }

    @Override
    public String toString() {
        return "Chat{" +
                "nom='" + nom + '\'' +
                ", age=" + super.getAge() + //via le getter car age est private dans animal
                ", race='" + race + '\'' +
                '}';
    }
}
