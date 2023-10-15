package ma.projet.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private String libelle;
    
    @OneToMany(mappedBy = "categorie",fetch = FetchType.EAGER)
    private List<Produit> produit;

    public Categorie() {
    }

    public Categorie(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    

   
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

   
    public void setCode(String code) {
        this.code = code;
    }

    
    public String getLibelle() {
        return libelle;
    }

    
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    
    public List<Produit> getProduit() {
        return produit;
    }

   
    public void setProduit(List<Produit> produit) {
        this.produit = produit;
    }
    
    
    
}
