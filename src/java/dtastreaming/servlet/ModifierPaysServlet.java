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
@WebServlet(name = "ModifierPaysServlet", urlPatterns = {"/pays_modifier"})
public class ModifierPaysServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //Récupère le pays
        Pays p = new PaysService().rechercher(req.getParameter("id"));
        
        //Renvoie vers JSP avec attributs contenant le pays
        req.setAttribute("monPays", p);
        req.getRequestDispatcher("admin_pays_modifier.jsp").forward(req, resp);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //Récupère le pays
        PaysService ps = new PaysService();
        Pays p = ps.rechercher(req.getParameter("id"));
        
        p.setId(req.getParameter("newid"));
        ps.modifier(p);
        ps.supprimer(req.getParameter("id"));
        
        resp.sendRedirect("pays_lister");
        
    }

}
