package ma.projet.test;

import java.util.Date;
import java.util.List;
import ma.projet.classes.Categorie;
import ma.projet.classes.Commande;
import ma.projet.classes.LigneCommandeProduit;

import ma.projet.classes.Produit;
import ma.projet.service.CategorieService;
import ma.projet.service.CommandeService;
import ma.projet.service.LigneCommandeProduitService;

import ma.projet.service.ProduitService;
import ma.projet.util.HibernateUtil;
import org.hibernate.Hibernate;


public class Test {
    
   public static void main(String[] args) {
        
         ProduitService ps = new ProduitService();
        CategorieService cs = new CategorieService();
        CommandeService cms = new CommandeService();
        LigneCommandeProduitService ls = new LigneCommandeProduitService();
                    HibernateUtil.getSessionFactory();


//        Categorie c1 = new Categorie("J2346", "MMMM");
//        cs.create(c1);

        
        
//        Produit produit1 = new Produit("J567889", 2000, nouvelleCategorie);
//        Produit produit2 = new Produit("PROD002", 30000, nouvelleCategorie);

//         Categorie c2 = new Categorie("c1", "l1");
//        cs.create(c2);
//        
//        Produit produit3 = new Produit("ref3", 200, c2);
//        Produit produit4 = new Produit("ref4", 300, c2);
//        ps.create(produit3);
//        ps.create(produit4);
        
          //Categorie c0 = cs.getById(3);
          Categorie c1 = cs.getById(4);
          
           Produit p0 = ps.getById(1);
        Produit p1 = ps.getById(2);
        Produit p2 = ps.getById(5);
        Produit p3 = ps.getById(6);
        
        Commande cmd1=cms.getById(1);
        Commande cmd2=cms.getById(2);
        

        
        
        ls.create(new LigneCommandeProduit(789, p1, cmd1));
        ls.create(new LigneCommandeProduit(678, p2, cmd2));
        
        
        


        
        
        
        List<Produit> produitsDeLaCategorie = ps.getProduitsByCategorie(c1);
        
        if (produitsDeLaCategorie != null) {
            System.out.println("Liste des produits de la catégorie : " + c1.getCode());
            for (Produit produit : produitsDeLaCategorie) {
                System.out.println("Référence : " + produit.getReference());
                System.out.println("Prix : " + produit.getPrix() + " DH");
                System.out.println("----------------------------------------");
            }
        } else {
            System.out.println("Une erreur s'est produite lors de la récupération des produits.");
        }
        
               
         cms.getproduitCommandes(2);

        

        
    }
}