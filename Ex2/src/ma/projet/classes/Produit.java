package ma.projet.classes;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;

@Entity
//@NamedNativeQuery(name="betweendate",query="",resultClass = )
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String reference;
    private float prix;
    @ManyToOne
    private Categorie categorie;
    
    @ManyToMany(mappedBy = "produits")
    private List<Commande> commandes ;
    
   

    public Produit() {
    }

    public Produit(String reference, float prix, Categorie categorie) {
        this.reference = reference;
        this.prix = prix;
        this.categorie = categorie;
    }

    public Produit(String reference, float prix) {
        this.reference = reference;
        this.prix = prix;
    }


 
    public int getId() {
        return id;
    }

    

  
    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    
    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

  
    public Categorie getCategorie() {
        return categorie;
    }

    
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
