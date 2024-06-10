package org.example.exercice1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "servletA", value = "/servletA")
public class AServlet extends HttpServlet {

    // Une servlet qui renvoie du texte brut.


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Je suis dans un get !!!!");

        resp.setContentType("text/plain");
        PrintWriter writer = resp.getWriter();
        writer.println("<h2>Du texte ou une balise h2 ?</h2>");
        writer.println("réponse : du texte");
    }
}
