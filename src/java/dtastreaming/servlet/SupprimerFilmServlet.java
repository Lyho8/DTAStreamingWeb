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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ETY
 */
@WebServlet(name = "SupprimerFilmServlet", urlPatterns = {"/film_supprimer"})
public class SupprimerFilmServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        //Récupère le film
        FilmService fs = new FilmService();
        Film f = fs.rechercher(Long.parseLong(req.getParameter("id")));

        fs.supprimer(f.getId());
        
        resp.sendRedirect("film_lister");

    }
    
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        
//        //Récupère le film
//        FilmService fs = new FilmService();
//        
//        Film f = new Film();
//        f.setTitre(req.getParameter("titre"));
//        f.setAnnee(Integer.parseInt(req.getParameter("annee")));
//        f.setDuree(Integer.parseInt(req.getParameter("duree")));
//        f.setResume(req.getParameter("resume"));
//        fs.ajouter(f);
//        
//        resp.sendRedirect("film_lister");
//        
//    }

}
