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
import javax.servlet.http.*;

/**
 *
 * @author ETY
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        for(Cookie c: req.getCookies()){
//            if(c.getName().equals("login")){
//                resp.addCookie(new Cookie("login", ""));
//            }
//        }
        
        req.getSession().setAttribute("login", "");
        
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        
//        if(req.getParameter("login").equals("admin") && req.getParameter("pwd").equals("admin")){
//            resp.addCookie(new Cookie("login", "admin"));
//            resp.sendRedirect("film_lister");
//        }
//        else if(!req.getParameter("login").equals("admin")){
//            resp.addCookie(new Cookie("login", req.getParameter("login")));
//            resp.sendRedirect("film");
//        }
//        else{
//            resp.sendRedirect("login");
//        }
        
        if(req.getParameter("login").equals("admin") && req.getParameter("pwd").equals("admin")){
            req.getSession().setAttribute("login", "admin");
            resp.sendRedirect("film_lister");
        }
        else if(!req.getParameter("login").equals("admin")){
            req.getSession().setAttribute("login", req.getParameter("login"));
            resp.sendRedirect("film");
        }
        else{
            resp.sendRedirect("login");
        }
        
        
        
        
        
    }

}
