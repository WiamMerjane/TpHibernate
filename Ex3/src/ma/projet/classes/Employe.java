/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Cloud
 */
@Entity
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String telephone;
    
   @OneToMany(mappedBy = "employes")
   private List<Projet> projets;
   
   @ManyToMany
    @JoinTable(
     name = "EmployeTache",
        joinColumns = @JoinColumn(name = "employe_id"),
        inverseJoinColumns = @JoinColumn(name = "tache_id")
    )
private List<Tache> taches;


    public Employe() {
    }

    public Employe(String nom, String prenom, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }

    public void setTaches(List<Tache> taches) {
        this.taches = taches;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public List<Projet> getProjets() {
        return projets;
    }

    public List<Tache> getTaches() {
        return taches;
    }

    
    

    
}
