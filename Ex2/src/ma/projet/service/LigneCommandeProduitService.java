package ma.projet.service;

import java.util.Date;
import ma.projet.dao.IDao;
import ma.projet.classes.LigneCommandeProduit;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import ma.projet.classes.Categorie;
import ma.projet.classes.LigneCommandeProduit;
import org.hibernate.HibernateException;
import org.hibernate.Query;

public class LigneCommandeProduitService implements IDao<LigneCommandeProduit> {

    @Override
    public boolean create(LigneCommandeProduit o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit(); 
            return true;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return false;
        }finally{
            if(session != null)
                session.close();
        }
    }

    
    public boolean delete(LigneCommandeProduit o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean update(LigneCommandeProduit o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<LigneCommandeProduit> getAll() {
        List <LigneCommandeProduit> lignecommandeproduits = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            lignecommandeproduits = session.createQuery("from LigneCommandeProduit ").list();
            tx.commit();
            return lignecommandeproduits;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return lignecommandeproduits;
        } finally {
            if(session != null)
                session.close();
        }
    }

    @Override
    public LigneCommandeProduit getById(int id) {
       LigneCommandeProduit lignecommandeproduit = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            lignecommandeproduit = (LigneCommandeProduit) session.get(LigneCommandeProduit.class, id);
            tx.commit();
            return lignecommandeproduit;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return lignecommandeproduit;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
}
