<%-- 
    Document   : admin_genre_ajouter
    Created on : 20 août 2015, 10:24:44
    Author     : ETY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    
    <head>
        <c:import url="_STYLESHEETS.jsp" />
        <c:import url="_JAVASCRIPTS.jsp" />
    </head>

    <body>
        
        <div class="menu">
            <c:import url="_MENU.jsp" />
        </div>
        
        <div class="contenu">
            
            <form method="post">
                <label>Id</label> <input name="id" /><br />
                <input type="submit" value="Ajouter" />
            </form>

        </div>
        
        <div class="pied">
            <c:import url="_PIED.jsp" />
        </div>
        
    </body>
    
</html>
