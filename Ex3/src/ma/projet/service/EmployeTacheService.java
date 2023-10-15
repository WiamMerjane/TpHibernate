/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.List;
import ma.projet.classes.EmployeTache;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Cloud
 */
public class EmployeTacheService implements IDao<EmployeTache> {

    @Override
    public boolean create(EmployeTache employeTache) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(employeTache);
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
    public EmployeTache getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return (EmployeTache) session.get(EmployeTache.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<EmployeTache> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.createQuery("FROM EmployeTache").list();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
