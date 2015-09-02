/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dtastreaming.entity.*;
import dtastreaming.service.*;
import java.util.*;

/**
 *
 * @author ETY
 */
@WebServlet(name = "ListerFilmServlet", urlPatterns = {"/film_lister"})
public class ListerFilmServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //Récupère la liste des films
        Collection<Film> films = new FilmService().lister();
        
        //Renvoie vers JSP avec attributs contenant la collection de films
        req.setAttribute("mesFilms", films);
        
        req.getRequestDispatcher("admin_film_lister.jsp").forward(req, resp);
        
    }

    

}
