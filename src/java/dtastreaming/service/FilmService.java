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
public class FilmService {
    
    public void ajouter(Film f){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        em.getTransaction().begin();
        
        em.persist(f);
        
        em.getTransaction().commit();
    }
    
    public void modifier(Film f){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        em.getTransaction().begin();
        
        em.merge(f);
        
        em.getTransaction().commit();
    }
    
    public void supprimer(long id){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        em.getTransaction().begin();
        
        //On n'a besoin que de l'id pour trouver le film à supprimer.
//        Film f = new Film();
//        f.setId(id);
//        em.remove(f);
        em.createQuery("DELETE FROM Film f WHERE f.id=:idFilm").setParameter("idFilm", id).executeUpdate();
        
        em.getTransaction().commit();
    }
    
    public Film rechercher(long id){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        return em.find(Film.class, id);
    }
    
    public Collection<Film> lister(){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        return em.createQuery("SELECT f FROM Film f ORDER BY f.titre").getResultList();
//        return em.createQuery("SELECT f FROM Film f ORDER BY f.titre").setMaxResults(3).setFirstResult(2).getResultList();
    }
    
    public Collection<Film> rechercheMulti(String titre, String pays, Integer annee, String genre, String casting){
        
        String titreReq = "";
        String paysReq = "";
        String anneeReq = "";
        String genreReq = "";
        String castingReq = "";
        
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        if(pays != null && !pays.equals("") && !pays.equals("Aucun"))
        {
            paysReq = "AND fi.pays=:p";
        }
        
        if(titre != null && !titre.equals(""))
        {
            titreReq = "AND fi.titre LIKE :t";
        }
        
        
        
        if(annee != -1)
        {
            anneeReq = "AND fi.annee=:a";
        }
        
        if(casting != null && !casting.equals(""))
        {
            castingReq = "AND fi "
                + "                         IN (    SELECT f "
                + "                                 FROM Film f "
                + "                                 JOIN f.filmcastings fc "
                + "                                 JOIN fc.casting c "
                + "                                 WHERE fc.film=f "
                + "                                 AND fc.casting=c "
                + "                                 AND c.nom=:cn"
                + "                             )";
        }
        
        if(genre != null && !genre.equals("") && !genre.equals("Aucun"))
        {
            genreReq = "AND fg.id=:g ";
        }
        

        Query q = em.createQuery(("  SELECT fi FROM Film fi JOIN fi.genres fg"
                + "                     WHERE 1=1 "
                + genreReq
                + paysReq
                + titreReq
                + anneeReq
                + castingReq
                + "                     ").replace(" 1=1 AND", ""));
               
        if(!titreReq.equals("")){
            q.setParameter("t", "%"+titre+"%");
        }
        
        if(!anneeReq.equals("")){
            q.setParameter("a", annee);
        }
        
        if(!genreReq.equals(""))
        {
            q.setParameter("g", genre);
        }
        
        if(!castingReq.equals("")){
            q.setParameter("cn", casting);
        }
        
        if(!paysReq.equals(""))
        {
            PaysService ps = new PaysService();
            Pays p = ps.rechercher(pays);
            q.setParameter("p", p);
        }
        
        Collection<Film> fl = q.getResultList();
                
        return fl;
    }
    
}
