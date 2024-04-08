package org.example;

public class Fonctions {

//   signature fonction: <visibilité> <mot-clés poo> <typre de retour> <identificateur/symbole de la fonction>(<paramètres et leurs types>){
    public static int add(int int1 , int int2){
//        var result = int1 + int2;
//        return result;
        return int1 + int2; //instruction de sortie de sortie/retour
    }

    //La fonction à le même nom, mais pas la même signature (polymorphisme)
    public static int add(int int1 , int int2, int int3){
        return int1 + int2 + int3;
    }

    // polymorphisme paramétrique
    public static double add(double int1 , double int2, double int3){
        return int1 + int2 + int3;
    }

    public  static int sum(int[] ints){
        var somme = 0;
        for (int i = 0; i < ints.length; i++) {
            somme += ints[i];
        }
        return (int) somme;
    }

    public  static int sum2(int ...ints){ //Ici on accepte autant de paramètres du même type que nécessaire
        var somme = 0;
        for (var items : ints){
            somme += items;
        }
        return (int) somme;
    }

    public static void addPrint(int int1 , int int2){ // void => aucun type de retour, impossible de récupérer un résultat à l'exécution (!=null, 0, "", '\0')
        System.out.println( "Résultat de l'addition" + (int1 + int2));
    }

    public static void infinie(){
        infinie(); //Stack Overflow!!
    }

    public static void main(String[] args) {

        var result = add(1, 2);
        System.out.println(result);

        addPrint(2 ,3);
        System.out.println(sum2(1, 2 ,3, 4));
    }

}
