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
public class FilmCastingService {
    
    public void ajouter(FilmCasting fc){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        em.getTransaction().begin();
        
        em.persist(fc);
        
        em.getTransaction().commit();
    }
    
    public void modifier(FilmCasting fc){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        em.getTransaction().begin();
        
        em.merge(fc);
        
        em.getTransaction().commit();
    }
    
    public void supprimer(long id){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        em.getTransaction().begin();

        em.createQuery("DELETE FROM FilmCasting fc WHERE fc.id=:idFilmCasting").setParameter("idFilmCasting", id).executeUpdate();
        
        em.getTransaction().commit();
    }
    
    public FilmCasting rechercher(long id){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        return em.find(FilmCasting.class, id);
    }
    
    public FilmCasting rechercher(long idf, long idc, Role r){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        return (FilmCasting) em.createQuery("SELECT fc FROM FilmCasting fc WHERE film_id=:idf AND casting_id=:idc AND rolecasting=:r").setParameter("r", r).setParameter("idf", idf).setParameter("idc", idc).getSingleResult();
    }
    
    public Collection<FilmCasting> lister(){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        return em.createQuery("SELECT fc FROM FilmCasting fc ORDER BY fc.id").getResultList();
    }
    
}
