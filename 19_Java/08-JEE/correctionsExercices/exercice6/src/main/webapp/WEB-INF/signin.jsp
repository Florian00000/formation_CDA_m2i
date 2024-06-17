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
    <title>Login</title>
</head>
<body>

<h2>Login</h2>
<form action="signin" method="post">
    <div>
        <label for="email" >Email</label>
        <input type="text" id="email" name="inputEmail">
    </div>
    <div>
        <label for="password" >password</label>
        <input type="password" id="password" name="inputPassword">
    </div>
    <button>Login</button>
</form>

</body>
</html>
