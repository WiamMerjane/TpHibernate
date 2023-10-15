package ma.projet.classes;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class Commande {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
    
    @ManyToMany
    @JoinTable(
     name = "LigneCommandeProduit",
        joinColumns = @JoinColumn(name = "commande_id"),
        inverseJoinColumns = @JoinColumn(name = "produit_id")
    )
    private List<Produit> produits;
    
    @OneToMany(mappedBy = "commande")
    private List<LigneCommandeProduit> lignesCommandeProduits;

    public Commande() {
    }

    public Commande(Date date) {
        this.date = date;
    }

    
    public int getId() {
        return id;
    }

  
    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    
    public void setDate(Date date) {
        this.date = date;
    }

    
    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public List<LigneCommandeProduit> getLignesCommandeProduits() {
        return lignesCommandeProduits;
    }

    public void setLignesCommandeProduits(List<LigneCommandeProduit> lignesCommandeProduits) {
        this.lignesCommandeProduits = lignesCommandeProduits;
    }
    
    
    
}
