<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.temporal.ChronoUnit" %>
<%@ page import="java.time.LocalDate" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 20/06/2024
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="patient" type="org.example.tp_jee.models.Patient" scope="request"/>
<html>
<head>
    <title>Patient Détails</title>
    <%@include file="/WEB-INF/linkBootstrap.html" %>
</head>
<body>

<%@include file="/WEB-INF/header.html" %>
    <main class="container " >
        <div class="card mb-3 w-50 mx-auto mt-3">
            <h3 class="card-header"><%=patient.getName()%> <%=patient.getFirstName()%></h3>
            <div class="card-body">
                <h5 class="card-title"><%= patient.getBirthDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) %></h5>
                <h6 class="card-subtitle text-muted"><%=  ChronoUnit.YEARS.between(patient.getBirthDate(), LocalDate.now()) %> ans</h6>
            </div>
<%--            <svg xmlns="http://www.w3.org/2000/svg" class="d-block user-select-none" width="100%" height="200" aria-label="Placeholder: Image cap" focusable="false" role="img" preserveAspectRatio="xMidYMid slice" viewBox="0 0 318 180" style="font-size:1.125rem;text-anchor:middle">--%>
<%--                <rect width="100%" height="100%" fill="#868e96"></rect>--%>
<%--                <text x="50%" y="50%" fill="#dee2e6" dy=".3em">Image cap</text>--%>
<%--            </svg>--%>
            <img src="<%=patient.getPhoto()%>" alt="photo de <%=patient.getName()%>" width="100%" >
            <div class="card-body">
                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">Cras justo odio</li>
                <li class="list-group-item">Dapibus ac facilisis in</li>
                <li class="list-group-item">Vestibulum at eros</li>
            </ul>
            <div class="card-body">
                <a href="#" class="card-link">Card link</a>
                <a href="#" class="card-link">Another link</a>
            </div>
            <div class="card-footer text-muted">
                2 days ago
            </div>
        </div>
        <div class="card w-50 mx-auto">
            <div class="card-body">
                <h4 class="card-title">Card title</h4>
                <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                <a href="#" class="card-link">Card link</a>
                <a href="#" class="card-link">Another link</a>
            </div>
        </div>
    </main>

</body>
</html>
