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
@WebServlet(name = "ModifierGenreServlet", urlPatterns = {"/genre_modifier"})
public class ModifierGenreServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //Récupère le genre
        Genre g = new GenreService().rechercher(req.getParameter("id"));
        
        //Renvoie vers JSP avec attributs contenant le genre
        req.setAttribute("monGenre", g);
        req.getRequestDispatcher("admin_genre_modifier.jsp").forward(req, resp);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //Récupère le genre
        GenreService gs = new GenreService();
        Genre g = gs.rechercher(req.getParameter("id"));
        
        g.setId(req.getParameter("newid"));
        gs.modifier(g);
        gs.supprimer(req.getParameter("id"));
        
        resp.sendRedirect("genre_lister");
        
    }

}
