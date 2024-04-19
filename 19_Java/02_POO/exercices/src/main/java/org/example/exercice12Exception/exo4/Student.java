package org.example.exercice12Exception.exo4;

public class Student {
    private String name;
    private int age;

    public Student(String name, int age) throws InvalidAgeException {
        if (age < 0){
            throw new InvalidAgeException("L'age ne peut pas être négatif.");
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student: " +
                "name = '" + name + '\'' +
                ", age = " + age +
                '.';
    }
}
