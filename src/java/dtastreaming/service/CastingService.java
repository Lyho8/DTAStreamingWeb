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
public class CastingService {
    
    public void ajouter(Casting c){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        em.getTransaction().begin();
        
        em.persist(c);
        
        em.getTransaction().commit();
    }
    
    public void modifier(Casting c){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        em.getTransaction().begin();
        
        em.merge(c);
        
        em.getTransaction().commit();
    }
    
    public void supprimer(long id){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        em.getTransaction().begin();

        em.createQuery("DELETE FROM Casting c WHERE c.id=:idCasting").setParameter("idCasting", id).executeUpdate();
        
        em.getTransaction().commit();
    }
    
    public Casting rechercher(long id){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        return em.find(Casting.class, id);
    }
    
    public Casting rechercher(String nom){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        try{
            return (Casting) em.createQuery("SELECT c FROM Casting c WHERE c.nom=:nom").setParameter("nom", nom).getSingleResult();
        }catch(Exception e){
            return null;
        }
    }
    
    public Collection<Casting> lister(){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        return em.createQuery("SELECT c FROM Casting c ORDER BY c.nom").getResultList();
    }
    
}
