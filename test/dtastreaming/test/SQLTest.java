/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.test;

import dtastreaming.entity.*;
import dtastreaming.service.*;
import java.util.*;
import javax.persistence.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ETY
 */
public class SQLTest {
    
    public SQLTest() {       
    }
    
//    @Test
    public void ListerFilmParPays(){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        em.getTransaction().begin();
        
        PaysService ps = new PaysService();
        
        Pays p = ps.rechercher("France");

        Object[] fl = em.createQuery("SELECT f FROM Film f WHERE f.pays=:p").setParameter("p", p).getResultList().toArray();

        em.getTransaction().commit();
        
        for(Object f : fl){
            System.out.println(((Film)f).getTitre() + " " + ((Film)f).getPays().getId());
        }
    }
    
//    @Test
    public void ListerFilmParGenre(){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        em.getTransaction().begin();
        
        GenreService gs = new GenreService();
        
        Genre g = gs.rechercher("Action");

        Object[] fl = em.createQuery("SELECT f FROM Film f WHERE f.genre=:g").setParameter("g", g).getResultList().toArray();

        em.getTransaction().commit();
        
        for(Object f : fl){
            for(Genre gf : ((Film)f).getGenres())
            System.out.println(((Film)f).getTitre() + " " + gf.getId());
        }
        
        //A faire quand on a bien une ManyToMany
        //Jointure EJBQL : SELECT f FROM Film f JOIN f.genres g WHERE g.id='action'
        //Film f en premier après le FROM nécessaire en EJBQL
        
    }
    
//    @Test
    public void ListerFilmParPaysEtGenre(){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        em.getTransaction().begin();
        
        PaysService ps = new PaysService();
        
        GenreService gs = new GenreService();
        
        Genre g = gs.rechercher("Action");
        
        Pays p = ps.rechercher("France");

        Object[] fl = em.createQuery("SELECT f FROM Film f WHERE f.pays=:p AND f.genre=:g").setParameter("p", p).setParameter("g", g).getResultList().toArray();

        em.getTransaction().commit();
        for(Object f : fl){
            for(Genre gf : ((Film)f).getGenres())
            {
                System.out.println(((Film)f).getTitre() + " " + ((Film)f).getPays().getId()+ " " + gf.getId());
            }
        }
        
        //SELECT f FROM Film f JOIN f.pays p JOIN f.genres g WHERE p.id='France' AND g.id='Action'
        
    }
    
//    @Test
    public void ListerFilmSansLien(){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        em.getTransaction().begin();

        //Object[] fl = em.createQuery("SELECT f FROM Film f LEFT JOIN Lien l ON l.film = f WHERE l IS NULL").getResultList().toArray();
        Object[] fl = em.createQuery("SELECT f FROM Film f WHERE (SELECT COUNT(l) FROM Lien l WHERE l.film = f) = 0").getResultList().toArray();
        
        em.getTransaction().commit();
        
        for(Object f : fl){
            System.out.println(((Film)f).getTitre() + " no link~");
        }
    }
    
//    @Test
    public void ListerFilmHorsListeFilmSansLien(){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        em.getTransaction().begin();

        Object[] fl = em.createQuery("SELECT f FROM Film f WHERE f NOT IN (SELECT f FROM Film f WHERE (SELECT COUNT(l) FROM Lien l WHERE l.film = f) = 0)").getResultList().toArray();
        
        em.getTransaction().commit();
        
        for(Object f : fl){
            System.out.println(((Film)f).getTitre() + "not no link~");
        }
    }
    
    @Test
    public void ListerFilmBullshit(){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        em.getTransaction().begin();
        //Films de Tarantino
        //Object[] fl = em.createQuery("SELECT f FROM Film f JOIN f.filmcastings fc JOIN fc.casting c WHERE fc.film=f AND fc.casting=c AND c.nom='Quentin Tarantino'").getResultList().toArray();
        
        Object[] fl = em.createQuery("  SELECT fi FROM Film fi JOIN fi.genres fg"
                + "                     WHERE fg NOT IN "
                + "                     (   SELECT g "
                + "                         FROM Genre g "
                + "                         JOIN g.films gf "
                + "                         WHERE gf "
                + "                         IN (    SELECT f "
                + "                                 FROM Film f "
                + "                                 JOIN f.filmcastings fc "
                + "                                 JOIN fc.casting c "
                + "                                 WHERE fc.film=f "
                + "                                 AND fc.casting=c "
                + "                                 AND c.nom='Quentin Tarantino'"
                + "                             )"
                + "                      )"
                + "                     ").getResultList().toArray();
        
        
        em.getTransaction().commit();
        
        System.out.println("\n\nFilm dont le genre ne fait pas partie des genres réalisés par Tarantino :");
        for(Object f : fl){
            for(Genre gg : ((Film)f).getGenres()){
                System.out.println(((Film)f).getTitre() + " " + gg.getId() + " ez");
            }
        }
    }
    
    
    @Test
    public void ListerFilmBullshit2(){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        em.getTransaction().begin();
        //Films de Tarantino
        //Object[] fl = em.createQuery("SELECT f FROM Film f JOIN f.filmcastings fc JOIN fc.casting c WHERE fc.film=f AND fc.casting=c AND c.nom='Quentin Tarantino'").getResultList().toArray();
        
        Object[] fl = em.createQuery("  SELECT fi FROM Film fi JOIN fi.genres fg"
                + "                     WHERE fg.id='Action' "
                + "                     AND fi "
                + "                         IN (    SELECT f "
                + "                                 FROM Film f "
                + "                                 JOIN f.filmcastings fc "
                + "                                 JOIN fc.casting c "
                + "                                 WHERE fc.film=f "
                + "                                 AND fc.casting=c "
                + "                                 AND c.nom='Quentin Tarantino'"
                + "                             )"
                + "                     ").getResultList().toArray();
        
        
        em.getTransaction().commit();
        
        System.out.println("\n\nFilm de genre Action jouées par Tarantino");
        for(Object f : fl){
            for(Genre gg : ((Film)f).getGenres()){
                System.out.println(((Film)f).getTitre() + " " + gg.getId() + " ez");
            }
        }
    }
    
    @Test
    public void ListerFilmKungFu(){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingWebPU").createEntityManager();
        
        em.getTransaction().begin();
        
        PaysService ps = new PaysService();
        Pays p = ps.rechercher("Coree du Sud");

        Object[] fl = em.createQuery("  SELECT fi FROM Film fi JOIN fi.genres fg"
                + "                     WHERE fg.id='Kung-Fu' "
                + "                     AND fi.pays=:p"
                + "                     AND fi.titre LIKE '%dragon%'"
                + "                     AND fi.annee=2005"
                + "                     AND fi "
                + "                         IN (    SELECT f "
                + "                                 FROM Film f "
                + "                                 JOIN f.filmcastings fc "
                + "                                 JOIN fc.casting c "
                + "                                 WHERE fc.film=f "
                + "                                 AND fc.casting=c "
                + "                                 AND c.nom='Jet Li'"
                + "                             )"
                + "                     ").setParameter("p", p).getResultList().toArray();
        
        em.getTransaction().commit();
        
        System.out.println("\n\nFilms de Kung-Fu avec Jet Li, \"dragon\" dans le titre, sortis en 2005 et d'origine sud-coréenne");
        for(Object f : fl){
            System.out.println(((Film)f).getTitre() + " kung fu~");
        }
    }
    
}
   

