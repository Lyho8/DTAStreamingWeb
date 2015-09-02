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
public class GenreService {
    
    public void ajouter(Genre g){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        em.getTransaction().begin();
        
        em.persist(g);
        
        em.getTransaction().commit();
    }
    
    public void modifier(Genre g){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        em.getTransaction().begin();
        
        em.merge(g);
        
        em.getTransaction().commit();
    }
    
    public void supprimer(String id){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        em.getTransaction().begin();
        
        em.createQuery("DELETE FROM Genre g WHERE g.id=:idGenre").setParameter("idGenre", id).executeUpdate();
        
        em.getTransaction().commit();
    }
    
    public Genre rechercher(String id){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        return em.find(Genre.class, id);
    }
    
    public Collection<Genre> lister(){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        return em.createQuery("SELECT g FROM Genre g ORDER BY g.id").getResultList();
    }
    
}
