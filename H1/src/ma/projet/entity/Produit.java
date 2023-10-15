package ma.projet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "produits")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "marque")
    private String marque;

    @Column(name = "ref")
    private String ref;

    @Column(name = "date_achat")
    private Date dateAchat;

    @Column(name = "prix")
    private double prix;

    @Column(name = "designation")
    private String designation;

    public Produit() {
    }

    public Produit(String marque, String ref, Date dateAchat, double prix, String designation) {
        this.marque = marque;
        this.ref = ref;
        this.dateAchat = dateAchat;
        this.prix = prix;
        this.designation = designation;
    }

    public int getId() {
        return id;
    }

    public String getMarque() {
        return marque;
    }

    public String getRef() {
        return ref;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public double getPrix() {
        return prix;
    }

    public String getDesignation() {
        return designation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
