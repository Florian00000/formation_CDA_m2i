package org.example.demos.demo3Heritage;

public abstract class Animal {
    private int age; // accessible uniquement via les getters et setters
    private static int nbAnimaux = 0;
    public Animal(int age) {
        nbAnimaux++;
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public static int getNbAnimaux() {
        return nbAnimaux;
    }

    public abstract void crier();

    @Override
    public String toString() {
        return "Animal { méthode du parent => " + super.toString() + "}";
    }
}
