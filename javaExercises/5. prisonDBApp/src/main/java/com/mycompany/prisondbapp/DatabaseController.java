package com.mycompany.prisondbapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import entities.*;
import java.util.List;

public class DatabaseController {
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public enum OPERATION{
        ADD,
        UPDATE,
        REMOVE
    }
    
    public DatabaseController(){
        emf = Persistence.createEntityManagerFactory("prisonPU");
        em = emf.createEntityManager();
    }
    
    public List<Sektory> getAllSektory(){
        List<Sektory> sektory = em.createQuery("select b from Sektory b").getResultList();
        return sektory;
    }
    
    public void operationSektory(Object obj, OPERATION o){
        try {
                System.out.println(obj.toString());
                em.getTransaction().begin();
                switch (o){
                    case ADD:
                        em.persist(obj);
                        System.out.println("dodanie");
                        break;
                    case UPDATE:
                        em.merge(obj);
                        System.out.println("aktualizacja");
                        break;
                    case REMOVE: 
                        //https://stackoverflow.com/questions/16898085/jpa-hibernate-remove-entity-sometimes-not-working
                        System.out.println("usuwanie");
                        em.remove(em.merge(obj));
                        break;
                }
                em.getTransaction().commit();
        } 
        catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }
    
    public List<Cele> getAllCele(){
        List<Cele> cele = em.createQuery("select b from Cele b").getResultList();
        return cele;
    }
    
    public List<Cele> getCeleBySektor(String sektorId){
        List<Cele> cele = em.createQuery("select b from Cele b where idSektor='"+sektorId+"'").getResultList();
        return cele;
    }
    
    public boolean celaExists(int celaId){
        List<Cele> cele = em.createQuery("select b from Cele b where nr='"+celaId+"'").getResultList();
        if(cele.size()>0) return true;
        else return false;
    }
    
    public boolean sektorExists(String sektorId){
        List<Sektory> sektory = em.createQuery("select b from Sektory b where nazwa='"+sektorId+"'").getResultList();
        if(sektory.size()>0) return true;
        else return false;
    }
    
    public Sektory getSektorById(String sektorId){
        List<Sektory> sektory = em.createQuery("select b from Sektory b where nazwa='"+sektorId+"'").getResultList();
        if(sektory.size()>0) return sektory.get(0);
        else return null;        
    }
}
