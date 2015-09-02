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
@WebServlet(name = "ModifierCastingServlet", urlPatterns = {"/casting_modifier"})
public class ModifierCastingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //Récupère le Casting
        Casting c = new CastingService().rechercher(Long.parseLong(req.getParameter("id")));
        
        //Renvoie vers JSP avec attributs contenant le casting
        req.setAttribute("monCasting", c);
        req.getRequestDispatcher("admin_casting_modifier.jsp").forward(req, resp);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //Récupère le casting
        CastingService cs = new CastingService();
        Casting c = cs.rechercher(Long.parseLong(req.getParameter("id")));
        
        c.setNom(req.getParameter("nom"));
        cs.modifier(c);
        
        resp.sendRedirect("casting_lister");
        
    }

}
