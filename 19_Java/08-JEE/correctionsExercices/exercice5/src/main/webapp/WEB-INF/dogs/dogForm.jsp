<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/06/2024
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="mode" type="java.lang.String" scope="request" />
<jsp:useBean id="dog" type="org.example.exercice5.model.Dog" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/bootstrapimports.html" %>
    <title><%= mode.substring(0,1).toUpperCase()+mode.substring(1).toLowerCase() %> a Dog</title>
</head>
<body>
<main class="container">
    <div class="my-3 row">
        <div class="col-8 offset-2 p-3 rounded text-bg-dark">
            <h1 class="fw-light">-<%= mode.substring(0, 1).toUpperCase() + mode.substring(1).toLowerCase() %> a Dog-</h1>
            <hr>
            <form action="<%= mode.equals("add") ? "add" : "" %>" method="post">
                <input type="number" class="d-none" name="id" readonly>
                <div class="mb-3">
                    <label for="name" class="form-label">Name:</label>
                    <input type="text" name="name" id="name" class="form-control" value="<%= dog.getName() %>" <% if (mode.equals("add")) { %> required <% } else { %> readonly <% } %>>
                </div>
                <div class="mb-3">
                    <label for="breed" class="form-label">Breed:</label>
                    <input type="text" name="breed" id="breed" class="form-control" value="<%= dog.getBreed() %>" <% if (mode.equals("add")) { %> required <% } else { %> readonly <% } %>>
                </div>
                <div class="mb-3">
                    <label for="birthDate" class="form-label">Birth date:</label>
                    <input type="date" name="birthDate" id="birthDate" class="form-control" value="<%= dog.getBirthDate() %>" <% if (mode.equals("add")) { %> required <% } else { %> readonly <% } %>>
                </div>

                <hr>
                <div class="text-end">
                    <% if (mode.equals("add")) { %>
                    <button class="btn btn-outline-success"><i class="bi bi-plus-circle"></i> Add Dog</button>
                    <% } else { %>
                    <a href="${pageContext.request.contextPath}/dog/list" class="btn btn-outline-secondary"><i
                            class="bi bi-arrow-counterclockwise"></i>
                        Return</a>
                    <% }  %>
                </div>
            </form>
        </div>
    </div>
</main>
</body>
</html>
