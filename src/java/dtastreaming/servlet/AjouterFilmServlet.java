/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.servlet;

import dtastreaming.entity.*;
import dtastreaming.service.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Clock;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ETY
 */
@WebServlet(name = "AjouterFilmServlet", urlPatterns = {"/film_ajouter"})
public class AjouterFilmServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        //Récupère la liste des pays
        Collection<Pays> pays = new PaysService().lister();
        
        //Renvoie vers JSP avec attributs contenant la collection de pays
        req.setAttribute("mesPays", pays);
        
        //Récupère la liste des genres
        Collection<Genre> genres = new GenreService().lister();
        
        //Renvoie vers JSP avec attributs contenant la collection de genres
        req.setAttribute("mesGenres", genres);
        
        req.getRequestDispatcher("admin_film_ajouter.jsp").forward(req, resp);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //Récupère le film
        FilmService fs = new FilmService();
        
        Film f = new Film();
        f.setTitre(req.getParameter("titre"));
        f.setAnnee(Integer.parseInt(req.getParameter("annee")));
        f.setDuree(Integer.parseInt(req.getParameter("duree")));
        f.setResume(req.getParameter("resume"));
        
        GenreService gs = new GenreService();
        Genre g = gs.rechercher(req.getParameter("genre"));
//        if(g == null){
//            g = new Genre();
//            g.setId(req.getParameter("genre"));
//        }
//        g.getFilms().add(f);
//        gs.modifier(g);
//        f.setGenre(g);
        f.getGenres().add(g);
        
        PaysService ps = new PaysService();
        Pays p = ps.rechercher(req.getParameter("pays"));
        
//        p.getFilms().add(f); 
//        ps.modifier(p);
        f.setPays(p);

        fs.ajouter(f);
        
        String[] castings = req.getParameter("casting").split(",");
        FilmCastingService fcs = new FilmCastingService();
        CastingService cs = new CastingService();
        for(int i=0;i<castings.length;i++){
            FilmCasting fc = new FilmCasting();
            
            if(req.getParameter("role").equals("acteur")){
                fc.setRole(Role.ACTEUR);
            }
            else if(req.getParameter("role").equals("realisateur")){
                fc.setRole(Role.REALISATEUR);
            }

            fc.setFilm(f);            
            
            Casting c = cs.rechercher(castings[i]);
            if(c == null){
                c = new Casting();    
                c.setNom(castings[i]);
                cs.ajouter(c);
            }
            
            fc.setCasting(c);
            fcs.ajouter(fc);
        }
        
        
        

        
        resp.sendRedirect("film_lister");
        
    }

}
