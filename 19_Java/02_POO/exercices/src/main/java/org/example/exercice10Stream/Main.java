package org.example.exercice10Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 400),
                new Transaction(brian, 2012, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 410),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));

        System.out.println("Question 1");
        List<Transaction> listQuestion1 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .toList();
        listQuestion1.forEach(System.out::println);

        System.out.println("Question 2");
        List<String> listQuestion2 = Arrays.asList(raoul, mario, alan, brian).stream()
                .map(Trader::getCity)
                .distinct()
                .toList();
        listQuestion2.forEach(System.out::println);

        System.out.println("Question 3");
        String question3 = transactions.stream()
                .map(t -> t.getTrader().getName())
                .sorted()
                .distinct()
                .collect(Collectors.joining(", "));

        System.out.println(question3);

        System.out.println("Question 4");
        Optional<Trader> question4 = Arrays.asList(raoul, mario, alan, brian).stream()
                .filter(t -> t.getCity().equals("Milan"))
                .findAny();

        System.out.println(question4.isPresent());

        System.out.println("Question 5");
        Optional<Integer> question5 = transactions.stream()
                .max(Comparator.comparingInt(t-> t.getValue()))
                .map(Transaction::getValue);

        if (question5.isPresent()) {
            System.out.println(question5.get());
        }

        System.out.println("Question 6 ");
        List<Trader> question6 =  Arrays.asList(raoul, mario, alan, brian).stream()
                .filter(t -> t.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .toList();
        question6.forEach(System.out::println);

        System.out.println("Question 7");
        List<Integer> question7 = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(t -> t.getValue())
                .toList();

        question7.forEach(System.out::println);

        System.out.println("Question 8");
        Optional<Transaction> question8 = transactions.stream()
                .min(Comparator.comparingInt(t -> t.getValue()));


        if (question8.isPresent()){
            System.out.println(question8.get());
        }
    }


}
