<%-- 
    Document   : admin_film_modifier
    Created on : 19 août 2015, 16:36:20
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
                <label>Id</label> <label>${monFilm.id}</label><br />
                <label>Titre</label><input name="titre" value="${monFilm.titre}" /><br />
                <label>Année</label><input name="annee" value="${monFilm.annee}" /><br />
                <label>Durée</label><input name="duree" value="${monFilm.duree}" /><br />
                <label>Résumé</label><input name="resume" value="${monFilm.resume}" /><br />
                <label>Pays</label><input name="pays" value="${monFilm.pays.id}" /><br />
                <label>Genre</label><input name="genre" value="${monFilm.genre.id}"/><br />
                <label>Casting (nom,nom,nom,...)</label><input name="casting" /> <label>Rôle</label> <select name="role">
                        <option value="acteur">Acteur</option>
                        <option value="realisateur">Réalisateur</option>
                </select><br />
                <input type="submit" value="Mettre à jour" />
            </form>

        </div>
        
        <div class="pied">
            <c:import url="_PIED.jsp" />
        </div>
        
    </body>
    
</html>
