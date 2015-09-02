<%-- 
    Document   : admin_film_lister
    Created on : 19 août 2015, 14:42:00
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
            <c:forEach items="${requestScope.mesFilms}" var="monFilm">
                ${monFilm.titre} <a href="film_modifier?id=${monFilm.id}">Modifier</a> <a href="film_supprimer?id=${monFilm.id}">Supprimer</a>
                <br>
            </c:forEach>
            <a href="film_ajouter">Ajouter</a>
        </div>
        
        <div class="pied">
            <c:import url="_PIED.jsp" />
        </div>
        
    </body>
    
</html>
