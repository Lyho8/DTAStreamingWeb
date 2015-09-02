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
@WebServlet(name = "ListerPaysServlet", urlPatterns = {"/pays_lister"})
public class ListerPaysServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //Récupère la liste des films
        Collection<Pays> pays = new PaysService().lister();
        
        //Renvoie vers JSP avec attributs contenant la collection de genres
        req.setAttribute("mesPays", pays);
        req.getRequestDispatcher("admin_pays_lister.jsp").forward(req, resp);
    }

}
