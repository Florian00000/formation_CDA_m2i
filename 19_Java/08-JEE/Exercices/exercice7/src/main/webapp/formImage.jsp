<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 18/06/2024
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="images" type="java.util.List<java.lang.String>" scope="request"/>
<html>
<head>
    <title>Images</title>
</head>
<body>

<form action="image" method="post" enctype="multipart/form-data">
    <div>
        <input type="file" name="image">
    </div>

    <button>Envoyer</button>

</form>

<% for (String i : images) { %>
    <img src="<%=i%>" alt="imageUploaded" sizes="10">
<% } %>

</body>
</html>
