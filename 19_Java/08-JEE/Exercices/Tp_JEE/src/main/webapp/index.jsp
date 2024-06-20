
<% if ( (session.getAttribute("isLogged") != null) && ((boolean) session.getAttribute("isLogged"))) {
    response.sendRedirect(request.getContextPath()+"/patient");
} else {
    response.sendRedirect(request.getContextPath()+"/user/login");
 }%>