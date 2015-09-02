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
@WebServlet(name = "SupprimerPaysServlet", urlPatterns = {"/pays_supprimer"})
public class SupprimerPaysServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        //Récupère le pays
        PaysService ps = new PaysService();
        Pays p = ps.rechercher(req.getParameter("id"));
        
        ps.supprimer(p.getId());
        resp.sendRedirect("pays_lister");

    }

}
