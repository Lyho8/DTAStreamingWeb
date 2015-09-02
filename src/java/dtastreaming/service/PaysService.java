/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.service;

import dtastreaming.entity.*;
import java.util.*;
import javax.persistence.*;

/**
 *
 * @author ETY
 */
public class PaysService {
    
    public void ajouter(Pays p){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        em.getTransaction().begin();
        
        em.persist(p);
        
        em.getTransaction().commit();
    }
    
    public void modifier(Pays p){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        em.getTransaction().begin();
        
        em.merge(p);
        
        em.getTransaction().commit();
    }
    
    public void supprimer(String id){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        em.getTransaction().begin();
        
        em.createQuery("DELETE FROM Pays p WHERE p.id=:idPays").setParameter("idPays", id).executeUpdate();
        
        em.getTransaction().commit();
    }
    
    public Pays rechercher(String id){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        return em.find(Pays.class, id);
    }
    
    public Collection<Pays> lister(){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        return em.createQuery("SELECT p FROM Pays p ORDER BY p.id").getResultList();
    }
    
}
