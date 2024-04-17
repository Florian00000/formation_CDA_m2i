package org.example.demos.demo08Stream;

import org.example.demos.demo08Stream.model.Person;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("###########  Demo Java API Stream #############");

        List<String> names = Arrays.asList(
                "Luke",
                "Leia",
                "Han",
                "Anakin",
                "Anakin",
                "Obi-Wan",
                "Yoda",
                "Chewbacca",
                "R2-D2",
                "C-3PO",
                "Padmé"
        );

        System.out.println();
        System.out.println(" Filter : ");
        names.stream()
                .filter(p -> p.startsWith("A"))
                .forEach(System.out::println); // Utilisation de la méthode réference

        System.out.println();

        System.out.println("Count : ");
        System.out.println("Le nombre de personnage dont le prenom commence par 'A' : " + names.stream()
                .filter(p -> p.startsWith("A"))
                .count());

        System.out.println();

        System.out.println(" Distinct : ");
        names.stream()
                .distinct()
                .forEach(System.out::println);


        System.out.println();

        System.out.println(" Limit : ");
        names.stream().limit(4).forEach(System.out::println);

        System.out.println();

        System.out.println(" Sorted :");
        names.stream().sorted().forEach(System.out::println);

        System.out.println();

        System.out.println(" Sorted inverse : ");
        names.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);


        // Création d'une liste de Person
        List<Person> personList = Arrays.asList(
                new Person("Luke Skywalker", "Luke", 30),
                new Person("Leia Organa", "Leia", 28),
                new Person("Han Solo", "Han", 35),
                new Person("Darth Vader", "Anakin", 45),
                new Person("Obi-Wan Kenobi", "Obi-Wan", 60),
                new Person("Yoda", "Yoda", 900),
                new Person("Chewbacca", "Chewbacca", 200),
                new Person("R2-D2", "R2-D2", 40),
                new Person("C-3PO", "C-3PO", 50),
                new Person("Padmé Amidala", "Padmé", 25)
        );

        System.out.println();

        System.out.println("######## mapToDouble & sum() demo  #######");

        double totalAge = personList.stream()
                .mapToDouble(e -> e.getAge())
                .sum();

        System.out.println("Total age des personnages : " +totalAge);

        System.out.println();

        Optional<Person> person = personList.stream()
                .filter(p -> p.getAge() >= 40)
                .findFirst();

        if(person.isPresent()){
            System.out.println("Le premier personnage qui a au moins 40 ans : " + person.get());
        }else {
            System.out.println("Aucun personnage d'au moins cette age !!!");
        }

        System.out.println();

        System.out.println("#########  toMap ############");

        Map<UUID,String> personMap = personList.stream()
                .collect(Collectors.toMap(p -> UUID.randomUUID(),Person::getNom));
        System.out.println(personMap);

        System.out.println(" Demo : filter, map, collect");
        System.out.println("Nouvelle collection");

        List<Person> listModifie = personList.stream()
                .filter(p -> p.getAge() > 35)
                .map(p -> {
                    p.setAge(p.getAge() - 20);
                    return  p;
                })
                .toList();
               // .collect(Collectors.toList());

        listModifie.stream().forEach(System.out::println);

        System.out.println();

        System.out.println("Nouveau tableau");

        Person[] people = personList.stream()
                .filter(p -> p.getAge() > 40)
                .map(p -> {
                    p.setAge(p.getAge() -20);
                    return p;
                })
                .toArray(Person[]::new);

        Arrays.stream(people).forEach(System.out::println);


        System.out.println();
        personList.stream().forEach(System.out::println);

    }
}
