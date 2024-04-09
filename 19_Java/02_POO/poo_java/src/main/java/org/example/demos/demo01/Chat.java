package org.example.demos.demo01;

public class Chat {
    // Attributs
    private String nom = "Titouan"; // attribut avec valeur par défaut
    private int age;
    private String race;

    // Constructeur polymorphique (2 formes)
    public Chat(){ // permet de créer un chat sans paramêtres (chat par défaut)
//        age = 0;
//        race = "Maine Coon";
        this(0, "Maine Coon"); // appel à l'autre constructeur (réutilisation)
        this.miauler();
    }
    public Chat(int age, String r){
        this.age = age;
        race = r; // équivaut à : this.race = r;
    }

    // Méthodes
    public void miauler(){
        System.out.println("Le chat " + this.nom + " Miaule !");
    }

    // le getter + setter permettent de protéger les attributs privés de la classe
    // c'est la notion d'Encapsulation
    public String getNom() { // accesseur/getter de Nom
        return nom;
    }

    public void setNom(String nom) { // mutateur/setter de Nom
        this.nom = nom;
    }

    public int getAge(){
        return this.age;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

//    public String toString(){
//        return "Chat: nom=" + this.nom + ", age=" + this.age + ", race=" + this.race;
//    }
    // Méthode appelée lorsque l'on essaie d'afficher ou de concaténer un chat
    // par défaut, toString affiche ce genre de résultat :
    // org.example.demos.demo01.Chat@65ab7765
}
