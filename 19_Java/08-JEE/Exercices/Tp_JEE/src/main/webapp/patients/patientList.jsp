<%@ page import="org.example.tp_jee.models.Patient" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.temporal.ChronoUnit" %>
<%@ page import="java.time.LocalDate" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 20/06/2024
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="patients" type="java.util.List<org.example.tp_jee.models.Patient>" scope="request"/>
<html>
<head>
    <title>Patients</title>
    <%@include file="/WEB-INF/linkBootstrap.html" %>
</head>
<body>

<%@include file="/WEB-INF/header.html" %>

<main class="container">
    <h1>Liste des patients</h1>

    <% if (!patients.isEmpty()) {%>
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">Photo</th>
            <th scope="col">Nom</th>
            <th scope="col">Prénom</th>
            <th scope="col">Date de naissance</th>
            <th scope="col">Age</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
        <% for (Patient p : patients) { %>

            <tr class="table-secondary" >

                <td><img src="<%=p.getPhoto()%>" alt="photo de <%=p.getName()%>" width="200">
                </td>
                <td><%= p.getName() %>
                </td>
                <td><%= p.getFirstName() %>
                </td>
                <td><%= p.getBirthDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) %>
                </td>
                <td><%=  ChronoUnit.YEARS.between(p.getBirthDate(), LocalDate.now()) %>
                </td>
                <td>
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/patient/detail?id=<%=p.getId()%>"> Détails</a>
                </td>

            </tr>

        <% }%>

        </tbody>
    </table>
    <% } else {%>
    <p> Pas de patients enregistrés</p>
    <%}%>

    <a href="${pageContext.request.contextPath}/patient/add">
        <button class="btn btn-outline-success">Ajouter un patient</button>
    </a>

</main>

</body>
</html>
