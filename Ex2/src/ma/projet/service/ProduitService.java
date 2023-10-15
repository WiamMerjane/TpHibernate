package ma.projet.service;

import java.util.Date;
import ma.projet.dao.IDao;
import ma.projet.classes.Produit;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import ma.projet.classes.Categorie;
import ma.projet.classes.Commande;
import org.hibernate.HibernateException;
import org.hibernate.Query;

public class ProduitService implements IDao<Produit> {

    @Override
    public boolean create(Produit o) {
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

    public boolean delete(Produit o) {
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

    public boolean update(Produit o) {
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
    public List<Produit> getAll() {
        List <Produit> produits = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produits = session.createQuery("from Produit ").list();
            tx.commit();
            return produits;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return produits;
        } finally {
            if(session != null)
                session.close();
        }
    }

    @Override
    public Produit getById(int id) {
       Produit produit = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produit = (Produit) session.get(Produit.class, id);
            tx.commit();
            return produit;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return produit;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    public List<Produit> getProduitsByCategorie(Categorie o) {
        List <Produit> produits = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produits = session.createQuery("from Produit where categorie= :categorie ").setParameter("categorie", o).list();
            tx.commit();
            return produits;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return produits;
        } finally {
            if(session != null)
                session.close();
        }
    }
    
  

   
}
