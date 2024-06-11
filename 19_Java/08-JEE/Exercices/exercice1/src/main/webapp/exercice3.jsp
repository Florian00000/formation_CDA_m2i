<%@ page import="org.example.entities.Personne" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 11/06/2024
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="personnes" type="java.util.ArrayList<org.example.entities.Personne>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste de personnes</title>
    <%@include file="/WEB-INF/linkBootstrap.html" %>
</head>
<body>
<div class="container">
    <h1>Exercice 3</h1>
    <h2>Affichage de ma liste de personnes</h2>



    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Nom</th>
            <th scope="col">Prénom</th>
            <th scope="col">age</th>
        </tr>
        </thead>
        <tbody>
        <% for (Personne p : personnes) { %>
        <tr class="table-secondary">
            <th scope="row">#</th>
            <td> <%= p.getNom() %> </td>
            <td><%= p.getPrenom() %></td>
            <td><%= p.getAge() %></td>
        </tr>
        <% }%>



        </tbody>
    </table>
</div>




</body>
</html>
