<%@ page import="org.example.exercice7.model.Image" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 18/06/2024
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="imageList" type="java.util.ArrayList<org.example.exercice7.model.Image>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <title>Galerie</title>
</head>
<body>
<a href="form" class="btn btn-warning">Ajouter une image</a>
<div class="row">
    <% for (Image i : imageList) {%>
    <div class="col-lg-4 col-md-12 mb-4 mb-lg-0">
        <img
                src="<%= i.getUrlImg() %>"
                class="w-100 shadow-1-strong rounded mb-4"
                alt="<%= i.getImgName() %>"
        />
    </div>
    <% }%>
</div>

</body>
</html>
