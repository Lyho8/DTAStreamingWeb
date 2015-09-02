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
@WebServlet(name = "SupprimerCastingServlet", urlPatterns = {"/casting_supprimer"})
public class SupprimerCastingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        //Récupère le casting
        CastingService cs = new CastingService();
        Casting c = cs.rechercher(Long.parseLong(req.getParameter("id")));
        
        cs.supprimer(c.getId());
        
        resp.sendRedirect("casting_lister");      
        
    }

}
