/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Cloud
 */
@Entity
//@NamedQuery(name = "Tache.findByPrixSuperieurA1000", query = "SELECT t FROM Tache t WHERE t.prix > 1000")

public class Tache {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private Date dateDebut;
    private Date dateFin;
    private double prix;
    
    @ManyToOne
    private Projet projets;
    
    @ManyToMany(mappedBy="taches")
    private List<Employe> employes;

    public Tache() {
    }

    public Tache(String nom, Date dateDebut, Date dateFin, double prix) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public double getPrix() {
        return prix;
    }

    public Projet getProjets() {
        return projets;
    }

    public List<Employe> getEmployes() {
        return employes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setProjets(Projet projets) {
        this.projets = projets;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

    public String getDateDebutReelle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getDateFinReelle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
