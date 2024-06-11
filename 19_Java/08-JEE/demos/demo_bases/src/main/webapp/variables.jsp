<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 11/06/2024
  Time: 09:51
  To change this template use File | Settings | File Templates.
--%>

<!-- Ceci est un commentaire -->
<jsp:useBean id="prenom" type="java.lang.String" scope="request" />
<jsp:useBean id="prenoms" type="java.util.ArrayList<java.lang.String>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mes Variables</title>
</head>
<body>

<h1>Affichages de mes variables</h1>

<!-- Avec Expression language EL -->
<p>Bonjour ${nom}</p>

<hr>
<!-- Avec Expression language EL avec usebean -->
<p>${prenom.toUpperCase()}</p>


<hr>
<!-- Avec Scriplet JSP -->

<% for (String p : prenoms) { %>
    <p> <%= p %> </p>
    <p> <%= new Date() %> </p>
 <% } %>



</body>
</html>
