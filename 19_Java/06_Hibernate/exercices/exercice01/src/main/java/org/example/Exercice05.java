package org.example;

import org.example.entities.Commentaire;
import org.example.entities.Image;
import org.example.entities.Produit;
import org.example.service.CommentaireService;
import org.example.service.ImageService;
import org.example.service.ProduitService;

import java.util.Date;
import java.util.List;

public class Exercice05 {
    public static void main(String[] args) {
        ProduitService ps = new ProduitService();
 //       Produit produit1 = ps.findById(1);
//        Produit produit2 = ps.findById(2);
//        Produit produit3 = ps.findById(3);

 //       System.out.println(produit1);

        List<Produit> produits = ps.filterByAverageScore(4);
        for (Produit p : produits) {
            System.out.println(p);
        }
        ps.close();


//        ImageService imageService = new ImageService();
//        Image image1 = Image.builder().url("test.url").produit(produit1).build();
//        imageService.create(image1);
//        imageService.close();

//        CommentaireService commentaireService = new CommentaireService();
        /*
        Commentaire commentaire1 = Commentaire.builder()
                .contenu("La vrai carbo n'a pas de crème fraiche!!! Je sais mieux que tout le monde, et c'est très important ce que je dis, écoutez moi!!")
                .date(new Date())
                .note(1)
                .produit(produit1)
                .build();
        commentaireService.create(commentaire1);
        Commentaire commentaire2 = Commentaire.builder()
                .contenu("bla bla bla bla bla bla bla bla")
                .date(new Date())
                .note(5)
                .produit(produit2)
                .build();
        Commentaire commentaire3 = Commentaire.builder()
                .contenu("bla bla bla bla bla bla bla bla")
                .date(new Date())6
                .note(5)
                .produit(produit2)
                .build();
        Commentaire commentaire4 = Commentaire.builder()
                .contenu("bla bla bla bla bla bla bla bla")
                .date(new Date())
                .note(4)
                .produit(produit3)
                .build();

        commentaireService.create(commentaire2);
        commentaireService.create(commentaire3);
        commentaireService.create(commentaire4);

         */

//        commentaireService.close();
    }
}
