/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.List;
import ma.projet.classes.Tache;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Cloud
 */
public class TacheService implements IDao<Tache> {

    @Override
    public boolean create(Tache tache) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(tache);
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
    public Tache getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return (Tache) session.get(Tache.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Tache> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.createQuery("FROM Tache").list();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    
//    public void getprojetTaches(int id) {
//        
//        Tache c = this.getById(id);
//        System.out.print("Tache : "+ c.getId() +"         " +"Nom:"+c.getNom()+"        "+ "Date : "+ c.getDateDebut()+'\n');
//        System.out.print("Listes des taches :\n");
//        System.out.printf("%-10s %-10s %-10s %-10s\n", "Num", "Nom", "Date Debut Reelle"+"Date Fin Reelle");
//                for (Tache tache : tachesRealisees) {
//            System.out.println(tache.toString());
//        }
//
//        
//    }
}
