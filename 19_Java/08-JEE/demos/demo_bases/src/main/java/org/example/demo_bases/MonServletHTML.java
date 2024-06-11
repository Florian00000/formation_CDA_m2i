package org.example.demo_bases;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "monServletHTML",value = "/monservlet-html")
public class MonServletHTML extends HttpServlet {


    private String prenom;

    @Override
    public void init() throws ServletException {
        prenom = "toto";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();
        writer.println("<h1>Le prénom est : "+prenom+"</h1>");
    }
}
