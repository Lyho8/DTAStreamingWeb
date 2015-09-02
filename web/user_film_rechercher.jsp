<%-- 
    Document   : user_film_rechercher
    Created on : 21 août 2015, 10:14:35
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
                <label>Titre</label><input name="titre" /><br />
                <label>Année</label><input name="annee" /><br />
                <label>Pays</label>
                <select name="pays">
                    <option value="Aucun">Aucun</option>
                    <c:forEach items="${requestScope.mesPays}" var="monPays">
                        <option value="${monPays.id}">${monPays.id}</option>
                    </c:forEach>
                </select><br />
                <label>Genre</label><select name="genre">
                    <option value="Aucun">Aucun</option>
                    <c:forEach items="${requestScope.mesGenres}" var="monGenre">
                        <option value="${monGenre.id}">${monGenre.id}</option>
                    </c:forEach>
                </select><br />
                <label>Casting</label><input name="casting" /><br />
                <input type="submit" value="Rechercher" />
            </form>
            
            <ul>
                <c:forEach items="${requestScope.mesFilms}" var="monFilm">
                    <li>${monFilm.titre} : <c:forEach items="${monFilm.genres}" var="genre">${genre.id}</c:forEach> ${monFilm.pays.id} (${monFilm.annee}) ${monFilm.duree}min</li>
                </c:forEach>
            </ul>

        </div>
        
        <div class="pied">
            <c:import url="_PIED.jsp" />
        </div>
        
    </body>
    
</html>
