package org.example.demo_cookies_session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "checkCookieServlet",value = "/have-cookies")
public class CheckCookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html><body>");
        boolean logged = false;

        Cookie[] cookies = req.getCookies();

        for (Cookie c : cookies){
            if(c.getName().equals("isLogged") && c.getValue().equals("true")){
                out.println("<h1>Connecté </h1>");
                logged = true;
                break;
            }
        }

        if(!logged){
            out.println("<h1> Pas Connecté </h1>");
        }

        out.println("<h2> Vous avez "+cookies.length+" cookies </h2>");

        out.println("</body></html>");
    }
}
