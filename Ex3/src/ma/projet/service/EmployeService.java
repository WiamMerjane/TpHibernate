/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.Date;
import java.util.List;
import ma.projet.classes.Employe;
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
public class EmployeService implements IDao<Employe> {

    @Override
    public boolean create(Employe employe) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(employe);
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
    public Employe getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return (Employe) session.get(Employe.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Employe> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.createQuery("FROM Employe").list();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    public List<Tache> getTachesRealiseesParEmploye(Employe employe) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    try {
        String hql = "SELECT t FROM Tache t WHERE :employe MEMBER OF t.employes AND t.dateFin < :currentDate";
        Query query = session.createQuery(hql);
        query.setParameter("employe", employe);
        query.setParameter("currentDate", new Date()); // Définissez la valeur de currentDate
        return query.list();
    } catch (Exception ex) {
        ex.printStackTrace();
        return null;
    } finally {
        session.close();
    }
    
    
}


    // Méthode pour afficher la liste des projets gérés par un employé
    public List<Projet> getProjetsGeresParEmploye(Employe employe) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "SELECT p FROM Projet p WHERE p.gestionnaire = :employe";
            Query query = session.createQuery(hql);
            query.setParameter("employe", employe);
            return query.list();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public void update(Employe employe) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    try {
        transaction = session.beginTransaction();
        session.update(employe);
        transaction.commit();
    } catch (Exception ex) {
        if (transaction != null) {
            transaction.rollback();
        }
        ex.printStackTrace();
    } finally {
        session.close();
    }
}

}
