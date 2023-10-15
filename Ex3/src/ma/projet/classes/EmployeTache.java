/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Cloud
 */
@Entity
public class EmployeTache {
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private Date dateDebutReelle;
    private Date dateFinReelle;
    
    @ManyToOne
@JoinColumn(name = "employe_id")
private Employe employes;

@ManyToOne
@JoinColumn(name = "tache_id")
private Tache taches;

    public EmployeTache() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EmployeTache(Date dateDebutReelle, Date dateFinReelle) {
        this.dateDebutReelle = dateDebutReelle;
        this.dateFinReelle = dateFinReelle;
    }

    public Date getDateDebutReelle() {
        return dateDebutReelle;
    }

    public Date getDateFinReelle() {
        return dateFinReelle;
    }

    public void setDateDebutReelle(Date dateDebutReelle) {
        this.dateDebutReelle = dateDebutReelle;
    }

    public void setDateFinReelle(Date dateFinReelle) {
        this.dateFinReelle = dateFinReelle;
    }

    public void setEmployes(Employe employes) {
        this.employes = employes;
    }

    public void setTaches(Tache taches) {
        this.taches = taches;
    }

    public Employe getEmployes() {
        return employes;
    }

    public Tache getTaches() {
        return taches;
    }


    
}
