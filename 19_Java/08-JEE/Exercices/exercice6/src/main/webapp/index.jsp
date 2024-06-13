<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <%@include file="/WEB-INF/linkBootstrap.html" %>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
<a href="user/login"><button class="btn btn-outline-info">Connexion</button></a>
<a href="user/signup"><button class="btn btn-outline-info">Inscription</button></a>
</body>
</html>