package org.example.demo_bases;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "variableServlet", value = "/variables")
public class VariablesServlet extends HttpServlet {

    private String prenom;
    private String nom;
    private List<String> prenoms;

    @Override
    public void init() throws ServletException {
        prenom = "Dorian";
        nom = "toto";
        prenoms = new ArrayList<>();
        prenoms.add("Mohamed");
        prenoms.add("Mounir");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("prenom",prenom);
        req.setAttribute("prenoms",prenoms);
        req.setAttribute("nom",nom);
        getServletContext().getRequestDispatcher("/variables.jsp").forward(req,resp);
    }
}
