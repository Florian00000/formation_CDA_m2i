<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <%@include file="/WEB-INF/linkBootstrap.html" %>
</head>
<body class="bg-dark bg-gradient">
<h1 style="color: chartreuse"><%= "Hello World!" %></h1>
<br/>
<a href="hello-servlet">Hello Servlet</a> <br>
<a href="servletA">Servlet A</a> <br>
<a href="servletB">Servlet B</a> <br>
<a href="servletC">Servlet C</a> <br>
<h2 style="color: chartreuse">exercice2</h2>
<a href="exercice2/servletA"> page 1</a>
<a href="exercice2/servletB"> page 2</a>
<h2 style="color: chartreuse">exercice3</h2>
<a href="exercice3/listePersonnes"> page listPersonnes</a>
</body>
</html>