<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 17/06/2024
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/bootstrapimports.html" %>
    <title>Login</title>
</head>
<body>

<div class="container d-flex flex-column justify-content-center h-100 w-50">
    <h2> Login </h2>
    <form action="signin" method="post">
        <div class="mb-3">
            <label for="email" class="form-label">email</label>
            <input type="text" class="form-control" id="email" name="inputEmail">
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">password</label>
            <input type="password" class="form-control" id="password" name="inputPassword">
        </div>

        <button type="submit" class="btn btn-primary">Login</button>
        <p><a href="${pageContext.request.contextPath}/user/pagesignup">s'inscrire</a></p>
    </form>
</div>

</body>
</html>