<%@ page import="org.example.exercice5.entities.Chien" %>
<%@ page import="java.time.format.DateTimeFormatter" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 12/06/2024
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="chiens" type="java.util.ArrayList<org.example.exercice5.entities.Chien>" scope="request"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/WEB-INF/linkBootstrap.html" %>
</head>
<body>
    <div class="container">
        <h1>Des chiens, des chiens et des chiens.</h1>

        <% if (!chiens.isEmpty()) {%>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nom</th>
                    <th scope="col">Race</th>
                    <th scope="col">Date de naissance</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                <% for ( Chien c : chiens) { %>
                <tr class="table-secondary">
                    <th scope="row">#</th>
                    <td><%= c.getNom() %> </td>
                    <td><%= c.getRace() %></td>
                    <td><%= c.getDateNaissance().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) %></td>
                    <td><a href="chienForm/<%=c.getId()%>"><button class="btn btn-outline-info">Détails </button></a> </td>
                </tr>
                <% }%>

                </tbody>
            </table>
        <% } else {%>
            <p> Pas de chiens enregistrés</p>
        <%}%>

        <a href="chienForm"><button class="btn btn-outline-success">Ajouter un chien </button></a>

    </div>

</body>
</html>
