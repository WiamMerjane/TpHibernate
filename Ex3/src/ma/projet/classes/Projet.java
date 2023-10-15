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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Cloud
 */
@Entity
public class Projet {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private Date dateDebut;
    private Date dateFin;
    
    @ManyToOne
    private Employe employes;
    
    @OneToMany(mappedBy = "projets")
    private List<Tache> taches;

    public Employe getEmploye() {
        return employes;
    }

    public void setEmploye(Employe employes) {
        this.employes = employes;
    }

    public void setTache(List<Tache> taches) {
        this.taches = taches;
    }

    public List<Tache> getTache() {
        return taches;
    }

    public Projet(String nom, Date dateDebut, Date dateFin) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Projet() {
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
    
    

    
    
}
