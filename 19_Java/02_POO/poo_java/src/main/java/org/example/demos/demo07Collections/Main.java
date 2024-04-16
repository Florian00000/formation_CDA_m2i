package org.example.demos.demo07Collections;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Démo pour vector
        Vector<String> vector = new Vector<>();
      //  List<String> vector2 = new Vector<>();
        vector.add("Apple");
        vector.add("Banana");
        vector.add("Orange");
        System.out.println("Vector : " + vector);

        // Méthode pour vector
        System.out.println("1. Taille du vector : "+ vector.size());
        System.out.println("2. Element à l'index 1 : "+ vector.get(1));
        System.out.println("3. Est ce que 'Apple' est présent ? "+ vector.contains("Apple"));

        // Démo pour SortedSet (TreeSet)
        SortedSet<String> sortedSet = new TreeSet<>();
        sortedSet.add("Java");
        sortedSet.add("Python");
        sortedSet.add("Python3");
        sortedSet.add("C++");
        System.out.println("\nSortedSet : "+ sortedSet);

        // Méthodes pour SortedSet
        System.out.println("1. Premier element : "+ sortedSet.first());
        System.out.println("2. Dernier element : "+ sortedSet.last());
        SortedSet<String> headset = sortedSet.headSet("Python");
        System.out.println("3. Sous-ensemble avant 'Python' : "+headset);

        // Démo pour le LinkedList
        LinkedList<Double> linkedList = new LinkedList<>();
        linkedList.add(3.14);
        linkedList.add(2.71);
        linkedList.add(1.618);
        System.out.println("\nlinkedlist : "+ linkedList);

        //  Méthode pour linkedlist
        System.out.println("1. Premier element : "+ linkedList.getFirst());
        System.out.println("2. Dernier element : "+ linkedList.getLast());
        linkedList.removeFirst();
        System.out.println("3. Suppression du premier element : "+linkedList);

        // Collections avec systeme clé / valeur

        // Demo pour TreeMap
        SortedMap<String,Integer> sortedMap = new TreeMap<>();
        sortedMap.put("Java",20);
        sortedMap.put("Python",10);
        sortedMap.put("C++",30);
        System.out.println("\nSortedMap : "+ sortedMap);

        // Méthode pour le sortedMap
        System.out.println("1. Clés de mon sortedMap : " + sortedMap.keySet());
        System.out.println("2. Valeurs de mon sortedMap : " +sortedMap.values());
        System.out.println("3. Supprimer l'entree avec la clé 'Python' :");
        sortedMap.remove("Python");
        System.out.println(" Nouvelle SortedMap : "+ sortedMap);

        // Démo pour le HashMap
        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put("Java",20);
        hashMap.put("Python",10);
        hashMap.put("C++",30);
        System.out.println("\nHashMap : "+ hashMap);

        // Méthodes pour hashmap

        System.out.println("1. Taille du Hashmap : " + hashMap.size());
        System.out.println("2. Valeur associé à 'Java' : " + hashMap.get("Java"));
        System.out.println("3. Est ce que 'Test' est présent ? : " + hashMap.containsKey("Test"));
        System.out.println("4. Suppression de l'entréé avec la clé Python : ");
        hashMap.remove("Python");
        System.out.println(" Nouveau HashMap : "+ hashMap);



    }
}
