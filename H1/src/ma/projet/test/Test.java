package ma.projet.test;

import java.util.Date;
import ma.projet.dao.IDao;
import ma.projet.entity.Produit;
import ma.projet.service.ProduitService;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        // Créez un service Produit
        IDao<Produit> produitService = new ProduitService();

        // Créez cinq produits
//        Produit produit1 = new Produit("Marque 1", "Ref 1",new Date(),150.0, "Produit 1");
//        Produit produit2 = new Produit("Marque 2", "Ref 2",new Date(), 200.0, "Produit 2");
//        Produit produit3 = new Produit("Marque 3", "Ref 3",new Date(),100.0, "Produit 3");
//        Produit produit4 = new Produit("Marque 4", "Ref 4",new Date(), 300.0, "Produit 4");
//        Produit produit5 = new Produit("Marque 5", "Ref 5",new Date(),350.0, "Produit 5");
        

//        // Ajoutez les produits
//        produitService.create(produit1);
//        produitService.create(produit2);
//        produitService.create(produit3);
//        produitService.create(produit4);
//        produitService.create(produit5);
        
        

        // Affichez la liste des produits
        System.out.println("Liste des produits :");
        List<Produit> produits = produitService.findAll(null);
        produits.forEach(System.out::println);
        
         
        
//
//        // Affichez les informations du produit avec l'ID 2
//        Produit produitId2 = produitService.findById(2);
//        if (produitId2 != null) {
//            System.out.println("\nInformations du produit avec ID 2 :");
//            System.out.println(produitId2);
//        } else {
//            System.out.println("\nAucun produit trouvé avec ID 2.");
//        }

//        // Supprimez le produit avec l'ID 3
//        Produit produitId3 = produitService.findById(3);
//        if (produitId3 != null) {
//            produitService.delete(produitId3);
//            System.out.println("\nProduit avec ID 3 supprimé.");
//        } else {
//            System.out.println("\nAucun produit trouvé avec ID 3.");
//        }

//        // Mettez à jour les informations du produit avec l'ID 1
        Produit produitId1 = produitService.findById(1);
        if (produitId1 != null) {
            produitId1.setPrix(50);
            produitService.update(produitId1);
            System.out.println("\nInformations du produit avec ID 1 mises à jour.");
        } else {
            System.out.println("\nAucun produit trouvé avec ID 1.");
        }
//
//        // Affichez la liste des produits dont le prix est supérieur à 100 DH
        System.out.println("\nListe des produits avec un prix supérieur à 100 DH :");
        produits = produitService.findAll(null);
        produits.stream()
                .filter(produit -> produit.getPrix() > 100.0)
                .forEach(System.out::println);
    }
}
