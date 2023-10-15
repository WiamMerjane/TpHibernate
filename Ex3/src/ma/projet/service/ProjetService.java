/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.List;
import ma.projet.classes.Projet;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Cloud
 */
public class ProjetService implements IDao<Projet> {

    @Override
    public boolean create(Projet projet) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(projet);
            tx.commit();
            return true;
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
            ex.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public Projet getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return (Projet) session.get(Projet.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Projet> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.createQuery("FROM Projet").list();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
     public List<Tache> getTachesPlanifieesPourProjet(Projet projet) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "SELECT t FROM Tache t WHERE t.projet = :projet AND t.statut = 'Planifiee'";
            Query query = session.createQuery(hql);
            query.setParameter("projet", projet);
            return query.list();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
     
      public void afficherTachesRealiseesDansProjet(Projet projet) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "SELECT t FROM Tache t WHERE t.projet = :projet AND t.statut = 'Realisee'";
            Query query = session.createQuery(hql);
            query.setParameter("projet", projet);
            List<Tache> tachesRealisees = query.list();

            // Afficher les détails des tâches réalisées
            System.out.println("Projet : " + projet.getId() + " Nom : " + projet.getNom() + " Date début : " + projet.getDateDebut());
            System.out.println("Liste des tâches réalisées:");
            System.out.println("Num\tNom\tDate Début Réelle\tDate Fin Réelle");
            for (Tache tache : tachesRealisees) {
                System.out.println(tache.getId() + "\t" + tache.getNom() + "\t" + tache.getDateDebutReelle() + "\t" + tache.getDateFinReelle());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

}
