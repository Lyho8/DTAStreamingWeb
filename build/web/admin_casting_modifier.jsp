<%-- 
    Document   : admin_casting_modifier
    Created on : 20 août 2015, 11:00:04
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
                <label>Id</label> <label>${monCasting.id}</label><br />
                <label>Titre</label><input name="nom" value="${monCasting.nom}" /><br />
                <input type="submit" value="Mettre à jour" />
            </form>

        </div>
        
        <div class="pied">
            <c:import url="_PIED.jsp" />
        </div>
        
    </body>
    
</html>

