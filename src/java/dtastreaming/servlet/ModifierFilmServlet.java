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
@WebServlet(name = "ModifierFilmServlet", urlPatterns = {"/film_modifier"})
public class ModifierFilmServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //Récupère le film
        Film f = new FilmService().rechercher(Long.parseLong(req.getParameter("id")));
        
        //Renvoie vers JSP avec attributs contenant la collection de films
        req.setAttribute("monFilm", f);
        req.getRequestDispatcher("admin_film_modifier.jsp").forward(req, resp);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        
        
        
        

        
        
        
        //Récupère le film
        FilmService fs = new FilmService();
        Film f = fs.rechercher(Long.parseLong(req.getParameter("id")));
        
        f.setTitre(req.getParameter("titre"));
        f.setAnnee(Integer.parseInt(req.getParameter("annee")));
        f.setDuree(Integer.parseInt(req.getParameter("duree")));
        f.setResume(req.getParameter("resume"));
        
        GenreService gs = new GenreService();
        Genre g = gs.rechercher(req.getParameter("genre"));
        f.getGenres().add(g);
        
        PaysService ps = new PaysService();
        Pays p = ps.rechercher(req.getParameter("pays"));
        f.setPays(p);
        
        fs.modifier(f);
        
        String[] castings = req.getParameter("casting").split(",");
        FilmCastingService fcs = new FilmCastingService();
        CastingService cs = new CastingService();
        
        for(int i=0;i<castings.length;i++){
            Casting c = cs.rechercher(castings[i]);
            Role r = Role.PRODUCTEUR;
            if(req.getParameter("role").equals("acteur")){
                r = Role.ACTEUR;
            }
            else if(req.getParameter("role").equals("realisateur")){
                r = Role.REALISATEUR;
            }
            
            if(c == null){
                c = new Casting();
                FilmCasting fc = new FilmCasting();
                fc.setRole(r);
                c.setNom(castings[i]);                
                fc.setCasting(c);
                fcs.ajouter(fc);
            }
            
            else{
                if(fcs.rechercher(f.getId(), c.getId(), r) == null){
                    FilmCasting fc = new FilmCasting();
                    fc.setFilm(f);
                    fc.setRole(r);                    
                    fc.setCasting(c);
                    fcs.ajouter(fc);
                }
            }
        }
        

        resp.sendRedirect("film_lister");
        
    }

}
