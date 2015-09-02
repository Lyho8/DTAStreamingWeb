/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.servlet;

import dtastreaming.entity.*;
import dtastreaming.service.*;
import java.io.*;
import java.util.*;
import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ETY
 */
@WebServlet(name = "RechercherFilmServlet", urlPatterns = {"/film_rechercher"})
public class RechercherFilmServlet extends HttpServlet {

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

        //Récupère la liste des filmcastings
        Collection<FilmCasting> filmcastings = new FilmCastingService().lister();

        //Renvoie vers JSP avec attributs contenant la collection de filmcastings
        req.setAttribute("mesFilmCastings", filmcastings);

        //Récupère la liste des castings
        Collection<Casting> castings = new CastingService().lister();

        //Renvoie vers JSP avec attributs contenant la collection de castings
        req.setAttribute("mesCastings", castings);

        req.getRequestDispatcher("user_film_rechercher.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //Récupère la liste des pays
        Collection<Pays> pays = new PaysService().lister();

        //Renvoie vers JSP avec attributs contenant la collection de pays
        req.setAttribute("mesPays", pays);

        //Récupère la liste des genres
        Collection<Genre> genres = new GenreService().lister();

        //Renvoie vers JSP avec attributs contenant la collection de genres
        req.setAttribute("mesGenres", genres);

        //Récupère la liste des filmcastings
        Collection<FilmCasting> filmcastings = new FilmCastingService().lister();

        //Renvoie vers JSP avec attributs contenant la collection de filmcastings
        req.setAttribute("mesFilmCastings", filmcastings);

        //Récupère la liste des castings
        Collection<Casting> castings = new CastingService().lister();

        //Renvoie vers JSP avec attributs contenant la collection de castings
        req.setAttribute("mesCastings", castings);
        
        int annee;
        if(req.getParameter("annee") == null || req.getParameter("annee").equals(""))
        {
            annee = -1;
        }
        else{
            annee = Integer.parseInt(req.getParameter("annee"));
        }
        
        //Récupère la liste des films
        FilmService fs = new FilmService();
        Collection<Film> fl = fs.rechercheMulti(req.getParameter("titre"), req.getParameter("pays"), annee, req.getParameter("genre"), req.getParameter("casting"));
        
        req.setAttribute("mesFilms", fl);
        
        req.getRequestDispatcher("user_film_rechercher.jsp").forward(req, resp);
        
        
        
    }
}
