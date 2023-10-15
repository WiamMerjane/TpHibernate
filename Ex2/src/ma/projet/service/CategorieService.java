package ma.projet.service;

import java.util.Date;
import ma.projet.dao.IDao;
import ma.projet.classes.Categorie;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import ma.projet.classes.Categorie;
import ma.projet.classes.Categorie;
import org.hibernate.HibernateException;
import org.hibernate.Query;

public class CategorieService implements IDao<Categorie> {

    public boolean create(Categorie o) {
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

    public boolean delete(Categorie o) {
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

    public boolean update(Categorie o) {
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
    public List<Categorie> getAll() {
        List <Categorie> categories = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            categories = session.createQuery("from Categorie ").list();
            tx.commit();
            return categories;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return categories;
        } finally {
            if(session != null)
                session.close();
        }
    }

    @Override
    public Categorie getById(int id) {
       Categorie categorie = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            categorie = (Categorie) session.get(Categorie.class, id);
            tx.commit();
            return categorie;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return categorie;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void setCategorie(Categorie c1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Categorie findById(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
}
