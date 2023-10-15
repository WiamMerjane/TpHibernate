package ma.projet.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import ma.projet.classes.Employe;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.service.EmployeService;
import ma.projet.service.EmployeTacheService;
import ma.projet.service.ProjetService;
import ma.projet.service.TacheService;

import ma.projet.util.HibernateUtil;
import org.hibernate.Hibernate;


public class Test {
    
   public static void main(String[] args) throws ParseException {
         SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateDebut = null;
        Date date1 = null;
         ProjetService ps = new ProjetService();
        EmployeService es = new EmployeService();
        TacheService ts = new TacheService();
        EmployeTacheService ets = new EmployeTacheService();
        HibernateUtil.getSessionFactory();
        
        try {
            dateDebut = dateFormat.parse("21/06/2023");
            date1 = dateFormat.parse("10/01/2023");
        } catch (ParseException e) {
            e.printStackTrace();
        }


        
//        Projet p1 = new Projet("projet 1", dateDebut, new Date());
//        Projet p2 = new Projet("projet 2", date1, new Date());
//        
//        Tache t1 = new Tache("tache 1", dateDebut, new Date(),2000);
//        Tache t2 = new Tache("tache 1", date1, dateDebut,2000);
//                
//        Employe e1 =new Employe("merjane","wiam","0700216683");
//        Employe e2 =new Employe("jalaoui","salma","03274987");
//
//        
//        ps.create(p1);
//        ps.create(p2);
//        
//        ts.create(t1);
//        ts.create(t2);
//        
//        es.create(e1);
//        es.create(e2);
        Tache t1=ts.getById(1);
        Tache t2=ts.getById(2);
      

        
        Employe e2=es.getById(2);
        e2.setTaches((List<Tache>) t1);
        
        
        es.getTachesRealiseesParEmploye(e2);
        List<Tache> tachesRealisees = es.getTachesRealiseesParEmploye(e2);
    
    // Affichez les détails de chaque tâche réalisée
    System.out.println("Tâches réalisées par l'employé " + e2.getNom() + ":");
    for (Tache tache : tachesRealisees) {
        System.out.println("Nom de la tâche : " + tache.getNom());
        System.out.println("Date de début : " + tache.getDateDebut());
        System.out.println("Date de fin : " + tache.getDateFin());
        System.out.println("Prix : " + tache.getPrix());
        System.out.println("Projet associé : " + tache.getProjets().getNom());
        System.out.println("-----------");
    }
        

        



        
    }
}