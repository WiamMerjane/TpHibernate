package ma.projet.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LigneCommandeProduit {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private int quantity;
    
    @ManyToOne
    @JoinColumn(name ="produit_id")
    private Produit produit;
    
    @ManyToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;

    public LigneCommandeProduit() {
    }

    public LigneCommandeProduit(int quantity) {
        this.quantity = quantity;
    }

    public LigneCommandeProduit(int quantity, Produit produit, Commande commande) {
        this.quantity = quantity;
        this.produit = produit;
        this.commande = commande;
    }

    @Override
    public String toString() {
        return "LigneCommandeProduit{" + "id=" + id + ", quantity=" + quantity + ", produit=" + produit + ", commande=" + commande + '}';
    }

    public int getId() {
        return id;
    }

   
    public void setId(int id) {
        this.id = id;
    }

   
    public int getQuantity() {
        return quantity;
    }

    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

  
    public Produit getProduit() {
        return produit;
    }

    /**
     * @param produit the produit to set
     */
    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    /**
     * @return the commande
     */
    public Commande getCommande() {
        return commande;
    }

    /**
     * @param commande the commande to set
     */
    public void setCommande(Commande commande) {
        this.commande = commande;
    }
    
    
}
