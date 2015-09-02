<%-- 
    Document   : admin_genre_lister
    Created on : 19 août 2015, 16:14:51
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
            <c:forEach items="${requestScope.mesGenres}" var="monGenre">
                ${monGenre.id} <a href="genre_modifier?id=${monGenre.id}">Modifier</a> <a href="genre_supprimer?id=${monGenre.id}">Supprimer</a>
                <br>
            </c:forEach>
            <a href="genre_ajouter">Ajouter</a>
        </div>
        
        <div class="pied">
            <c:import url="_PIED.jsp" />
        </div>
        
    </body>
    
</html>